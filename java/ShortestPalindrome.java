/**
 * Created by adamli on 5/5/16.
 */
public class ShortestPalindrome {
//    public String shortestPalindrome(String s) {
//        if (s == null || s.length() == 0)
//            return "";
//
//        int max = 0;
//        char[] charArray = s.toCharArray();
//
//        // find longest palindrome substring in s starts at 0
//        for (int end = 0; end < s.length(); end++) {
//            if (isPalindrome(charArray, end)) {
//                max = Math.max(max, end);
//            }
//        }
//
//        // find the remaining
//        String remains = s.substring(max + 1, s.length());
//        StringBuilder sb = new StringBuilder();
//
//        // reverse remaining
//        for (int i = remains.length() - 1; i >= 0; i--)
//            sb.append(remains.charAt(i));
//
//        sb.append(s);
//
//        return sb.toString();
//    }
//
//    private boolean isPalindrome(char charArray[], int end) {
//        int l = 0;
//        int r = end;
//
//        while (l < r) {
//            if (charArray[l] != charArray[r])
//                return false;
//            l++;
//            r--;
//        }
//
//        return true;
//    }

    public String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);

        //get the maximum palin part in s starts from 0
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }

    public int[] getTable(String s){
        //get lookup table
        int[] table = new int[s.length()];

        //pointer that points to matched char in prefix part

        int index = 0;
        //skip index 0, we will not match a string with itself
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(index) == s.charAt(i)){
                //we can extend match in prefix and postfix
                table[i] = table[i-1] + 1;
                index ++;
            }else{
                //match failed, we try to match a shorter substring

                //by assigning index to table[i-1], we will shorten the match string length, and jump to the
                //prefix part that we used to match postfix ended at i - 1
                index = table[i-1];

                while(index > 0 && s.charAt(index) != s.charAt(i)){
                    //we will try to shorten the match string length until we revert to the beginning of match (index 1)
                    index = table[index-1];
                }

                //when we are here may either found a match char or we reach the boundary and still no luck
                //so we need check char match
                if(s.charAt(index) == s.charAt(i)){
                    //if match, then extend one char
                    index ++ ;
                }

                table[i] = index;
            }

        }

        return table;
    }
}
