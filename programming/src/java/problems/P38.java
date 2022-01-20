package src.java.problems;

public class P38 {

    public static void main(String[] args) {
        int n = 4;
        int start=3;

        System.out.println(xorOperation(n,start));
    }
    public static int xorOperation(int n, int start) {
        int r = start;
        for(int i = 1; i< n;i++){
            int s = start+2*i;
            r^=(s);
        }

        return r;
    }
}
