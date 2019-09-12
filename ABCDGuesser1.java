
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * A program implementing the pseudo-science of de Jager formula.
 * 
 * @author Chenjie Wu
 *
 */
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
            out.print("Please enter the actual value you want to evaluate:");
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
                        "You must enter a positive, not-one floating value! have another try: ");
            }
        }
        double result = Double.parseDouble(resStr);
        return result;
    }

    public static void main(String[] s) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        out.println("Please input your first personal number: ");
        double w = getPositiveDoubleNotOne(in, out);
        out.println("Please input your second personal number: ");
        double x = getPositiveDoubleNotOne(in, out);
        out.println("Please input your third personal number: ");
        double y = getPositiveDoubleNotOne(in, out);
        out.println("Please input your fourth personal number: ");
        double z = getPositiveDoubleNotOne(in, out);
        double u = getPositiveDouble(in, out);

        double[] powNums = new double[17];
        powNums[0] = -5;
        powNums[1] = -4;
        powNums[2] = -3;
        powNums[3] = -2;
        powNums[4] = -1;
        powNums[5] = -0.5;
        powNums[6] = -1 / 3.0;
        powNums[7] = -0.25;
        powNums[8] = 0;
        powNums[9] = 0.25;
        powNums[10] = 1 / 3.0;
        powNums[11] = 0.5;
        powNums[12] = 1;
        powNums[13] = 2;
        powNums[14] = 3;
        powNums[15] = 4;
        powNums[16] = 5;

        double result = 0;
        double relativeError = 1.0;
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;

        int indexa = 0;
        while (indexa < powNums.length) {
            int indexb = 0;
            while (indexb < powNums.length) {
                int indexc = 0;
                while (indexc < powNums.length) {
                    int indexd = 0;
                    while (indexd < powNums.length) {
                        double temp = Math.pow(w, powNums[indexa])
                                * Math.pow(x, powNums[indexb])
                                * Math.pow(y, powNums[indexc])
                                * Math.pow(z, powNums[indexd]);
                        if (Math.abs((temp - u) / u) < Math
                                .abs(relativeError)) {
                            result = temp;
                            relativeError = (result - u) / u;
                            a = powNums[indexa];
                            b = powNums[indexb];
                            c = powNums[indexc];
                            d = powNums[indexd];
                        }
                        indexd++;
                    }
                    indexc++;
                }
                indexb++;
            }
            indexa++;
        }

        out.print(
                "The result with smallest relative error is: " + result + "\n");
        out.print("The relative error is: " + relativeError + "\n");
        out.print("The a, b, c, d of this are respectively: " + a + " " + b
                + " " + c + " " + d);

    }
}
