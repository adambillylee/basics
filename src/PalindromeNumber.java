/**
 * Created by adamli on 5/5/16.
 */
public class PalindromeNumber {
    int x;
    int y;
    int divider;

    public boolean isPalindrome(int x) {
        this.x = x;
        this.y = x;

        this.divider = getDivider();

        while (this.x > 0) {
            int left = getLeft();
            int right = getRight();

            if (left != right)
                return false;
        }

        return true;
    }

    private int getDivider() {
        int divider = 1;

        while (x / divider >= 10) {
            divider = divider * 10;
        }

        return divider;
    }

    private int getLeft() {
        int rst = x / divider;
        x = x - (x / divider) * divider;
        divider = divider / 10;

        return rst;
    }

    private int getRight() {
        int rst = y % 10;
        y = y / 10;

        return rst;
    }
}
