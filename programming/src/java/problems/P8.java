package src.java.problems;

import java.util.HashMap;
import java.util.Map;

public class P8 {
    public static void main(String[] args) {
        String s = "abcdeadbc";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seq = new HashMap<>();
        int start=0,end=0,result = Integer.MIN_VALUE;
        for(char c : s.toCharArray()) {
            if(seq.containsKey(c)) {
                start = Math.max(start, seq.get(c)+1);
            }
            seq.put(c, end++);
            result = Math.max(result, end-start);
        }
        return result;
    }
}


