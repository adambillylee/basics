import java.util.Stack;

/**
 * Created by adamli on 12/28/15.
 */
public class BST {
    Node root;

    public BST(Node root) {
        this.root = root;
    }

    /**
     * make a clean put method so user don't have to use put(root, {key}, {value})
     *
     * @param key   new key to insert
     * @param value new value to insert
     */
    public void put(int key, int value) {
        if (value == -1) {
            System.out.println("-1 is not a valid value");
            return;
        }

        root = this.put(root, key, value);
    }

    /**
     * add node into BST
     *
     * @param root  root node for current iteration
     * @param key   new key to insert
     * @param value new value to insert
     * @return reference to new node
     */
    public Node put(Node root, int key, int value) {
        // return new node when reached empty leaf
        if (root == null) {
            return new Node(key, value);
        }

        if (key < root.key) {
            // if new key < curr key, put node into left tree
            root.left = put(root.left, key, value);
        } else if (key > root.key) {
            // if new key > curr key, put node into right tree
            root.right = put(root.right, key, value);
        } else
            // if new key = root key, update value in curr node
            root.value = value;

        root.count = 1 + size(root.left) + size(root.right);

        // if root value is updated, return root
        return root;
    }

    /**
     * get value by key value, if not found, return -1
     *
     * @param key key to look for
     * @return value if found, -1 if not found
     */
    public int get(int key) {
        Node curr = root;

        while (curr != null) {
            if (key < curr.key)
                curr = curr.left;
            else if (key > curr.key)
                curr = curr.right;
            else
                return curr.value;
        }

        return -1;
    }

    /**
     * make a clean recursiveInOrder method to start with root node
     */
    public void recursiveInOrder() {
        recursiveInOrder(root);
    }

    /**
     * print all keys and values in order
     *
     * @param root
     */
    public void recursiveInOrder(Node root) {
        if (root == null)
            return;

        recursiveInOrder(root.left);
        System.out.println("key: " + root.key + ", value: " + root.value);
        recursiveInOrder(root.right);
    }

    public void min() {
        if (root == null) {
            System.out.println("BST is empty");
            return;
        }

        Node curr = root;

        while (curr.left != null) {
            curr = curr.left;
        }

        System.out.println(curr.value);
    }

    public void max() {
        if (root == null) {
            System.out.println("BST is empty");
            return;
        }

        Node curr = root;

        while (curr.right != null) {
            curr = curr.right;
        }

        System.out.println(curr.value);
    }

    public void floor(int key) {
        Node tmp = floor(root, key);
        System.out.println(tmp.value);
    }

    /**
     * return max key < given key
     */
    public Node floor(Node root, int key) {
        if (root == null)
            return root;

        Node curr = root;

        // if key < curr key, look to the left
        if (key < curr.key) {
            curr = floor(curr.left, key);
        } else if (key > curr.key) {
            /**
             * "curr key < key" satisfied
             * check all ele in right tree (> curr key) to find a max < key
             * if we can find the floor in right key, then its tmp
             */
            Node tmp = floor(curr.right, key);

            // if we cannot find floor in right tree, return curr node
            if (tmp != null)
                return tmp;
        }

        return curr;
    }

    public void ceiling(int key) {
        Node tmp = ceiling(root, key);
        System.out.println(tmp.value);
    }

    /**
     * find min ele > key
     *
     * @param root
     * @param key
     * @return
     */
    public Node ceiling(Node root, int key) {
        if (root == null)
            return root;

        Node curr = root;

        // if key > curr key, search in the right
        if (key > curr.key) {
            curr = ceiling(curr.right, key);
        } else if (key < curr.key) {
            /**
             * if key < curr key, "curr ele > key" satisfied
             * look in left tree to find "min ele > key"
             * if we can find it, its tmp
             */
            Node tmp = ceiling(curr.left, key);

            if (tmp != null)
                return tmp;

            // if cannot find it, return curr
        }

        return curr;
    }

    public void range(int key) {
        this.floor(key);
        this.ceiling(key);
    }

    /**
     * clean method interface without taking node parameter
     *
     * @return size of subtree
     */
    public int size() {
        return size(root);
    }

    /**
     * recursively calculate size of the subtree rooted at curr
     *
     * @param curr
     * @return
     */
    int size(Node curr) {
        if (curr == null)
            return 0;

        return curr.count;
    }

    /**
     * clean method for rank without root parameter
     *
     * @param key
     * @return
     */
    public void rank(int key) {
        System.out.println(rank(key, root));
    }

    /**
     * return the rank of key k in the tree (from small to big)
     *
     * @param key
     * @return
     */
    int rank(int key, Node curr) {
        /**
         * look for # of nodes < input key
         */
        // if already at leaf, curr node doesn't add rank
        if (curr == null)
            return 0;

        if (key > curr.key) {
            /**
             * if current key is smaller
             * add 1 for current node < input key
             * add all left nodes since they all smaller then key
             * add all (smaller than key nodes) from right tree
             */
            return 1 + size(curr.left) + rank(key, curr.right);
        } else if (key < curr.key) {
            /**
             * if current key is bigger, then keep looking for (smaller than key nodes) in left tree
             */
            return rank(key, curr.left);
        } else
        /**
         * if current key is the key, then the size of left tree is (# of smaller keys in tree)
         */
            return size(curr.left);
    }

    /**
     * clean method without parameter
     */
    public void iterativeInOrder() {
        iterativeInOrder(root);
    }

    /**
     * iterate inorder iteratively (no recursion)
     * useful on all trees, BST inorder will be an ordered sequence
     *
     * @param curr
     */
    public void iterativeInOrder(Node curr) {
        if (curr == null)
            return;

        Stack<Node> stack = new Stack<>();

        // push all left node into stack
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }


        while (!stack.isEmpty()) {
            // pop and print stack node
            Node tmp = stack.pop();
            System.out.println(tmp.value);

            // once poped node has righ tree
            if (tmp.right != null) {
                // move to the right
                tmp = tmp.right;

                // restart pushing all left nodes into stack
                while (tmp != null) {
                    stack.push(tmp);
                    tmp = tmp.left;
                }
            }
        }
    }
}

class Node {
    int key;
    int value;
    Node left;
    Node right;
    int count;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.count = 1;
    }
}
