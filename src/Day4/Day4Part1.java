package Day4;

import Utils.Print;
import Utils.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day4Part1 extends Solution {

    private static final String[] mandatoryWords = {"iyr", "byr", "eyr", "hgt", "hcl", "ecl", "pid"};

    public Day4Part1(String fileName) {

        super(fileName);
        solution();
    }

    @Override
    public void solution() {

        List<String> fileContent = readFileToListDelimited();

        AtomicInteger answer = new AtomicInteger();

        fileContent.forEach(value -> {

            List<String> keywords = new ArrayList<>();

            Arrays.stream(value.split(" ")).forEach(x -> keywords.add(x.split(":")[0]));

            if (keywords.containsAll(Arrays.asList(mandatoryWords)))
                answer.incrementAndGet();
        });

        Print.print(answer);

    }
}
