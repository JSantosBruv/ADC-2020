package Day1;

import Utils.Print;
import Utils.Solution;

import java.util.List;

public class Day1Part1 extends Solution {


    public Day1Part1(String fileName) {

        super(fileName);
        solution();
    }

    @Override
    public void solution() {


        List<String> result = readFileToList();

        int size = result.size();

        for (int i = 0; i < size - 1; i++) {

            int currentValue = Integer.parseInt(result.get(i));

            for (int j = i + 1; j + 1 < size; j++) {

                int nextValue = Integer.parseInt(result.get(j));

                if (currentValue + nextValue == 2020) {

                    Print.print(currentValue * nextValue);

                    return;
                }

            }
        }
    }
}
