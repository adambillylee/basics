import java.util.Stack;

/**
 * Created by adamli on 7/17/16.
 */
public class TrappingRainWaterStack {
    Stack<Integer> stack = new Stack();
    int total = 0;

    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int i = 0;

        /**
         * every element has to be in stack once
         */
        while (i < height.length) {
            /**
             * always clear stack before push
             */
            clearStack(i, height);

            // all ways push and move index forward
            stack.push(i++);
        }

        return total;
    }

    private void clearStack(int rightInd, int[] height) {
        /**
         * when current height is greater than stack head
         * pop from stack until current height is smaller or stack is empty
         */
        while (!stack.isEmpty() && height[stack.peek()] < height[rightInd]) {
            // first element out of stack is the base water level
            int bot = height[stack.pop()];

            if (stack.isEmpty())
                break;

            int leftInd = stack.peek();

            /**
             * current water level depth: min of left and right wall - bot level
             */
            int depth = Math.min(height[leftInd], height[rightInd]) - bot;

            /**
             * current water level width: right - left - 1
             */
            int width = rightInd - leftInd - 1;

            total += depth * width;
        }
    }
}
