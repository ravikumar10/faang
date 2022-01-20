package src.java.problems.companies;

import java.util.Collections;
import java.util.PriorityQueue;

public class Vmware {
    public static void main(String[] args) {
        int d = 5;
        int[] txn = {2, 3, 4, 2, 3, 6, 8, 4, 5};

        int result = countFradulentTxn(txn, d);
        System.out.println(result);
    }

    static int countFradulentTxn(int[] txn, int d) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        if(d > txn.length)
            return -1;
        int i=0;

        int count=0;
        int d1 = d;
        while(d-- > 0){
            minPq.add(txn[i++]);
            maxPq.add(minPq.poll());

            if(maxPq.size() > minPq.size()){
                minPq.add(maxPq.poll());
            }
        }

        for(int j = i; j<txn.length; j++){

            if(d1%2 == 1){
                int median = minPq.peek();
                if(median*2 <= txn[j]){
                    count++;
                }
            } else {
                int median = (minPq.peek()+maxPq.peek())/2;
                if(median*2 <= txn[j]){
                    count++;
                }
            }

            if(minPq.contains(txn[j-d1])){
                minPq.remove(txn[j-d1]);

                if(maxPq.size() > minPq.size()){
                    minPq.add(maxPq.poll());
                }
            } else {
                maxPq.remove(txn[j-d1]);
                if(maxPq.size() < minPq.size()){
                    minPq.add(maxPq.poll());
                }
            }

            minPq.add(txn[j]);
            maxPq.add(minPq.poll());

            if(maxPq.size() > minPq.size()){
                minPq.add(maxPq.poll());
            }
        }

        return count;
    }
}

