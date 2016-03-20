/**
 * Created by adamli on 3/20/16.
 */
public class GenerateSpiral2DMetrix {
    public static void generateMetrix(int metrix[][], int offSet, int size, int counter) {
        if (size <= 1) {
            metrix[offSet][offSet] = counter;
            return;
        }

        // generate upper row
        for (int i = 0; i < size - 1; i++)
            metrix[offSet][offSet + i] = counter++;

        // generate right column
        for (int i = 0; i < size - 1; i++)
            metrix[offSet + i][offSet + size - 1] = counter++;

        // generate bottom row
        for (int i = size - 1; i > 0; i--)
            metrix[offSet + size - 1][offSet + i] = counter++;

        // generate left column
        for (int i = size - 1; i > 0; i--)
            metrix[offSet + i][offSet] = counter++;

        generateMetrix(metrix, offSet + 1, size - 2, counter);
    }
}
