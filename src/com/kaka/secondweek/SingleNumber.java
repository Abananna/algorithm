package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-13 10:47
 */

/**
 * @Author:Kaka
 * @Description:
 *给你一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 * @Date: 2023/4/13 10:47
 */
public class SingleNumber {
    //使用hash表空间复杂度提升到O(n)

    //
    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        //所有数进行异或操作 最后的结果为 x^y,x、y为只出现一次的数字
        for (int num: nums) {
            xorsum ^= num;
        }
        // 防止溢出 取最低位1，因为最低位1就是 x & -x
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        //分类所有出现两次的数字被成对分到相同的一类，出现一次的数字被分到不同的类
        for (int num: nums) {
            if ((num & lsb)!=0) {
                type1 ^= num;
            }
            else {
                type2 ^= num;
            }
        }
        return new int[]{type1,type2};
    }
}
