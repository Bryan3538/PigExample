import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Bryan on 10/9/2015.
 */
public class InputHelper {

    private Scanner in;
    private PrintStream out;

    public InputHelper() {
        in = new Scanner(System.in);
        out = System.out;
    }

    public InputHelper(InputStream input, PrintStream output) {
        in = new Scanner(input);
        out = output;
    }


    public String getLine(String message) {
        String input = "";
        boolean good = false;

        while (!good) {
            out.println(message);
            out.print("Your input: ");
            input = in.nextLine();
            out.println();

            if (!input.isEmpty())
                good = true;
            else
                out.println("\nYou must enter something!");
        }

        return input;
    }

    public void discardLine(String message) {
        out.println(message);
        in.nextLine();
    }

    public int getInt(String message) {
        boolean good = false;
        int input = 0;
        while (!good) {
            try {
                out.println(message);
                out.print("Your input: ");
                input = Integer.parseInt(in.nextLine());
                out.println();
                good = true;
            } catch (NumberFormatException e) {
                out.println("\nYou may only enter numbers!");
            }
        }

        return input;
    }

    public int getIntInRange(String message, int min, int max) {
        boolean good = false;
        int input = 0;
        while (!good) {
            input = getInt(message);

            if (input >= min && input <= max)
                good = true;
            else
                out.println(String.format("You must enter numbers between %d and %d", min, max));
        }

        return input;
    }

    public char getChar(String message) {
        String input;
        char c = '\0';
        boolean good = false;

        while (!good) {
            out.println(message);
            out.print("Your input: ");
            input = in.nextLine();
            out.println();

            if (!input.isEmpty()) {
                c = input.charAt(0);
                good = true;
            } else {
                out.println("\nYou must enter at least one character!");
            }
        }

        return c;
    }
}
