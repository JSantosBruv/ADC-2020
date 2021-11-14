package Day1;

import Utils.Print;
import Utils.Solution;

import java.util.List;

public class Day1Part2 extends Solution {


    public Day1Part2(String fileName) {

        super(fileName);
        solution();
    }

    @Override
    public void solution() {

        List<String> fileContent = readFileToList();

        int size = fileContent.size();

        for (int i = 0; i < size - 2; i++) {

            int currentValue = Integer.parseInt(fileContent.get(i));

            for (int j = i + 1; j + 1 < size - 1; j++) {

                int nextValue = Integer.parseInt(fileContent.get(j));

                for (int l = j + 1; l + 1 < size; l++) {

                    int nextNextValue = Integer.parseInt(fileContent.get(l));

                    if (currentValue + nextValue + nextNextValue == 2020) {

                        Print.print(currentValue * nextValue * nextNextValue);

                        return;
                    }

                }
            }
        }
    }
}
