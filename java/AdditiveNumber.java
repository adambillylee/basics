/**
 * Created by adamli on 5/15/16.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length() - 2; i++) {
            for (int j = 1; i + j < num.length(); j++) {
                // loop to get the end index of first and second number
                int firstEnd = i;
                int secondEnd = i + j;

                if (validSum(num, 0, firstEnd, secondEnd))
                    return true;
            }
        }

        return false;
    }

    /**
     * recursively verify start, first end and second end index
     *
     * @param num
     * @param start
     * @param firstEnd
     * @param secondEnd
     * @return
     */
    private boolean validSum(String num, int start, int firstEnd, int secondEnd) {
        // obtain first and second string
        String firstStr = num.substring(start, firstEnd + 1);
        if (firstStr.length() > 1 && firstStr.startsWith("0"))
            return false;

        String secondStr = num.substring(firstEnd + 1, secondEnd + 1);
        if (secondStr.length() > 1 && secondStr.startsWith("0"))
            return false;

        // verify sum value and string
        long sum = Long.parseLong(firstStr) + Long.parseLong(secondStr);
        String sumStr = String.valueOf(sum);

        // obtain remaining string
        String remaining = num.substring(secondEnd + 1);

        // if sum is verified
        if (remaining.startsWith(sumStr)) {
            // if there is no more room for next sum, return true
            if (secondEnd + sumStr.length() == num.length() - 1)
                return true;

            // set start to be after first end, set first end to be second end, set second end to be after sum
            return validSum(num, firstEnd + 1, secondEnd, secondEnd + sumStr.length());
        }

        return false;
    }

}
