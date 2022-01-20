package src.java.problems;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P46 {
    public static void main(String[] args) {
        String s = "2K 2009-09-23 1.zip~ \n" +
                "715K 1989-09-23 1.zip~ \n" +
                "7M 1991-09-23 1.zip~";

        try {
            System.out.println(solution(s, 2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String solution(String s, int N) throws ParseException {
        String [] array = s.split("\n");

        int count=0;

        for(String st : array){
            String [] in  = st.split(" ");
            String  size  = in[0];
            String  date  = in[1];
            String  name  = in[2];

            if(checkSize(size) && checkDate(date) && checkFile(name)){
               count++;
            }
        }

        return String.valueOf(count);

    }

    public static boolean checkSize(String s){
        if(s.length() > 5){
            return false;
        }

        int fileSize = Integer.parseInt(s.substring(0,s.length()-1));
        char unit = s.charAt(s.length()-1);

        if(unit == 'K'){
            return fileSize/1024 < 14;
        }

        if(unit == 'G'){
            return fileSize*1024 < 14;
        }

        if(unit == 'K'){
            return fileSize < 14;
        }

        return fileSize/(1024*1024) < 14;
    }

    public static boolean checkDate(String s) throws ParseException {
        if(s.length() > 10){
            return false;
        }
        Date date=new SimpleDateFormat("yyyy-mm-dd").parse("1990-01-31");
        Date date1=new SimpleDateFormat("yyyy-mm-dd").parse(s);


        return date1.after(date);
    }

    public static boolean checkFile(String s){
       if(!s.endsWith("~")){
           return false;
       }

       return true;
    }
}
