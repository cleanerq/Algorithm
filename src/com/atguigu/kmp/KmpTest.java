package com.atguigu.kmp;

public class KmpTest {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext(str2);
        System.out.println(kmpSearch(str1, str2, next));
    }

    //获取到一个字符串(子串) 的部分匹配值表
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        char[] chars = dest.toCharArray();
        for (int i = 1, j = 0; i < chars.length; i++) {
            while (j > 0 && chars[i] != chars[j]) {
                j = next[j - 1];
            }

            if (chars[i] == chars[j]) {
                j++;
            }
            next[i] = j;
        }


        return next;
    }

    public static int kmpSearch(String str1, String str2, int[] next) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        for (int i = 0, j = 0; i < chars1.length; i++) {
            while (j > 0 && chars1[i] != chars2[j]) {
                j = next[j - 1];
            }
            if (chars1[i] == chars2[j]) {
                j++;
            }
            if (j == chars2.length) {
                return i - j + 1;
            }
        }
        return -1;
    }
}
