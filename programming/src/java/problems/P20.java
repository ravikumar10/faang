package src.java.problems;

public class P20 {
    public static void main(String[] args) {
        int num = 14;
        System.out.println(numberOfSteps(num));
    }

    public static int numberOfSteps (int num) {
        int r =0;
        while(num > 0) {
            r+= (1 & num) == 1 ? 2 : 1;
            num>>=1;
        }
        return r-1;
    }
}
