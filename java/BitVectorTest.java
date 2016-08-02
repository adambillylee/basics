import jdk.nashorn.internal.runtime.BitVector;

import java.util.BitSet;

/**
 * Created by adamli on 12/10/15.
 */
public class BitVectorTest {
    static String notUnique = "abcdc";
    static String unique = "abcde";

    public static void main(String args[]) {
        BitVectorTest sol = new BitVectorTest();
        sol.isUniqueString(notUnique);
        sol.isUniqueString(unique);
    }

    private boolean isUniqueString(String str) {
        BitSet set = new BitSet();

        for (int i=0; i<str.length();i++) {
            // get char index after a
            int bitIndex = str.charAt(i) - 'A';

            if (set.get(bitIndex) == true) {
                System.out.println("not unique string");
                return false;
            }

            set.set(bitIndex, true);
        }

        System.out.println("is unique string");
        return true;
    }
}
