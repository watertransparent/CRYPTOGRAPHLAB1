package com.cfuv.crypto.algorithm;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {
    public static String shifr(String text, String codeWord){
        StringBuilder res = new StringBuilder();
        text = text.toLowerCase();
        codeWord = codeWord.toLowerCase();
        char[] textChar = text.toCharArray();
        final char[] codeChar = codeWord.toCharArray();
        final char[] Ch = { 'а', 'б', 'в', 'г', 'д', 'е', 'ж',
                'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ы', 'ь', 'э','ю', 'я',' '};
        int index;
        int codeIndex = 0;
        int step;

        for (int i = 0; i < textChar.length; i++) {
            step = 0;
            index = 0;
            while (codeChar[codeIndex] != Ch[step]) step++;
            while (textChar[i] != Ch[index]) index++;
            index += step;
                if (index > 30) {
                index -= 31;
            }
            textChar[i] = Ch[index];
            codeIndex++;
            if (codeIndex == codeWord.length()) {
                codeIndex = 0;
            }
        }
        for (char c : textChar) {
            res.append(c);
        }
        return res.toString();
    }

    public static String antishifr(String text, String codeWord){
        StringBuilder res = new StringBuilder();
        text = text.toLowerCase();
        codeWord = codeWord.toLowerCase();
        char[] textChar = text.toCharArray();
        final char[] codeChar = codeWord.toCharArray();
        final char[] Ch = { 'а', 'б', 'в', 'г', 'д', 'е','ж',
                'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ы', 'ь', 'э','ю', 'я',' '};
        int index;
        int codeIndex = 0;
        int step;

        for (int i = 0; i < textChar.length; i++) {
            step = 0;
            index = 0;
            while (codeChar[codeIndex] != Ch[step]) step++;
            while (textChar[i] != Ch[index]) index++;
            index -= step;
            if (index < 0) {
                index += 31;
            }
            textChar[i] = Ch[index];
            codeIndex++;
            if (codeIndex == codeWord.length()) {
                codeIndex = 0;
            }
        }
        for (char c : textChar) {
            res.append(c);
        }
        return res.toString();
    }
}
