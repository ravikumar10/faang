package src.java.problems;

import java.util.ArrayList;
import java.util.List;

public class P30 {
    public static void main(String[] args) {
        String S =  "Jw";
        letterCasePermutation(S).stream().forEach(System.out::println);
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        helper(res, S, 0);
        return res;
    }

    private static void helper(List<String> res, String s,int start) {
        res.add(s);
        char[] c = s.toCharArray();
        for(int i=start; i<c.length; i++){
            if(Character.isDigit(c[i])) continue;
            char p = 0;
            if(Character.isLowerCase(c[i]))
                p = Character.toUpperCase(c[i]);
            if(Character.isUpperCase(c[i]))
                p = Character.toLowerCase(c[i]);
            c[i] = p;
            helper(res, String.valueOf(c), i+1);
            if(Character.isDigit(c[i])) continue;
            p = 0;
            if(Character.isLowerCase(c[i]))
                p = Character.toUpperCase(c[i]);
            if(Character.isUpperCase(c[i]))
                p = Character.toLowerCase(c[i]);
            c[i] = p;
        }
    }
}
