import Day1.Day1Part1;
import Day1.Day1Part2;
import Day2.Day2Part1;
import Day2.Day2Part2;
import Day3.Day3Part1;
import Day3.Day3Part2;
import Day4.Day4Part1;
import Day4.Day4Part2;
import Utils.Solution;

public class RunSolution {

    public static void main(String[] args) {

        Solution sol1_1 = new Day1Part1("1/input1.txt");
        Solution sol1_2 = new Day1Part2("1/input1.txt");

        Solution sol2_1 = new Day2Part1("2/input1.txt");
        Solution sol2_2 = new Day2Part2("2/input1.txt");

        Solution sol3_1 = new Day3Part1("3/input1.txt");
        Solution sol3_2 = new Day3Part2("3/input1.txt");

        Solution sol4_1 = new Day4Part1("4/input1.txt");
        Solution sol4_2 = new Day4Part2("4/input1.txt");
    }
}
