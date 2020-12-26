package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public abstract class Solution {

    public static final String FilesFolder = "./Files/";

    String fileName;

    protected Solution(String fileName) {
        this.fileName = fileName;
    }

    protected abstract void solution();


    public List<String> readFileToList() {


        List<String> result;

        try (Stream<String> lines =

                Files.lines(Paths.get(FilesFolder + fileName))) {

            result = lines.collect(Collectors.toList());

            return result;

        } catch (IOException e) {

            System.err.println("File not found, shutting down program.");
            System.exit(1);

        }

        return new ArrayList<>();
    }

    public List<char[]> readFileToCharMatrix() {

        String line;

        List<char[]> matrix = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(FilesFolder + fileName))) {

            while ((line = in.readLine()) != null) {
                matrix.add(line.toCharArray());
            }
            return matrix;

        } catch (IOException e) {
            System.err.println("File not found, shutting down program.");
            System.exit(1);
        }

        return new ArrayList<>();
    }
}