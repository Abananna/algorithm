package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-04 16:56
 */

import java.util.*;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/4 16:56
 */
public class RandomizedSet {

    List<Integer> myList ;
    Map<Integer,Integer> indexMap;
    Random random;

    public RandomizedSet() {
        myList = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(indexMap.containsKey(val)){
            return false;
        }
        myList.add(val);
        //维护val在list中的index
        indexMap.put(val,myList.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if(!indexMap.containsKey(val)){
            return false;
        }
        int index = indexMap.get(val);
        //不能直接删 要考虑存在map中各元素的角标
        //将list中的最后一个元素换到取出元素的位置 并更新map中该元素的index和list的size
        int last = myList.get(myList.size()-1); //得到list中最后一个元素
        myList.set(index,last);                 //将最后一个元素添加到val所在的位置
        myList.remove(myList.size() - 1);
        indexMap.put(last,index);               //更新list中最后一个元素在list中的位置
        indexMap.remove(val);                   //删除map中维护的val的index
        return true;
    }

    public int getRandom() {
        return myList.get(random.nextInt(myList.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
//        randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
//        randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
//        randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
//        randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
//        randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
//        randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
//        randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        int random1 = randomizedSet.getRandom();
    }
}
