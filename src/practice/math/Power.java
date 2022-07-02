package practice.math;

public class Power {
    public double myPow(double x, int n) {
        double res = 1;
        while (n != 0) {
            if (n % 2 == 1) res = (n > 0) ? res * x : res / x;
            x = x * x;
            n /= 2;
        }
        return res;
    }
}
