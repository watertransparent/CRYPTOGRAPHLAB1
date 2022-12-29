package com.cfuv.crypto;

import com.cfuv.crypto.algorithm.StrUtil;
import java.util.Scanner;

import static com.cfuv.crypto.algorithm.StrUtil.evcl1;
import static com.cfuv.crypto.algorithm.StrUtil.evcl2;
import static com.cfuv.crypto.algorithm.StrUtil.inversia;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        int[] z;
        System.out.println("Введите 2 числа");
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        System.out.print("Для использования алгоритма Евклида введите 1");
        int brr1 = sc.nextInt();
        if (brr1 == 1) {
            System.out.println(evcl1(a, b));
        }
        z = evcl2(a,b);
        System.out.print("Для использования обобщенного алгоритма Евклида введите 1");
        int brr2 = sc.nextInt();
        if (brr2 == 1) {
            for (int i : z){
                System.out.print(i);
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.print("Для нахождения инверсии введите 1");
        int brr = sc.nextInt();
        if (brr == 1) {
            System.out.println(inversia(a, b));
        }
    }
}
