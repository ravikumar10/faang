package src.java.problems;

import java.util.HashMap;
import java.util.Map;

public class P7 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int target = 7;
        int [] result = twoSum(nums, target);
        System.out.println(result[0] +" : "+ result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        Map<Integer, Integer> f = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(f.containsKey(target-nums[i])){
                result[0] = i;
                result[1] = f.get(target-nums[i]);
                break;
            }
            f.put(nums[i], i);
        }
        return result;
    }
}

/*
https://leetcode.com/problems/two-sum/

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 */
