package com.cfuv.crypto.algorithm;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {
    public static int evcl1(int a, int b) { // алгоритм Евклида
        int l;
        while (b != 0) {
            l = a % b;
            a = b;
            b = l;
        }
        return a;
    }

    public static int[] evcl2(int a, int b) { // обобщенный алгоритм Евклида
        int m;
        int[] z = {a, 1, 0};
        int[] c = {b, 0, 1};
        int[] v = new int[3];
        while (c[0] != 0) {
            m = z[0] / c[0];
            v[0] = z[0] % c[0];
            if (v[0] != 0) {
                v[1] = z[1] - m * c[1];
                v[2] = z[2] - m * c[2];
            }
            z = c.clone();
            c = v.clone();
        }
        return z;
    }

    public static int inversia(int a, int b) {
        int m;
        int[] z = {a, 0};
        int[] c = {b, 1};
        int[] v = new int[2];
        while (c[0] != 0) {
            m = z[0] / c[0];
            v[0] = z[0] % c[0];
            if (v[0] != 0) {
                v[1] = z[1] - m * c[1];
            }
            z = c.clone();
            c = v.clone();
        }
        if (z[1] < 0) {
            z[1] += a;
        }
        return z[1];
    }
}
