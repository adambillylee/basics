public class NimGame {
    public static boolean dp(int n) {
        if (n <= 3)
            return true;

        boolean b1step = true;
        boolean b2step = true;
        boolean b3step = true;
        boolean curr = false;

        for (int i = 4; i <= n; i++) {
            curr = false;

            if (!(b1step && b2step && b3step))
                curr = true;

            b3step = b2step;
            b2step = b1step;
            b1step = curr;
        }

        return curr;
    }

    public static boolean brainTeaser(int n) {
        return !(n % 4 == 0);
    }
}