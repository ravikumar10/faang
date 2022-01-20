package src.java;

import java.util.Arrays;

public class P41 {
    public static void main(String[] args) {
        int [] nums = {2,3,0,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int []dp = new int[nums.length];

        Arrays.fill(dp, Integer.MAX_VALUE) ;
        dp[0]=0;
        for(int i = 0;i< nums.length;i++){
            int idxMax = nums[i]+i;
            for(int j =i+1; j<nums.length; j++){
                if(j>idxMax)
                    break;
                dp[j] = Math.min(dp[j], 1+dp[i]);
            }

        }

        return dp[nums.length-1];

    }
}
