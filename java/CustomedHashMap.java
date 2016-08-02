/**
 * Created by adamli on 7/7/16.
 */
public class CustomedHashMap {
    private class Node {
        int key;
        Object val;
        Node prev;
        Node next;

        public Node(int key, Object val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }

        boolean equals(Node n) {
            return n.key == key && n.val == val;
        }

        @Override
        public String toString() {
            return "key: " + key + " val:" + val;
        }
    }

    Node arr[];
    int capacity;
    int size;

    public CustomedHashMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new Node[capacity];
    }

    /**
     * a hash code function to ensure collision
     * @param key
     * @return bucket
     */
    private int hashCode(int key) {
        return 1;
    }

    private int getBucket(int key) {
//        return hashCode(key) % capacity;

        return 1;
    }



    public boolean put(int key, Object val) {
        if (size == capacity) {
            System.out.println("already full!");
            return false;
        }

        int bucket = hashCode(key);
        Node tmp = new Node(key, val);

        Node curr = arr[bucket];

        /**
         * BUG POINT 1:
         * cannot create an linked list node on a null reference
         * maintain a previous node and add new node after it
         */
        Node prev = null;
        while (curr != null && !curr.equals(tmp)) {
            prev = curr;
            curr = curr.next;
        }

        /**
         * BUG POINT 2:
         * when making link, make sure prev or next exist
         */
        if (prev != null) {
            prev.next = tmp;
            tmp.prev = prev;
        } else {
            arr[bucket] = tmp;
        }

        size++;
        return true;
    }

    public Object get(int key) {
        if (size == 0) {
            System.out.println("this is empty!");
            return null;
        }

        int bucket = hashCode(key);

        if (arr[bucket] == null) {
            return null;
        } else {
            Node curr = arr[bucket];

            while (curr != null && curr.key != key) {
                curr = curr.next;
            }

            if (curr != null)
                return curr.val;
            else
                return null;
        }
    }

    public boolean remove(int key) {
        if (size == 0) {
            System.out.println("this is empty!");
            return false;
        }

        int bucket = hashCode(key);

        if (arr[bucket] == null) {
            System.out.println("not found");
            return false;
        } else {
            Node curr = arr[bucket];

            while (curr != null && curr.key != key) {
                curr = curr.next;
            }

            if (curr == null) {
                System.out.println("not found");
                return false;
            } else {
                size--;

                /**
                 * BUG POINT 3:
                 * for double linked list
                 * always check head / tail corner case
                 */
                if (curr == arr[bucket])
                    arr[bucket] = curr.next;

                /**
                 * BUG POINT 2:
                 * when making link, make sure prev or next exist
                 */
                if (curr.prev != null)
                    curr.prev.next = curr.next;

                if (curr.next != null)
                    curr.next.prev = curr.prev;

                return true;
            }
        }
    }

}
