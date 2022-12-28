package com.cfuv.crypto;

import com.cfuv.crypto.algorithm.StrUtil;
import java.util.Scanner;

import static com.cfuv.crypto.algorithm.StrUtil.shifr;
import static com.cfuv.crypto.algorithm.StrUtil.antishifr;

public class App {
    public static void main(String[] args){
        String slovo; // наше слово
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(StrUtil.shifr(str, 2)); // шифруем
        slovo = StrUtil.shifr(str,2);
        System.out.println("Чтобы увидеть расшифрованное слово введите 1");
        Scanner scanner = new Scanner(System.in);
        int soglas = scanner.nextInt();
        if (soglas == 1) {
        System.out.println(StrUtil.antishifr(slovo,2)); //дешифруем
        }
    }
}
