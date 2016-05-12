/**
 * Created by adamli on 5/11/16.
 */
public class MergeSortedList {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tmp[] = new int[m];
        for (int i=0; i<m; i++) {
            tmp[i] = nums1[i];
        }


        int i=0;
        int j=0;
        int k=0;

        while (k < m+n) {
            if (i == m){
                nums1[k++] = nums2[j++];
                continue;
            }

            if (j == n) {
                nums1[k++] = tmp[i++];
                continue;
            }

            if (tmp[i]<nums2[j]) {
                nums1[k++] = tmp[i++];
            }else{
                nums1[k++] = nums2[j++];
            }
        }
    }
}
