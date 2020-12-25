package src.java.problems.companies;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Minimum Edit Distance for converting first half to next half string
 */

public class PayPal {
    static  private  int voters =0;
    int tot ;
    public static void main(String[] args) {
        System.out.println(minSteps("123456"));
    }

    public static int minSteps(String s) {
        String first = s.substring(0, s.length()/2);
        String second = s.substring(s.length()/2, s.length());
        Map<Character, Integer> maps = new HashMap<>();
        for (char c: first.toCharArray())
            maps.put(c, maps.getOrDefault(c, 0) + 1);

        Map<Character, Integer> mapt = new HashMap<>();
        for (char c: second.toCharArray())
            mapt.put(c, mapt.getOrDefault(c, 0) +1);

        int result=0;
        for (char c = '0'; c<='9'; c++)
            result += Math.abs(maps.getOrDefault(c, 0) - mapt.getOrDefault(c, 0));
        for (char c ='0'; c <='9'; c++)
            if (mapt.getOrDefault(c, 0)> maps.getOrDefault(c, 0))
                result = result - (mapt.getOrDefault(c, 0) - maps.getOrDefault(c, 0));
        return result;
    }

}
