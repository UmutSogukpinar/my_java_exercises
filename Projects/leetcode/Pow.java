class Pow {
    public double myPow(double x, int n) {
        long pow = n;

        if (x == 1) return 1;
        if (x == -1) return (pow % 2 == 0) ? 1 : -1;

        if (pow < 0) {
            x = 1 / x;
            pow = -pow;
        }

        double result = 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                result *= x;
            }
            x *= x;
            pow >>= 1;
        }

        return result;
    }
}