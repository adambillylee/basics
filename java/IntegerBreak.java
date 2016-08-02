public class IntegerBreak {
    public static int integerBreak(int n) {
        if (n < 2)
            return n;
        if (n==2)
            return 1;
        if (n==3)
            return 2;

        int numberOfThree = n / 3;
        int r = n % 3;

        if (r == 0) {
            return (int)Math.pow(3, numberOfThree);
        }else if (r == 1) {
            return (int)Math.pow(3, numberOfThree-1) * 4;
        }else{
            return (int)Math.pow(3, numberOfThree) * r;
        }
    }
}