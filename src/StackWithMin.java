import java.util.Stack;

/**
 * Created by adamli on 2/21/16.
 * Maintain two stacks, keep them of the same size
 */
public class StackWithMin {
    // stores actual stack input numbers
    static Stack<Integer> numbers = new Stack<>();
    // always at the same size as numbers, only keep the min
    static Stack<Integer> min = new Stack<>();
    static int size;

    /**
     * when push, push input to numbers, and push another min into min to keep same size
     * @param input inpu number into numbers
     */
    public static void push(int input) {
        numbers.push(input);

        if (min.isEmpty()) {
            min.push(input);
        } else {
            // if new number smaller, push into min
            if (min.peek() > input) {
                min.push(input);
            } else {
                // if last min is smaller, push another min number into min
                min.push(min.peek());
            }
        }

        size++;
    }

    /**
     * when pop, pop 2 stacks together
     * @return pop from numbers
     */
    public static int pop() {
        if (numbers.isEmpty())
            return -1;

        size--;

        min.pop();
        return numbers.pop();
    }

    /**
     * when pop, pop 2 stacks together
     * @return pop from min
     */
    public static int min() {
        if (numbers.isEmpty())
            return -1;

        return min.peek();
    }

    public static int getSize() {
        return size;
    }
}
