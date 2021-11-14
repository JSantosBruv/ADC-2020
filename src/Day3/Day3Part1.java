package Day3;

import Utils.Print;
import Utils.Solution;

import java.util.List;

public class Day3Part1 extends Solution {


    public Day3Part1(String fileName) {

        super(fileName);
        solution();
    }

    @Override
    public void solution() {

        List<char[]> fileContent = readFileToCharMatrix();

        int width = fileContent.get(0).length;
        int height = fileContent.size();

        int answer = 0;

        for (int downIndex = 1, rightIndex = 3; downIndex < height;
             downIndex++, rightIndex = (rightIndex + 3) % width) {

            char[] line = fileContent.get(downIndex);

            if (line[rightIndex] == '#')
                answer++;

        }

        Print.print(answer);
    }
}
