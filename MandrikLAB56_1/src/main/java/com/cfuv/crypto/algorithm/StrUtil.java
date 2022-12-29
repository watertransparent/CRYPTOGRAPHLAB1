package com.cfuv.crypto.algorithm;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {
    public static String shifr(String text){
     int s = 0;
     StringBuilder res = new StringBuilder();
     String str;
     final int  [][] magicSquare = {{16,3,2,13}, {9,6,7,12}, {5,10,11,8}, {4,15,14,1}}; // сам магический квадрат
     String[][] Square = new String [4][4];

     for (int y = 0; y < 4; y+= 1) { // готовим квадрат для шифровки
         for (int x = 0; x < 4; x += 1){
             Square[y][x] = "";
         }
     }

     int nx = 0;
     int ny = 0;

     while (s < text.length()) { // цикл для внесения символа в соответствующий индекс
         for (int i = 0; i < 16; i += 1){
             if (s < text.length()) {
                 str = text.substring(s, s + 1);
                 for (int y = 0; y < 4; y += 1) {
                     for (int x = 0; x < 4; x += 1) {
                         if (magicSquare[y][x] == i + 1){
                             nx = x;
                             ny = y;
                         }
                     }
                 }
                 Square[ny][nx] = str;
             }
             s += 1;
         }
         for (int y = 0; y < 4; y += 1){
             for (int x = 0; x < 4; x += 1) {
                 res.append(Square[y][x]);
                 Square[y][x] = "";
             }
         }
     }
     return res.toString();
    }
    public static String antishifr(String text){
        int s = 0;
        final int[][] magicSquare = {{16,3,2,13}, {9,6,7,12}, {5,10,11,8}, {4,15,14,1}};
        String[][] Square = new String [4][4];

        for (int y = 0; y < 4; y+= 1) {
            for (int x = 0; x < 4; x += 1){
                Square[y][x] = "";
            }
        }
        StringBuilder res = new StringBuilder();

        while (s < text.length()) {
            for (int y = 0; y < 4; y += 1) {
                for (int x = 0; x < 4; x += 1) {
                    if (s < text.length()) {
                        Square [y][x] = text.substring(s, s + 1);
                        s += 1;
                    }
                }
            }
            for (int i = 0; i < 16; i += 1) {
                for (int y = 0; y < 4; y += 1){
                    for (int x = 0; x < 4; x += 1) {
                        if (magicSquare[y][x] == i + 1) {
                            res.append(Square[y][x]);
                        }
                    }
                }
            }
            for (int y = 0; y < 4; y += 1){
                for (int x = 0; x < 4; x += 1) {
                    Square[y][x] = "";
                }
            }
        }
        return res.toString();
    }
    public static String shifr2(String text, String codeWord){
        StringBuilder res = new StringBuilder();
        text = text.toLowerCase();
        codeWord = codeWord.toLowerCase();
        char[] textChar = text.toCharArray();
        final char[] codeChar = codeWord.toCharArray();
        final char[] Ch = { 'а', 'б', 'в', 'г', 'д', 'е', 'ж',
                'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'э', 'я'};
        int index;
        int codeIndex = 0;
        int step;

        for (int i = 0; i < textChar.length; i++) {
            step = 0;
            index = 0;
            while (codeChar[codeIndex] != Ch[step]) step++;
            while (textChar[i] != Ch[index]) index++;
            index += step;
            if (index > 26) {
                index -= 27;
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

    public static String antishifr2(String text, String codeWord){
        StringBuilder res = new StringBuilder();
        text = text.toLowerCase();
        codeWord = codeWord.toLowerCase();
        char[] textChar = text.toCharArray();
        final char[] codeChar = codeWord.toCharArray();
        final char[] Ch = { 'а', 'б', 'в', 'г', 'д', 'е', 'ж',
                'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'э', 'я'};
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
                index += 27;
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
