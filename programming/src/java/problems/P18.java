package src.java.problems;

import java.util.Stack;

public class P18 {
    public static void main(String[] args) {
        String s = "(1+((2+(((3";
        System.out.println(maxDepth(s));
    }

    public static int maxDepth(String s) {
        int r = 0, curChar = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                r = Math.max(r, ++curChar);
            if (s.charAt(i) == ')')
                curChar--;
        }
        return r;
    }
}
