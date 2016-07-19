/**
 * Created by adamli on 7/17/16.
 */
public class MultiplyString {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty())
            return "0";

        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int rst[] = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int large = i + j;
                int small = i + j + 1;
                int tmp = (c1[i] - '0') * (c2[j] - '0') + rst[small];
                rst[large] += tmp / 10;
                rst[small] = tmp % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : rst) {
            if (!(sb.length() == 0 && i == 0))
                sb.append(i);
        }

        return sb.toString();
    }
}
