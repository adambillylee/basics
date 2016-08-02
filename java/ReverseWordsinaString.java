/**
 * Created by adamli on 4/30/16.
 */
public class ReverseWordsinaString {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;

        // remove all spaces before and after
        s = s.trim();

        /**
         * "a  b" to split
         * will give you a,"","",b
         */
        String split[] = s.split(" ");

        int i=0;
        int j = split.length-1;

        while (i<j) {
            String tmp = split[i];
            split[i] = split[j];
            split[j] = tmp;
            i++;
            j--;
        }


        StringBuilder sb = new StringBuilder();
        for (int k=0; k<split.length; k++) {
            // remove all empty strings in split
            if (split[k].equals(""))
                continue;
            else
                sb.append(split[k]);

            // except for last element, add a space after each string
            if (k != split.length-1)
                sb.append(" ");
        }

        return sb.toString();
    }
}
