package useful.things;

import androidx.appcompat.app.AppCompatActivity;

public class rachetformul extends AppCompatActivity {
    //формулы сокращенного умножения
    public static double square_sum(double a, double b) {
        return a * a + 2 * a * b + b * b;
    }

    public static double Squared_difference(double a, double b) {
        return a * a - 2 * a * b + b * b;
    }

    public static double Difference_squares(double a, double b) {
        return (a + b) * (a - b);
    }

    public static double cube_sum(double a, double b) {
        return a * a * a + 3 * a * a * b + 3 * a * b * b + b * b * b;
    }

    public static double cube_difference(double a, double b) {
        return a * a * a - 3 * a * a * b + 3 * a * b * b - b * b * b;
    }

    public static double cube_summ(double a, double b) {
        return (a + b) * (a * a - a * b + b * b);
    }


    //квадратные уравнения
    public static double diskemenant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static double quad_equa_plus(double a, double b, double d) {
        return (-b - Math.sqrt(d)) / (2 * a);
    }

    public static double quad_equa_minus(double a, double b, double d) {
        return (-b + Math.sqrt(d)) / (2 * a);
    }

    public static double quad_equa_zero(double a, double b) {
        return (-b) / (2 * a);
    }
    // х=(-b)/2а
    //тригонометрия
    //public static double mult_sin_cos (double a, double b){ return (0.5*(Math.sin(Math.toRadians(a+b))+Math.sin(Math.toRadians(a-b)))); }
}
