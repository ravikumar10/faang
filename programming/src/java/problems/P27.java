package src.java.problems;

import java.util.*;

public class P27 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
//        int[][] intervals = {
//                {1,4},
//                {4,5}
//        };

        int[][] merge =  merge(intervals);
        for(int i =0;i<merge.length;i++){
            System.out.println(merge[i][0] +","+merge[i][1]);
        }
    }

   static public int[][] merge(int[][] intervals) {
        Map<Integer, Integer> inter = new TreeMap<>();
       List<int[]> res = new ArrayList<>();
       for(int i=0; i<intervals.length; i++){
            for(int j=0; j<2; j++){
                inter.put(intervals[i][0], intervals[i][1]);
            }
        }
        Set set = inter.entrySet();

        Iterator it = set.iterator();
        int s=0;
        int e=0;
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();

            if(e >= (int)me.getKey()) {
                e= (int) me.getValue();
            } else {
                if(e>0)
                    res.add(new int[]{s,e});
                s=(int) me.getKey();
                e=(int) me.getValue();
            }

        }
       res.add(new int[]{s,e});
       return res.toArray(new int[res.size()][]);
    }
}
