package src.java.problems.companies;

public class SmartNews2 {
    public static void main(String[] args) {
//        int [] A = {7 , -5 , -5 , -5 , 7 , -1 , 7};
        int [] A = {7 , 4 , -2 , 4 , -2 , 9 , 7};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        if(A.length <= 2)
            return A.length;

        int res = 2;
        int t_res=2;

        for(int i=2;i<A.length;i++){
            if(A[i]==A[i-2])
                t_res = t_res+1;
            else
                t_res = 2;
            res = Math.max(res, t_res);
        }

        return res;
    }
}
