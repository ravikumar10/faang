package src.java.problems;

/*
Problem Statement :

        Given a string, find the length of the longest substring in it with no more than K distinct characters.

        Example 1:

        Input: String="araaci", K=2
        Output: 4
        Explanation: The longest substring with no more than '2' distinct characters is "araa".

        Example 2:

        Input: String="araaci", K=1
        Output: 2
        Explanation: The longest substring with no more than '1' distinct characters is "aa".

*/

import java.util.HashMap;
import java.util.Map;

public class P1 {
    public static void main(String[] args) {
        System.out.println(findLongestLength("araaci", 2));
        System.out.println(findLongestLength("cbbebi", 3));

    }

    public static int findLongestLength(String str, int k) {
        if(str == null || str.length() ==0 || str.length() < k) {
            throw new IllegalArgumentException();
        }

        int start = 0, maxLen = 0;
        Map<Character, Integer> frequesncyMap = new HashMap<>();

        for(int end = 0; end< str.length(); end++) {
            char rightChar = str.charAt(end);
            frequesncyMap.put(rightChar, frequesncyMap.getOrDefault(rightChar,0)+1);
            while(frequesncyMap.size() > k) {
                char leftChar = str.charAt(start);
                frequesncyMap.put(leftChar, frequesncyMap.get(leftChar)-1);
                if(frequesncyMap.get(leftChar) == 0) {
                    frequesncyMap.remove(leftChar);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start +1);
        }
        return maxLen;
    }


}

/*

Time Complexity #
The time complexity of the above algorithm will be O(N)O(N) where ‘N’ is the number of characters in the input string. The outer for loop runs for all characters and the inner while loop processes each character only once, therefore the time complexity of the algorithm will be O(N+N)O(N+N) which is asymptotically equivalent to O(N)O(N).

Space Complexity #
The space complexity of the algorithm is O(K)O(K), as we will be storing a maximum of ‘K+1’ characters in the HashMap.

 */
