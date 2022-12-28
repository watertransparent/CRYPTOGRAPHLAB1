package com.cfuv.crypto.algorithm;

public class StrUtil {
    public static String shifr(String text, int step){ String res = "";
        char[] textChar = text.toCharArray();
        char[] upCh = { 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж',
                'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х',
                'Ц', 'Ч', 'Ш', 'Щ', 'Ы', 'Ь', 'Э', 'Ю', 'Я' };
        char[] lCh = { 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и','й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э','ю', 'я' };
        // задали алфавит
        // сам цикл с изменением символа, также в случае если выбраны ю или я
        for (int i=0; i<textChar.length; i++){
            int index = 0;
            boolean isNOTLetter = Character.isWhitespace(textChar[i]);
            if (!isNOTLetter){
                if (Character.isLowerCase(textChar[i])){ // для строчных букв
                    while (textChar[i] != lCh[index]) index++;
                    index +=step; // сам шаг на нужную величину
                    if (index > 31){ // уточнение в случае выбранных ю или я
                        index -= 32;
                    }
                    textChar[i] = lCh[index];
                }else if (Character.isUpperCase(textChar[i])){ // для заглавных букв
                    while (textChar[i] != upCh[index]) index++;
                    index +=step;  // сам шаг на нужную величину
                    if (index > 31){ // уточнение в случае выбранных ю или я
                        index -= 32;
                    }
                    textChar[i] = upCh[index];
                }
            }
        }
        for (char c:textChar) {
            res += c;
        }
        return res;
    }
    public static String antishifr(String text, int step){ String res = ""; // метод для расшифровывания, все тоже самое но вместо увеличения шага его уменьшение
        char[] textChar = text.toCharArray();
        char[] lCh = { 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и','й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э','ю', 'я' };
        char[] upCh = { 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж',
                'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х',
                'Ц', 'Ч', 'Ш', 'Щ', 'Ы', 'Ь', 'Э', 'Ю', 'Я' };

        for (int i=0; i<textChar.length; i++){
            int index = 0;
            boolean isNOTLetter = Character.isWhitespace(textChar[i]);
            if (!isNOTLetter){
                if (Character.isLowerCase(textChar[i])){
                    while (textChar[i] != lCh[index]) index++;
                    index -=step;
                    if (index < 0){
                        index += 32;
                    }
                    textChar[i] = lCh[index];
                }else if (Character.isUpperCase(textChar[i])){
                    while (textChar[i] != upCh[index]) index++;
                    index -=step;
                    if (index < 0){
                        index += 32;
                    }
                    textChar[i] = upCh[index];
                }
            }
        }
        for (char c:textChar) {
            res += c;
        }
        return res;
    }}
