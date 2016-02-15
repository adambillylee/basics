/**
 * Created by adamli on 2/13/16.
 */
public class RainbowSort {
    public static void RainbowSort(char[] input) {
        if (input.length == 0)
            return;

        int a = 0;
        int b = 0;
        int c = input.length - 1;

        while(b <= c) {
            if (input[b] == 'a') {
                swap(input, a, b);
                a++;
                b++;
            }else if(input[b] == 'b') {
                b++;
            }else if(input[b] == 'c') {
                swap(input, b, c);
                c--;
            }
        }
    }

    public static void swap(char[] input, int left, int right) {
        char tmp = input[left];
        input[left] = input[right];
        input[right] = tmp;
    }
}
