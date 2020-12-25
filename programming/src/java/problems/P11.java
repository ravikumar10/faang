package src.java.problems;

import java.util.*;

public class P11 {

    public static void main(String[] args) {
        String []A = {"bella","label","roller"};
        commonChars(A);
    }
    public static List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] f = new int[26];
            str.chars().forEach(c -> ++f[c - 'a']);
            for (int i = 0; i < 26; ++i) {
                count[i] = Math.min(f[i], count[i]);
            }
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) { result.add("" + c); }
        }
        return result;
    }
}
