package Day4;

import Utils.Parse;
import Utils.Print;
import Utils.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day4Part2 extends Solution {

    private enum Field {
        iyr, byr, eyr, hgt, hcl, ecl, pid
    }

    private final List<String> values;

    public Day4Part2(String fileName) {

        super(fileName);

        this.values = Arrays.stream(Field.values()).map(Field::name).collect(Collectors.toList());
        solution();
    }

    @Override
    public void solution() {

        List<String> fileContent = readFileToListDelimited();

        AtomicInteger answer = new AtomicInteger();

        fileContent.forEach(value -> {

            List<String> keywords = new ArrayList<>();

            Stream<String> keyVals = Arrays.stream(value.split(" "));

            AtomicInteger size = new AtomicInteger(0);

            keyVals.forEach(x -> {
                size.incrementAndGet();
                keywords.add(x.split(":")[0]);
            });

            if (keywords.containsAll(values)) {

                if (Arrays.stream(value.split(" ")).takeWhile(this::validField).count() == size.get())

                    answer.incrementAndGet();

            }


        });

        Print.print(answer);

    }

    private boolean validField(String keyValue) {

        String[] keyVal = keyValue.split(":");

        String key = keyVal[0];
        String val = keyVal[1];

        if (key.equals("cid")) {
            return true;
        }

        Field field = Field.valueOf(key);

        switch (field) {
            case byr:
                return validateByr(val);
            case iyr:
                return validateIyr(val);

            case pid:
                return validatePid(val);

            case ecl:
                return validateEcl(val);

            case hgt:
                return validateHgt(val);

            case hcl:
                return validateHcl(val);

            case eyr:
                return validateEyr(val);

            default:
                return false;
        }
    }

    private boolean validateByr(String value) {

        int year = Integer.parseInt(value);

        return value.length() == 4 && year >= 1920 && year <= 2002;
    }

    private boolean validateIyr(String value) {
        int year = Integer.parseInt(value);

        return value.length() == 4 && year >= 2010 && year <= 2020;
    }

    private boolean validateEyr(String value) {
        int year = Integer.parseInt(value);

        return value.length() == 4 && year >= 2020 && year <= 2030;
    }

    private boolean validatePid(String value) {

        return value.matches("^\\d{9}$");
    }

    private boolean validateEcl(String value) {

        String[] colors = new String[]{"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};

        return Arrays.asList(colors).contains(value);

    }

    private boolean validateHgt(String value) {


        String measure = value.substring(value.length() - 2);
        String val = value.substring(0, value.length() - 2);


        if (measure.equals("cm")) {
            int hgt = Parse.parseInt(val);
            return hgt >= 150 && hgt <= 193;
        } else if (measure.equals("in")) {
            int hgt = Parse.parseInt(val);
            return hgt >= 59 && hgt <= 76;
        }

        return false;
    }

    private boolean validateHcl(String value) {
        return value.matches("^#([a-f0-9]{6})");
    }

}
