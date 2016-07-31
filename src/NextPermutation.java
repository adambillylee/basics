import java.util.ArrayList;
import java.util.List;

class NextPermutation {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> factorial = new ArrayList<>();

        int fact = 1;
        factorial.add(fact);
        for (int i = 1; i <= n; i++) {
            fact *= i;
            factorial.add(fact);
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        // convert kth permutation into index
        k--;
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial.get(i);
            sb.append(nums.get(index));
            nums.remove(index);
            k %= factorial.get(i);
        }

        return sb.toString();
    }

}