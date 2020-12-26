package Day2;

import Utils.Print;
import Utils.Solution;

import java.util.List;

public class Day2Part1 extends Solution {


    public Day2Part1(String fileName) {

        super(fileName);
        solution();
    }

    @Override
    public void solution() {

        List<String> result = readFileToList();

        int answer = 0;

        for (String value : result) {

            String[] firstSplit = value.split(": ");

            String policy = firstSplit[0];
            String password = firstSplit[1];

            String[] policySplit = policy.split(" ");

            String limits = policySplit[0];
            char letter = policySplit[1].charAt(0);

            String[] limitSplit = limits.split("-");

            int lowerLimit = Integer.parseInt(limitSplit[0]);
            int upperLimit = Integer.parseInt(limitSplit[1]);

            long count = password.chars().filter(ch -> ch == letter).count();

            if (count >= lowerLimit && upperLimit >= count)
                answer++;

        }

        Print.print(answer);

    }
}
