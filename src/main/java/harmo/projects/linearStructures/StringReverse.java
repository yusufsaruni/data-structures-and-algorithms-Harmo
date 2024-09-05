package harmo.projects.linearStructures;

import java.util.Stack;

public class StringReverse {


    public static void main(String[] args) {
        String string = "Hello World";
        System.out.println("Before reverse: "+string);
        System.out.println("After reverse: "+reverseString(string));
    }

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        var chars = str.toCharArray();
        for(var c: chars){
            stack.push(c);
        }
        for(int i=0; i<chars.length; i++){
            chars[i] = stack.pop();
        }
        return new String(chars);
    }
}
