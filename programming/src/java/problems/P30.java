package src.java.problems;

public class P30 {
    public static void main(String[] args) {
        int [] n = new int[]{1,1,1,1,1,2,3,4};
        removeDuplicates(n, 1);

    }

    public static int[]  removeDuplicates(int[] nums, int val) {
        int s = 0;
        for(int n : nums){
            if(n != val){
                nums[s++] = n;
            }
        }
        return nums;
    }
}
