package Day2;

import Utils.Print;
import Utils.Solution;

import java.util.List;

public class Day2Part2 extends Solution {


    public Day2Part2(String fileName) {

        super(fileName);
        solution();
    }

    //Could be done with Matchers but decided not to use externals
    @Override
    public void solution() {

        List<String> fileContent = readFileToList();

        int answer = 0;

        for (String value : fileContent) {

            String[] firstSplit = value.split(": ");

            String policy = firstSplit[0];
            String password = firstSplit[1];

            String[] policySplit = policy.split(" ");

            String indexes = policySplit[0];
            char letter = policySplit[1].charAt(0);

            String[] limitSplit = indexes.split("-");

            int lowerIndex = Integer.parseInt(limitSplit[0]);
            int upperIndex = Integer.parseInt(limitSplit[1]);


            if (password.charAt(lowerIndex - 1) == letter ^ password.charAt(upperIndex - 1) == letter)
                answer++;
        }

        Print.print(answer);

    }
}
