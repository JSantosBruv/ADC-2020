package Day3;

import Utils.Print;
import Utils.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Day3Part2 extends Solution {


    public Day3Part2(String fileName) {

        super(fileName);
        solution();
    }

    @Override
    public void solution() {

        List<char[]> fileContent = readFileToCharMatrix();

        int width = fileContent.get(0).length;
        int height = fileContent.size();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Slope> slopes = new ArrayList<>();
        slopes.add(new Slope(1, 1, fileContent));
        slopes.add(new Slope(3, 1, fileContent));
        slopes.add(new Slope(5, 1, fileContent));
        slopes.add(new Slope(7, 1, fileContent));
        slopes.add(new Slope(1, 2, fileContent));


        AtomicInteger answer = new AtomicInteger(1);

        slopes.forEach(value -> {

            executor.submit(() -> {

                int slopeAnswer = value.findTrees(height, width);

                answer.updateAndGet(x -> slopeAnswer * x);

            });
        });


        executor.shutdown();

        while (!executor.isTerminated())
            ;    //active wait


        Print.print(answer);

    }

    private static class Slope {

        private final int rightIndex;
        private final int downIndex;
        private int answer;

        private final List<char[]> fileContent;

        public Slope(int rightIndex, int downIndex, List<char[]> fileContent) {
            this.rightIndex = rightIndex;
            this.downIndex = downIndex;
            this.answer = 0;

            this.fileContent = fileContent;
        }

        int findTrees(int height, int width) {

            int mutableDownIndex = downIndex;
            int mutableRightIndex = rightIndex;

            for (; mutableDownIndex < height;
                 mutableDownIndex += downIndex, mutableRightIndex = (mutableRightIndex + rightIndex) % width) {

                char[] line = fileContent.get(mutableDownIndex);

                if (line[mutableRightIndex] == '#')
                    answer++;
            }


            return answer;
        }


    }
}
