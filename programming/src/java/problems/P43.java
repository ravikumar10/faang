package src.java.problems;

import java.util.PriorityQueue;

public class P43 {
    public static void main(String[] args) {
//        int[] target = {9,3,5};
        int[] target = {1, 1000000000};
//        int[] target = {1,1,2};
//        int[] target = {5, 50};
        System.out.println(isPossible(target));
    }

    public static boolean isPossible(int[] target) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        long total = 0;
        for (int a : target) {
            total += a;
            pq.add(a);
        }
        while (true) {
            int a = pq.poll();
            total -= a;
            if (a == 1 || total == 1)
                return true;
            if (a < total || total == 0 || a % total == 0)
                return false;
            a %= total;
            total += a;
            pq.add(a);
        }
    }

    public static int findLargestIndex(int []a){
        int max = a[0];
        int idx =0;

        for(int i=1; i<a.length;i++){
            if(max <= a[i]){
                max = a[i];
                idx=i;
            }
        }

        return idx;
    }

    public static boolean checkAllOne(int []a){
        for(int i : a){
            if(i !=1)
                return false;
        }

        return true;
    }

    public static boolean checkAllGreater(int []a){
        for(int i : a){
            if(i < 1)
                return false;
        }

        return true;
    }
}
