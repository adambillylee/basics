/**
 * Created by adamli on 3/23/16.
 */
public class BinaryConversion {
    public static String convert(int input, int base) {
        StringBuffer sb = new StringBuffer();
        while(input > 0) {
            char c = Character.forDigit(input % base, 10);
            sb.append(c);
            input = input / base;
        }

        return sb.reverse().toString();
    }
}
