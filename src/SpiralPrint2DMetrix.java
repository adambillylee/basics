import java.util.ArrayList;

/**
 * Created by adamli on 3/19/16.
 */
public class SpiralPrint2DMetrix {
    static ArrayList<Integer> rst = new ArrayList<>();

    public static void spiralPrint(int[][] metrix, int offSet, int size) {
        // base case:
        if (size <= 1) {
            rst.add(metrix[offSet][offSet]);

            for (int i : rst)
                System.out.print(i + " ");

            return;
        }

        // press upper row
        for (int i = 0; i < size-1; i++)
            rst.add(metrix[offSet][offSet + i]);

        // press right column
        for (int i = 0; i < size-1; i++)
            rst.add(metrix[offSet + i][offSet + size - 1]);

        // press bottom row
        for (int i = size - 1; i > 0; i--)
            rst.add(metrix[offSet + size - 1][offSet + i]);

        // press left column
        for (int i = size-1; i > 0; i--) {
            rst.add(metrix[offSet + i][offSet]);
        }

        spiralPrint(metrix, offSet + 1, size - 2);
    }
}
