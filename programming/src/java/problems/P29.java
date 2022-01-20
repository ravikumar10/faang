package src.java.problems;

public class P29 {
    public static void main(String[] args) {
        String A = "bbba1cddceeb";
        String B = "ceebbbbacdd";
        System.out.println(rotateString(A,B));
    }

    public static boolean rotateString(String A, String B) {
        if(A.equals(B))
            return true;
        if(!(A.length() > 0 && B.length() > 0))
            return false;

        int index = 0;

        while(!A.equals(B) && index < A.length() ) {
            String temp = A.substring(1);
            A = temp+A.charAt(0);
            index+=1;
        }
        return A.equals(B);
    }
}
