package com.cfuv.crypto;

import com.cfuv.crypto.algorithm.StrUtil;
import java.util.Scanner;

import static com.cfuv.crypto.algorithm.StrUtil.shifr;
import static com.cfuv.crypto.algorithm.StrUtil.antishifr;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        String string;
        System.out.println("Введите текст для зашифровки");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print("Длина текста: ");
        System.out.println(str.length());
        System.out.println(shifr(str));
        string = shifr(str);
        System.out.print("Для расшифровки введите 1");
        int brr = sc.nextInt();
        if (brr == 1) {
            System.out.println(antishifr(string));
        }
    }
}
