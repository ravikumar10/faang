package src.java.problems;

import java.util.PriorityQueue;

public class P39 {
    public static void main(String[] args) {
        int [][] matrix = new int[][]{
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };

        int k=3;
        System.out.println(kthSmallest(matrix, k));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((t1, t2) -> t1.val-t2.val);

        int r = matrix.length;
        int c = matrix[0].length;

        for(int i=0; i<r; i++){
            pq.add(new Tuple(i,0, matrix[i][0]));
        }
        Tuple t = null;
        while(k-- > 0){
            t = pq.remove();
            int row = t.r;
            int col = t.c;
            if(col+1 < c){
                pq.add(new Tuple(row,col+1, matrix[row][col+1]));
            }
        }

        return matrix[t.r][t.c];
    }

    static class Tuple {
        public int r;
        public int val;
        public int c;

        public Tuple(int r, int c, int matrix) {
            this.r = r;
            this.c = c;
            this.val = matrix;
        }
    }
}
