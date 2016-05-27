/**
 * Created by adamli on 5/26/16.
 *
 * +---+--------+----------+
 | i | Binary | # of 1's |
 +---+--------+----------+
 | 1 | 0001   | 1        |
 +---+--------+----------+
 | 2 | 0010   | 1        |
 +---+--------+----------+
 | 3 | 0011   | 2        |
 +---+--------+----------+
 | 4 | 0100   | 1        |
 +---+--------+----------+
 | 5 | 0101   | 2        |
 +---+--------+----------+
 | 6 | 0110   | 2        |
 +---+--------+----------+
 | 7 | 0111   | 3        |
 +---+--------+----------+
 | 8 | 1000   | 1        |
 +---+--------+----------+
 | 9 | 1001   | 2        |
 +---+--------+----------+
 */
public class CountingBits {
    public int[] countBits(int num) {
        int rst[] = new int[num + 1];
        rst[0] = 0;

        // current power of 2
        int pow = 1;

        for (int i = 1; i <= num; i++) {
            // update current power of 2 when i is twice as big
            if (i == pow * 2) {
                pow *= 2;
            }

            /**
             * result i = (rst i - current power of 2) + 1
             * rst[5] = rst[5-4] + 1
             * rst[8] = rst[8-8] + 1
             */
            rst[i] = rst[i - pow] + 1;
        }

        return rst;
    }
}
