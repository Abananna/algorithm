package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-08 10:10
 */

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author:Kaka
 * @Description: 给定一个仅有大小写字符构成的字符串 s ，请返回一个满足以下要求的新字符串。
 *               新字符串中小写字符均在左边，大写字符均在右边。
 *               大写字符间的相对顺序不变，小写字符间的相对顺序不变。
 */
public class StringReSort {
    public String solve3(String s) {
        int N = s.length();
        int n = 0;
        char[] sc = s.toCharArray();
        char[] res = new char[N];
        for (char a : sc){
            if (a >= 'a' && a <= 'z'){
                n++;
            }
        }
        int i = 0, j = n;
        for (char a : sc){
            if (a >= 'a' && a <= 'z'){
                res[i++] = a;
            }else{
                res[j++] = a;
            }
        }
        return String.valueOf(res);
    }
    public String solve2(String s) {
        StringBuilder a=new StringBuilder();
        StringBuilder b=new StringBuilder();
        for(char c:s.toCharArray()){
            if('a'<=c&&c<='z')
                a.append(c);
            else
                b.append(c);
        }
        return a.toString()+b.toString();
    }

    public static void main(String[] args) {
        StringReSort stringReSort = new StringReSort();
        String s = "kyClMl";
        String solve = stringReSort.solve2(s);
        System.out.println(solve);
    }
}
