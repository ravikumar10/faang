package src.java.problems;

import java.util.HashMap;
import java.util.Map;

public class P52 {

    public static void main(String[] args) {
        String s = "abaccc";

        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> m = new HashMap<>();

        int start =0;

        int max = 0;

        for(int end = 0; end< s.length(); end++){
            char c = s.charAt(end);

            m.put(c, m.getOrDefault(c, 0)+1);

            while(m.size() > 2){
                char delete = s.charAt(start);
                m.put(delete, m.get(delete)-1);
                if(m.get(delete) == 0)
                    m.remove(delete);
                start++;

            }

            max = Math.max(max, end-start+1);
        }

        return max;
    }

}
