package pl.homik.calculator;

/**
 * Created by Pawel on 2016-08-31.
 */


public class Operations {
    public static double addition(double a, double b) {
        return (a + b);
    }

    public static double subtraction(double a, double b) {
        return (a - b);
    }

    public static double multiplication(double a, double b ) {
        return  (a * b);
    }

    public static double division(double a, double b) {
        if (b == 0)
            throw new IllegalArgumentException("division by 0");
        else
            return (a / b);
    }
}
