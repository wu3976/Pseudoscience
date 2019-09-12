import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

public class ABCDGuesser1 {
    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        boolean quitLoop = false;
        String resStr = "";
        while (!quitLoop) {
            resStr = in.nextLine();
            if (FormatChecker.canParseDouble(resStr)
                    && Double.parseDouble(resStr) > 0) {
                quitLoop = true;
            } else {
                out.println("You must enter a positive floating value!");
            }
        }
        double result = Double.parseDouble(resStr);
        return result;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        boolean quitLoop = false;
        String resStr = "";
        while (!quitLoop) {
            resStr = in.nextLine();
            if (FormatChecker.canParseDouble(resStr)
                    && Double.parseDouble(resStr) > 0
                    && Double.parseDouble(resStr) != 1.0) {
                quitLoop = true;
            } else {
                out.println(
                        "You must enter a positive, not-one floating value!");
            }
        }
        double result = Double.parseDouble(resStr);
        return result;
    }

    public static void main(String[] s) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        double x = getPositiveDoubleNotOne(in, out);
        out.print(x);
    }
}
