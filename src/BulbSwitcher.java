/**
 * Created by adamli on 5/29/16.
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        /**
         * 1. light bulb are toggled twice when both of the two dividers of current i exists
         * 2. how ever, if the square root of current i is an int, like i=9, sqrt = 3, that 3 toggle cannot
         * be switched off later
         * 3. find the largest of number with square <=n
         * 4. which is equivalent to find largest sqrt in n
         */
        return (int)Math.sqrt(n);
    }
}
