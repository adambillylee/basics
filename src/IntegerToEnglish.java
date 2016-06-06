/**
 * Created by adamli on 6/5/16.
 */
public class IntegerToEnglish {
    public String numberToWords(int num) {
        // corner case : zero
        if (num == 0)
            return "Zero";

        StringBuilder sb = new StringBuilder();

        // organize all units with thousands
        int i = 0;
        String thousands[] = {"", " Thousand ", " Million ", " Billion "};

        /**
         * when number is greater than zero
         */
        while (num > 0) {
            /**
             * if next 3 digits are all zero, no need to add current "thousand units"
             */
            if (num % 1000 != 0) {
                sb.insert(0, thousands[i]);
                sb.insert(0, helper(num % 1000));
            }

            // divide number by 100 to work with next 3 digits
            num /= 1000;

            /**
             * But pointer for thousand units still needs to go forward
             */
            i++;
        }

        return sb.toString();
    }

    public String helper(int num) {
        StringBuilder sb = new StringBuilder();

        String twenty[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String tens[] = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};

        while (num > 0) {
            if (num < 20) {
                // for under 20, handle directly
                sb.append(twenty[num]);
                break;
            } else if (num < 100) {
                // for under 100, handles with tens + under twenty
                sb.append(tens[num / 10]).append(twenty[num % 10]);
                break;
            } else {
                // for hundreds, add hundred to string and than remove hundreds from number
                sb.append(twenty[num / 100]).append(" Hundred ");
                num = num % 100;
            }
        }

        return sb.toString().trim();
    }
}
