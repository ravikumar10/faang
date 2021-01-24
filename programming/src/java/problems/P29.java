package src.java.problems;

public class P29 {
    public static void main(String[] args) {
        int [] n = new int[]{1,1,1,1,1};
        removeDuplicates(n);
    }

    public static int[]  removeDuplicates(int[] nums) {
        int s = 0;
        for(int n : nums){
            if(s < 1 || nums[s-1] != n){
                nums[s++] = n;
            }
        }
        return nums;
    }
}
