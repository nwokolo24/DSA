package stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = new int[] {4, 7, 3, 4, 8, 1};
        System.out.println(Arrays.toString(findNext(arr)));
    }
    private static int[] findNext(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        // Loop through the array in reverse order and do the following
        for (int i = arr.length - 1; i >= 0; i--) {

            // while stack is not empty and the number is less than
            // the number from "arr" we are currently looking at, remove
            //  that number
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }

            // if stack is empty, we have not seen any number greater than
            // arr[i] or the current element we are seeing
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                // if stack is not empty, then it means that the number/element
                // in the stack is greater than arr[i]. Add it to result
                result[i] = stack.peek();
            }

            // push arr[i] to the stack because it might be the next greater element
            // to arr[i - 1]
            stack.push(arr[i]);
        }
        return result;
    }
}
