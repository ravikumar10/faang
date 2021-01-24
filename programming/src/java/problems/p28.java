package src.java.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class p28 {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(')
                stack.push(ch);
            if(ch == '{')
                stack.push(ch);
            if(ch == '[')
                stack.push(ch);
            if(ch == ')' )
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            if(ch == '}')
                if(!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            if(ch == ']')
                if(!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
        }

        return stack.size() == 0;
    }
}
