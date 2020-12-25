package src.java.problems;

/*

Problem Statement :
        Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.

        Example 1:

            Input: "aappp"
            Output: "papap"
            Explanation: In "papap", none of the repeating characters come next to each other.

        Example 2:

            Input: "Programming"
            Output: "rgmrgmPiano" or "gmringmrPoa" or "gmrPagimnor", etc.
            Explanation: None of the repeating characters come next to each other.


        Example 3:

            Input: "aapa"
            Output: ""
            Explanation: In all arrangements of "aapa", atleast two 'a' will come together e.g., "apaa", "paaa".

 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P5 {
    public static String getRearrangedString(String inputString){
        Map<Character, Integer> charFreqUencyCount = new HashMap<>();
        for(char c : inputString.toCharArray()){
            charFreqUencyCount.put(c, charFreqUencyCount.getOrDefault(c,0 )+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((c1, c2) -> c2.getValue() - c1.getValue());
        maxHeap.addAll(charFreqUencyCount.entrySet());

        Map.Entry<Character, Integer> prev = null;
        StringBuilder result = new StringBuilder(inputString.length());

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> curent = maxHeap.poll();
            if(prev != null && prev.getValue() > 0)
                maxHeap.offer(prev);
            result.append(curent.getKey());
            curent.setValue(curent.getValue()-1);
            prev = curent;
        }

        return result.length() == inputString.length()? result.toString() : "*** Cannot rearrange ***";
    }

    public static void main(String[] args) {
        System.out.println(getRearrangedString("aappp"));
        System.out.println(getRearrangedString("Programming"));
        System.out.println(getRearrangedString("aapa"));
    }
}

/*



 */