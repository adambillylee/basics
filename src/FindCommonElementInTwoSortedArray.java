import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by adamli on 3/8/16.
 */
public class FindCommonElementInTwoSortedArray {
    public static ArrayList<Integer> findCommon(int[] arr1, int[] arr2) {
//        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> rst = new ArrayList<>();

        if (arr1.length > arr2.length) {
            for(int ele : arr2) {
//                map.put(ele, 1);
                set.add(ele);
            }

            for (int ele : arr1) {
                if (set.contains(ele))
                    rst.add(ele);
            }

        }else{
            for (int ele : arr1) {
//                map.put(ele, 1);
                set.add(ele);
            }

            for (int ele : arr2) {
                if (set.contains(ele))
                    rst.add(ele);
            }
        }

        return rst;
    }
}
