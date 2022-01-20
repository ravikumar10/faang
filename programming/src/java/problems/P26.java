package src.java.problems;

import java.util.Arrays;

public class P26 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,1,3}));
    }

    static public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(j+nums[j] >= i && dp[j]!= Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        if(dp[nums.length-1]<Integer.MAX_VALUE){
            return true;
        } else {
            return false;
        }
    }
}
