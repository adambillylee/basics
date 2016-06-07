import java.util.Stack;

/**
 * Created by adamli on 6/7/16.
 */
public class LongestAbsolutePath {
    public int FindLongest(String path) {
        String paths[] = path.split("\n");

        // max path length
        int max = 0;

        /**
         * keep a stack of string, where each element
         * represent is one level of current path
         */
        Stack<String> stack = new Stack<>();

        // number of char in complete path length
        int pathLenInStack = 0;

        for (String ele : paths) {
            /**
             * if path is valid, we can only have leading spaces
             * if the last space is at index 2, there are 3 leading spaces (+1)
             */
            int leadingSpaces = ele.lastIndexOf(" ") + 1;

            /**
             * stack size = path level in stack
             * leading space = path level of current element
             */
            while (leadingSpaces < stack.size()) {
                // pop out stack elements until stack level = current element level
                String tmp = stack.pop();

                // remove path length of poped element from total length (add 1 for leading slash)
                pathLenInStack -= (1 + tmp.length());
            }

            // remove leading spaces and push element into stack
            ele = ele.trim();
            stack.push(ele);

            // add current element length into total path length (add 1 for leading slach)
            pathLenInStack += (1 + ele.length());

            // keep track of max path length
            max = Math.max(max, pathLenInStack);
        }

        return max;
    }
}
