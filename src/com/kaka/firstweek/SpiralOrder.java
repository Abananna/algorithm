package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-06 10:39
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:Kaka
 * @Description: 螺旋矩阵 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @Date: 2023/4/6 10:39
 */
public class SpiralOrder {
    /**
     * 圈圈包裹 一圈一圈取  维护开始结点即可
     *
     */
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int xLen = mat[0].length;
        int yLen = mat.length;
        int INF = 101;
        //代表          向右   向下   向左   向上 四个方向
        int[][] dirs ={{0,1},{1,0},{-1,0},{0,-1}};

        for (int x = 0, y = 0, d = 0, i = 0; i < xLen * yLen; i++) {
            ans.add(mat[x][y]);
            mat[x][y] = INF;//用来标记已经走过
            int nx = x + dirs[d][0], ny = y + dirs[d][1];
            if(nx < 0 || nx >= xLen || y < 0 || y > yLen || mat[nx][ny] == INF){
                d = (d+1) % 4;//按顺序换方向 右->下->左->上
                nx = x + dirs[d][0] ;
                ny = y + dirs[d][1];
            }
            x = nx;
            y = ny;
        }
        return ans;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = spiralOrder.spiralOrder(matrix);
        System.out.println(list);
    }
}
