package src.java.problems.companies;
import java.util.*;

public class DPWorld {

    public static void main(String[] args) {
//        List<Integer> b =Arrays.asList( 5,4,2,15);
        List<Integer> b =Arrays.asList( 37,7,22,15,49,60);


        System.out.println(goodSegmet(b, 3,48));
    }

    public static int goodSegmet(List<Integer> badNumers, int lower, int upper){

        Collections.sort(badNumers);

        int maxLength=0;

        int start=lower;
        int end=lower;


        for(int i=lower;i<=upper;i++){
            if( ! badNumers.contains(i)){
                end++;
            }else{
                int l=end-start;
                maxLength=Math.max(maxLength, l);
                end=i+1;
                start=i+1;
            }
        }

        return Math.max(maxLength, end-start);

    }

}
