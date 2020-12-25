package src.java.problems;

public class P17 {
    public static void main(String[] args) {
//        int [] A = {1,2,3,1,1,3};
        int [] A = {1,1,1,1};
        System.out.println(numIdenticalPairs(A));
    }


    public static int numIdenticalPairs(int[] A) {
        int r = 0, c[] = new int[101];
        for (int a: A) {
            r += c[a]++;
        }
        return r;
    }
}
