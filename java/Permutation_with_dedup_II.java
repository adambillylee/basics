import java.util.HashSet;

/**
 * Created by adamli on 3/13/16.
 */
public class Permutation_with_dedup_II {
    public static void permutate(char[] input, int index) {
        if (index == input.length) {
            System.out.println(input);
            return;
        }

        HashSet<Character> visited = new HashSet<>();
        for (int i = index; i < input.length; i++) {
            if (!visited.contains(input[i])) {
                visited.add(input[i]);

                swap(input, i, index);
                permutate(input, index + 1);
                swap(input, i, index);
            }
        }
    }

    public static void swap(char[] input, int i, int j) {
        char tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

}
