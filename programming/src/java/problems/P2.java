package src.java.problems;

/*
Problem Statement
        Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length
        of the longest contiguous subarray having all 1s.

        Example 1:
        Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
        Output: 6
        Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.

        Example 2:
        Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
        Output: 9
        Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.

*/

public class P2 {
    public static int findLongestContigousSub(int [] arr, int k) {
        int start =0, maxLen=0, max1Cnt =0;
        for(int end =0; end<arr.length; end ++) {
            if(arr[end] ==1 ) {
                max1Cnt++;
            }
            if(end - start+1 -max1Cnt > k) {
                if(arr[start] == 1) {
                    max1Cnt--;
                }
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;

    }
    public static void main(String[] args) {
        System.out.println(findLongestContigousSub(new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println(findLongestContigousSub(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}

/*

Time Complexity #
The time complexity of the above algorithm will be O(N)O(N) where ‘N’ is the count of numbers in the input array.

Space Complexity #
The algorithm runs in constant space O(1)O(1).

 */
