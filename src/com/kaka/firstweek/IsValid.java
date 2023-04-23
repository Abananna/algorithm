package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-06 13:24
 */

import java.util.Stack;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/6 13:24
 */
public class IsValid {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int flag = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
                continue;
            }
            if(stack.size() == 0){
                flag = 1;
                break;
            }
            switch (chars[i]) {
                case ')':
                    if(stack.pop() != '('){
                        flag = 1;
                        break;
                    }
                    break;
                case ']':
                    if(stack.pop() != '['){
                        flag = 1;
                        break;
                    }
                    break;
                case '}':
                    if(stack.pop() != '{'){
                        flag = 1;
                        break;
                    }
                    break;
            }
            if(flag == 1){
                break;
            }
        }
        return flag == 0;
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        String s = "{()}";
        boolean valid = isValid.isValid(s);
    }
}
