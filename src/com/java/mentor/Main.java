package com.java.mentor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        Parser parser = new Parser();
        Expression expression = parser.parse(inputStr);
        int res = expression.compute();
        if (expression.getNumberFormat().equals(NumberFormat.ARABIC)){
            System.out.println(res);
        }
        if (expression.getNumberFormat().equals(NumberFormat.ROMAN)){
            String romanRes = Converter.arabicToRoman(res);
            System.out.println(romanRes);
        }
    }
}
