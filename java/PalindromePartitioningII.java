/**
 * Created by adamli on 4/18/16.
 */
public class PalindromePartitioningII {
    public static int minCut(String s) {
        int len = s.length();
        int M[] = new int[len + 1];
        boolean isPalindrome[][] = new boolean[len+1][len+1];

        if (s == null || len == 0)
            return 0;

        for (int i = 0; i <= len; i++) {
            if (i <= 1) {
                M[i] = 0;
                continue;
            }

            M[i] = i;
            for (int j = 0; j <= i; j++) {
                String cut = s.substring(j, i);

                if (isPalindrome(cut)) {
                    M[i] = Math.min(M[i], M[j] + 1);
                }
                System.out.println();

            }

            for (int k=0; k<len; k++) {
                System.out.print(M[k] + " ");
            }
        }

        return M[len];
    }

    private static void populateIsPalindrome(boolean isPalindrome[][], String s) {
        int start = 0;
        int end = s.length()-1;

        int mid = start + (end - start) / 2;


    }

    private static boolean isPalindrome(String input) {
        int i = 0;
        int j = input.length() - 1;

        while (i < j) {
            if (input.charAt(i) != input.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
}
