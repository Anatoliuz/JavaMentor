package com.java.mentor;

import static com.java.mentor.Converter.isRoman;

public class Parser {

    public Expression parse(String input) {
        String[] tokens = input.split(" ");
        Expression expression = new Expression();
        if (isRoman(tokens[0]) && isRoman(tokens[2])) {
            expression.setNumberFormat(NumberFormat.ROMAN);
            expression.setLeft(Converter.romanToArabic(tokens[0]));
            expression.setRight(Converter.romanToArabic(tokens[2]));
        } else {
            try {
                expression.setLeft(Integer.parseInt(tokens[0]));
                expression.setRight(Integer.parseInt(tokens[2]));
                expression.setNumberFormat(NumberFormat.ARABIC);
            } catch (NumberFormatException e) {
                System.err.println("Числа должны быть либо арабскими, либо римскими.");
                System.exit(0);
            }
        }
        if (expression.getLeft() < 1 || expression.getLeft()  > 10 || expression.getRight() < 1 || expression.getRight() > 10) {
            throw new ArithmeticException("Проверьте условие на входные числа.");
        }
        expression.setOperation(tokens[1]);
        return expression;
    }




}
