package RandomAnsiEscapeCode;
import java.util.Random;

public class RandomAnsiEscapeCode {
    // Define an array of ANSI escape codes
    private static final String[] ANSI_CODES = new String[255];

    static {
        for (int i = 0; i < 255; i++) {
            ANSI_CODES[i] = "\u001B[38;5;" + i + "m";
        }
    }

    // Function to attach a random ANSI escape code to a string
    public static String attachRandomAnsiCode(String input) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(255);
        String randomCode = ANSI_CODES[randomIndex];
        return randomCode + input + "\u001B[0m"; // Reset the color after the string
    }
}