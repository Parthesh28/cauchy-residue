import java.util.Arrays;

public class cauchy {

    public static double contour(double p) {
        double contour = p - 1;
        contour = Math.sqrt(contour);
        return contour;
    }

    public static double function(double p) {
        double x = ((p - 2) * (p + 3));
        return x;
    }

    public static double[] polecalc() {
        double[] poles = new double[2];
        int j = 0; 
        for (double i = -10; i < 10; i++) {
            double pole = function(i);
            if (pole == 0) {
                poles[j] = i;
                j++;
            }
        }
        return poles;
    }

    public static void residuecalc(double p, double[] residue) {
        int x = Integer.MAX_VALUE;
        if (p == 2)
            residue[0] = (p / (p + 3));
        else
            residue[1] = (p / (p - 2));
    }

    public static void integral(double[] residue) {
        double integral = 2 * 3.14 * (residue[0] + residue[1]);
        if (integral == 0)
            System.out.println(
                    "As all poles lie outside the contour, by Cauchy-Gaursat Theorem, the value of integral is: "
                            + integral);
        else
            System.out.println("The value of integral by Cauchy-Residue Theorem is: " + integral + "i");
    }

    public static void main(String[] args) {
        double[] residue = new double[3];
        double[] poles = polecalc();
        double radius = 1.5;

        double a1 = contour(poles[0]);
        double a2 = contour(poles[1]);

        System.out.println("The function for integral calculation is: z/(z-2)(z+3) \n");
        System.out
                .println("Hence the poles for f(z) are " + poles[0] + " and " + poles[1] + " which are simple poles.\n");
        System.out.println("For the given region |z - 1| = 1.5: \n");
        if (a1 > radius) {
            residue[0] = 0;
            System.out.println("The pole " + poles[0] + " lies outside the given countour, hence its residue is zero.");
        } else
            residuecalc(poles[0], residue);
        if (a2 > radius) {
            System.out.println("The pole " + poles[1] + " lies outside the given countour, hence its residue is zero.");
            residue[1] = 0;
        } else
            residuecalc(poles[1], residue);
        System.out.println("The residue is " + residue[0] + " and " + residue[1] + " for poles " + poles[0] + " and "
                + poles[1] + " respectively.");
        integral(residue);
    }
}
