package src.java.problems;

public class P28 {
    public static void main(String[] args) {
        int [] arr = {3,4,5,1};
        System.out.println(peakIndexInMountainArray(arr));
    }
    public static int peakIndexInMountainArray(int[] arr) {
        if(arr.length <3)
            return arr[0]>arr[1] ? 0:1;
        int peak = Integer.MIN_VALUE;
        int index = 0;
        for(int i=1; i< arr.length-1; i++){
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
                if(peak < arr[i]){
                    peak = arr[i];
                    index = i;
                }
            }
        }
        return index;
    }
}
