package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-08 11:09
 */


/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/8 11:09
 */
public class SumTargetSequence {
    public static final int MOD = 1000000007;
    public int solve(String temp) {
        //开一个hash表存储 a,ab,abc, abcb, abcba分别出现的次数
        //其中ab的值等于a的次数+
        int[] arr = new int[5]; //0,1,2,3,4分表代表 a,ab,abc, abcb, abcba出现的次数
        for (char c : temp.toCharArray()) {
            if (c == 'a') {
                arr[0] = (arr[0] + 1) % MOD;
                arr[4] = (arr[4] + arr[3]) % MOD;
            } else if (c == 'b') {
                arr[1] = (arr[1] + arr[0]) % MOD;
                arr[3] = (arr[3] + arr[2]) % MOD;
            } else {
                arr[2] = (arr[1] + arr[2]) % MOD;
            }
        }
        return arr[4];
    }
}
