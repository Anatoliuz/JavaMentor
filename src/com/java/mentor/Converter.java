package com.java.mentor;

import java.util.List;
import java.util.regex.Pattern;

public class Converter {
    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " не в диапазоне (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public static int romanToArabic(String inputStr) {
        if (inputStr == null ) throw new IllegalArgumentException("Невалидное число.");
        if (inputStr.isEmpty()) return 0;
        for (RomanNumeral roman : RomanNumeral.getReverseSortedValues()) {
            if (inputStr.startsWith(roman.name())) {
                return roman.getValue() + romanToArabic(inputStr.substring( roman.name().length() ));
            }
        }
        throw new IllegalArgumentException("Строка содержит невалидное римское значение.");
    }

    public static boolean isRoman(String num) {
        return Pattern.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$", num);
    }
}
