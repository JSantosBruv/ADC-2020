import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AOC {

    public static final String FILENAME = "input.txt";

    public static void main(String[] args) {

        List<String> result;

        try (Stream<String> lines = Files.lines(Paths.get(FILENAME))) {
            result = lines.collect(Collectors.toList());

            int size = result.size();

            for (int i = 0; i < size - 2; i++) {
                int currentValue = Integer.parseInt(result.get(i));
                for (int j = i + 1; j + 1 < size - 1; j++) {
                    int nextValue = Integer.parseInt(result.get(j));
                    for (int l = j + 1; l + 1 < size; l++) {

                        int nextNextValue = Integer.parseInt(result.get(l));


                        if (currentValue + nextValue + nextNextValue == 2020) {
                            System.out.println(currentValue * nextValue * nextNextValue);
                            return;
                        }

                    }
                }
            }

        } catch (IOException e) {
            // Upsi Daisy
        }
    }
}
