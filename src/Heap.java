/**
 * Created by adamli on 7/6/16.
 */
public class Heap {
    int capacity;
    int size;
    int arr[];

    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    public void insert(int num) {
        if (size == capacity) {
            System.out.println("its full!");
            return;
        }

        // add number to the end of array
        arr[size] = num;

        swiftUp(arr, size);
        size++;
    }

    public int pop() {
        if (size == 0) {
            System.out.println("empty!");
            return Integer.MAX_VALUE;
        }

        // the smallest element is at the head of the array
        int rst = arr[0];

        // swap 0 with last element in array
        swap(arr, 0, size - 1);

        /**
         * BUG POINT 1:
         * reduce size by 1 before swiftDown
         * if not, the last deleted element will used for swiftDown
         */
        arr[size - 1] = 0;
        size--;
        swiftDown(arr, 0, size - 1);

        return rst;
    }

    private void swiftUp(int[] arr, int size) {
        int curr = size;

        /**
         * BUG POINT 1:
         * make sure update and use curr in every iteration instead of size
         * its the curr node that we need to swap up...
         */
        while (curr > 0) {
            int parent = (curr - 1) / 2;
            if (arr[parent] > arr[curr]) {
                swap(arr, curr, parent);
            }

            curr = parent;
        }
    }


    private void swiftDown(int[] arr, int i, int lastInd) {
        int min = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left <= lastInd && arr[min] > arr[left])
            min = left;

        if (right <= lastInd && arr[min] > arr[right])
            min = right;

        if (min != i) {
            swap(arr, i, min);
            swiftDown(arr, min, lastInd);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
