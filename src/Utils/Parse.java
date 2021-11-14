package Utils;

public class Parse {

    public static int parseInt(String value) {

        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Not a number");
        }

    }
}
