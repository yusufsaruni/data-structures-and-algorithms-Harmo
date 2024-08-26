package harmo.projects.linearStructures;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {4,7,3,4,8,1};
        var nextGreater = nextGreaterElement(arr);
        System.out.println(Arrays.toString(nextGreater));

        System.out.println("Is valid String: "+ isValidString("[}"));
        System.out.println("Is valid String: "+ isValidString("({})"));
    }

    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--) {
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i] = -1;
            }else{
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    public static boolean isValidString(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '('||c =='{'||c == '[') {
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }else{
                    char top = stack.peek();
                    if(c == ')' && top == '('||
                    c == '}' && top == '{'||
                    c == ']' && top == '[') {
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
