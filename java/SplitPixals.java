import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by adamli on 7/10/16.
 */
public class SplitPixals {
    static class Color {
        String name;
        double dist;

        Color(String name, double dist) {
            this.name = name;
            this.dist = dist;
        }
    }

    static String[] closestColor(String[] hexcodes) {
        String[] rst = new String[hexcodes.length];

        for (int i = 0; i < hexcodes.length; i++) {
            rst[i] = findClosest(hexcodes[i]);
            System.out.println(rst[i]);
        }

        return rst;
    }

    private static String findClosest(String hexcode) {
        String red = hexcode.substring(0, 8);
        String green = hexcode.substring(8, 16);
        String blue = hexcode.substring(16, 24);

        int redCode = Integer.parseInt(red, 2);
        int greenCode = Integer.parseInt(green, 2);
        int blueCode = Integer.parseInt(blue, 2);

        int[] curr = {redCode, greenCode, blueCode};

        int[] black = {0, 0, 0};
        int[] white = {255, 255, 255};
        int[] pureRed = {255, 0, 0};
        int[] pureGreen = {0, 255, 0};
        int[] pureBlue = {0, 0, 255};

        List<Color> colors = new ArrayList<>();
        colors.add(new Color("Black", calDist(curr, black)));
        colors.add(new Color("White", calDist(curr, white)));
        colors.add(new Color("Red", calDist(curr, pureRed)));
        colors.add(new Color("Green", calDist(curr, pureGreen)));
        colors.add(new Color("Blue", calDist(curr, pureBlue)));

        Collections.sort(colors, new Comparator<Color>() {
            @Override
            public int compare(Color o1, Color o2) {
                if (o1.dist < o2.dist)
                    return -1;
                else
                    return 1;
            }
        });

        if (colors.get(0).dist == colors.get(1).dist) {
            return "Ambiguous";
        } else {
            return colors.get(0).name;
        }
    }

    private static double calDist(int[] curr, int[] pureColor) {
        double sum = 0;

        for (int i = 0; i < 3; i++) {
            sum += (curr[i] - pureColor[i]) * (curr[i] - pureColor[i]);
        }

        return Math.sqrt(sum);
    }
}
