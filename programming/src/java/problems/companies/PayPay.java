package src.java.problems.companies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class PayPay {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            if(!line.isEmpty()){
                String [] input = line.split(";");
                float pp = Float.parseFloat(input[0]);
                float ch = Float.parseFloat(input[1]);

                double change = ch - pp;
                if(change < 0){
                    System.out.println("ERROR");
                } else if( change == 0){
                    System.out.println("ZERO");
                } else {
                    System.out.println(getChange(change));
                }

            }
        }
    }

    static String getChange(double ch){
        String text = "";
        DecimalFormat df = new DecimalFormat("########.##");
        int intChange = (int) (Double.valueOf(df.format(ch))*100);

        while(intChange >= 0.01){
            if(intChange >= 10000){
                text += "ONE HUNDRED";
                intChange -= 10000;
            } else if(intChange >= 5000){
                text += "FIFTY";
                intChange -= 5000;
            } else if(intChange >= 2000){
                text += "TWENTY";
                intChange -= 2000;
            } else if(intChange >= 1000){
                text += "TEN";
                intChange -= 1000;
            } else if(intChange >= 500){
                text += "FIVE";
                intChange -= 500;
            } else if(intChange >= 200){
                text += "TWO";
                intChange -= 200;
            } else if(intChange >= 100){
                text += "ONE";
                intChange -= 100;
            } else if(intChange >= 50){
                text += "HALF DOLLAR";
                intChange -= 50;
            } else if(intChange >= 25){
                text += "QUARTER";
                intChange -= 25;
            } else if(intChange >= 10){
                text += "DIME";
                intChange -= 10;
            } else if(intChange >= 5){
                text += "NICKEL";
                intChange -= 5;
            } else if(intChange >= 1){
                text += "PENNY";
                intChange -= 1;
            }
        }

        return text;
    }

}
