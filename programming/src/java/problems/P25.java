package src.java.problems;

public class P25 {
    public static void main(String[] args) {
        int [] bloomDay = {1,10,3,10,2};
        int m=3, k=1;
        System.out.println(minDays(bloomDay, m, k));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int l=1, h=(int)1e9, n=bloomDay.length;

        if(m*k > n) return -1;

        while (l < h) {
            int boutq=0, flow=0;
            int mid = (l + h) / 2;
            for(int i=0; i<n ; ++i){
                if(bloomDay[i] > mid) {
                    flow = 0;
                } else if (++flow >= k) {
                    boutq++;
                    flow = 0;
                }
            }
            if(boutq < m) {
                l = mid+1;
            } else {
                h = mid;
            }
        }
        return l;
    }
}
