package com.cfuv.crypto.algorithm;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {
    public static String shifr(String text){
       String res ="";
       int code = 0;
       text = text.toLowerCase(); // переводим все буквы в строчные чтобы не вводить алфавит с заглавными
       text = text.replaceAll("\\s+", "");

       if (text.length() % 3 == 1) {
           text = text + "ёё";
       } else if (text.length() % 3 == 2){
           text = text + "ё";
       }

       char[] textChar = text.toCharArray();
       char[] Ch = { 'а', 'б', 'в', 'г', 'д', 'е', 'ж',
               'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
               'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'э', 'я'}; // вводим алфавит
       int[] codeList = new int[textChar.length];
       int matriceLength = textChar.length / 3;

       int[][] codeMatrice = new int[3][matriceLength];

       int[][] encryptionMatrice = {{6,24,1}, {13,16,10}, {20,17,15}}; // ввели матрицу для зашифровки
       for (int i = 0; i < textChar.length; i++) {
           switch (textChar[i]) {
               case ('а'):
                   code = 0;
                   break;
               case ('б'):
                   code = 1;
                   break;
               case ('в'):
                   code = 2;
                   break;
               case ('г'):
                   code = 3;
                   break;
               case ('д'):
                   code = 4;
                   break;
               case ('е'):
                   code = 5;
                   break;
               case ('ж'):
                   code = 6;
                   break;
               case ('з'):
                   code = 7;
                   break;
               case ('и'):
                   code = 8;
                   break;
               case ('к'):
                   code = 9;
                   break;
               case ('л'):
                   code = 10;
                   break;
               case ('м'):
                   code = 11;
                   break;
               case ('н'):
                   code = 12;
                   break;
               case ('о'):
                   code = 13;
                   break;
               case ('п'):
                   code = 14;
                   break;
               case ('р'):
                   code = 15;
                   break;
               case ('с'):
                   code = 16;
                   break;
               case ('т'):
                   code = 17;
                   break;
               case ('у'):
                   code = 18;
                   break;
               case ('ф'):
                   code = 19;
                   break;
               case ('х'):
                   code = 20;
                   break;
               case ('ц'):
                   code = 21;
                   break;
               case ('ч'):
                   code = 22;
                   break;
               case ('ш'):
                   code = 23;
                   break;
               case ('э'):
                   code = 24;
                   break;
               case ('я'):
                   code = 25;
                   break;
           }
           codeList[i] = code;
    }
       int j = 0;
       int i = 0;
       for (int x : codeList){
           codeMatrice[i][j] = x;
           i += 1;
           if (i == 3) {
               i = 0;
               j += 1;
           }
       }
       int[][] encryptionCodeMatrice = new int[3][matriceLength];

       for (int l = 0; l < matriceLength; l++) {
           encryptionCodeMatrice[0][l] = (encryptionMatrice[0][0] * codeMatrice[0][l] +
                   encryptionMatrice[0][1] * codeMatrice[1][l] + encryptionMatrice[0][2] * codeMatrice[2][l]) % 26;
           encryptionCodeMatrice[1][l] = (encryptionMatrice[1][0] * codeMatrice[0][l] +
                   encryptionMatrice[1][1] * codeMatrice[1][l] + encryptionMatrice[1][2] * codeMatrice[2][l]) % 26;
           encryptionCodeMatrice[2][l] = (encryptionMatrice[2][0] * codeMatrice[0][l] +
                   encryptionMatrice[2][1] * codeMatrice[1][l] + encryptionMatrice[2][2] * codeMatrice[2][l]) % 26;
       }
       for (j = 0; j < matriceLength; j++) {
           for (i = 0; i < 3; i++) {
               res = res + Ch[encryptionCodeMatrice[i][j]];
           }
           }
        return res;
    }

    public static String antishifr(String text){
        String res ="";
        int code = 0;
        text = text.toLowerCase();
        text = text.replaceAll("\\s+", "");
        char[] textChar = text.toCharArray();
        char[] Ch = { 'а', 'б', 'в', 'г', 'д', 'е', 'ж',
                'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'э', 'я'};
        int[] codeList = new int[textChar.length];
        int matriceLength = textChar.length / 3;

        if (textChar.length % 3 != 0){
            matriceLength += 1;
        }

        int[][] codeMatrice = new int[3][matriceLength];
        int[][] decryptionMatrice = {{8,5,10}, {21,8,21}, {21,12,8}};
        for (int i = 0; i < textChar.length; i++) {
            switch (textChar[i]) {
                case ('а'):
                    code = 0;
                    break;
                case ('б'):
                    code = 1;
                    break;
                case ('в'):
                    code = 2;
                    break;
                case ('г'):
                    code = 3;
                    break;
                case ('д'):
                    code = 4;
                    break;
                case ('е'):
                    code = 5;
                    break;
                case ('ж'):
                    code = 6;
                    break;
                case ('з'):
                    code = 7;
                    break;
                case ('и'):
                    code = 8;
                    break;
                case ('к'):
                    code = 9;
                    break;
                case ('л'):
                    code = 10;
                    break;
                case ('м'):
                    code = 11;
                    break;
                case ('н'):
                    code = 12;
                    break;
                case ('о'):
                    code = 13;
                    break;
                case ('п'):
                    code = 14;
                    break;
                case ('р'):
                    code = 15;
                    break;
                case ('с'):
                    code = 16;
                    break;
                case ('т'):
                    code = 17;
                    break;
                case ('у'):
                    code = 18;
                    break;
                case ('ф'):
                    code = 19;
                    break;
                case ('х'):
                    code = 20;
                    break;
                case ('ц'):
                    code = 21;
                    break;
                case ('ч'):
                    code = 22;
                    break;
                case ('ш'):
                    code = 23;
                    break;
                case ('э'):
                    code = 24;
                    break;
                case ('я'):
                    code = 25;
                    break;
            }
            codeList[i] = code;
        }
        int j = 0;
        int i = 0;
        for (int x : codeList){
            codeMatrice[i][j] = x;
            i += 1;
            if (i == 3) {
                i = 0;
                j += 1;
            }
        }
        int[][] decryptionCodeMatrice = new int[3][matriceLength];

        for (int l = 0; l < matriceLength; l++) {
            decryptionCodeMatrice[0][l] = (decryptionMatrice[0][0] * codeMatrice[0][l] +
                    decryptionMatrice[0][1] * codeMatrice[1][l] + decryptionMatrice[0][2] * codeMatrice[2][l]) % 26;
            decryptionCodeMatrice[1][l] = (decryptionMatrice[1][0] * codeMatrice[0][l] +
                    decryptionMatrice[1][1] * codeMatrice[1][l] + decryptionMatrice[1][2] * codeMatrice[2][l]) % 26;
            decryptionCodeMatrice[2][l] = (decryptionMatrice[2][0] * codeMatrice[0][l] +
                    decryptionMatrice[2][1] * codeMatrice[1][l] + decryptionMatrice[2][2] * codeMatrice[2][l]) % 26;
        }
        for (j = 0; j < matriceLength; j++) {
            for (i = 0; i < 3; i++) {
                res = res + Ch[decryptionCodeMatrice[i][j]];
            }
        }
        while (res.endsWith("j")){
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }
       }