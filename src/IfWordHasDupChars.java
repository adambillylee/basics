/**
 * Created by adamli on 3/27/16.
 */
public class IfWordHasDupChars {
    public static boolean allUnique(String input) {
        int map[] = new int[4];

        for (char c : input.toCharArray()) {
            int index = c / 8;
            int bit = c % 8;

            if ((map[index] & (1 << bit)) > 0) {
                return false;
            }
        }

        return true;
    }
}
