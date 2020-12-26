package Day3;

import Utils.Print;
import Utils.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        slopes.add(new Slope(1, 1));
        slopes.add(new Slope(3, 1));
        slopes.add(new Slope(5, 1));
        slopes.add(new Slope(7, 1));
        slopes.add(new Slope(1, 2));


        for (int i = 0; i < slopes.size(); i++) {

            int finalI = i;

            executor.submit(() -> {

                int answer = 0;

                Slope slope = slopes.get(finalI);

                int rightIndex = slope.rightIndex;
                int downIndex = slope.downIndex;

                for (; downIndex < height;
                     downIndex += slope.downIndex, rightIndex = (rightIndex + slope.rightIndex) % width) {

                    char[] line = fileContent.get(downIndex);

                    if (line[rightIndex] == '#')
                        answer++;
                }

                slope.setAnswer(answer);

            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            //idk
        }

        int answer = 1;

        for (Slope slope : slopes)
            answer *= slope.answer;


        Print.print(answer);

    }

    private static class Slope {

        private final int rightIndex;
        private final int downIndex;
        private int answer;

        public Slope(int rightIndex, int downIndex) {
            this.rightIndex = rightIndex;
            this.downIndex = downIndex;
            this.answer = 0;
        }


        public void setAnswer(int answer) {
            this.answer = answer;
        }

    }
}
