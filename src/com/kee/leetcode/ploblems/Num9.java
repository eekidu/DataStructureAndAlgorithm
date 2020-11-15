package com.kee.leetcode.ploblems;

import java.util.*;

/**
 *判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num9 {
    /**
     *  转换成字符串数组
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        char[] chars = Integer.valueOf(x).toString().toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 放入到双端队列，每次从头端和尾端取元素比较是否相同
     *
     * @param x
     * @return
     */
    public boolean isPalindromeV2(int x) {
        if (x < 0) {
            return false;
        }
        Deque<Integer> queue = new LinkedList<>();

        while (x > 0) {
            int digits = x % 10;
            queue.add(digits);
            x /= 10;
        }

        while (queue.size() > 1) {
            Integer first = queue.pollFirst();
            Integer last = queue.pollLast();
            if (!first.equals(last)) {
                return false;
            }
        }

        return true;
    }


    public boolean isPalindromeV3(int x) {
        //特殊情况：
        //1、当x<0时，x不是回文。
        //2、当末尾是0的话，第一位也得是0，才会是回文。只有0
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int leftHalf = 0;
        int rightHalf = x;

        while (rightHalf > leftHalf) {
            int item = rightHalf % 10;
            leftHalf = leftHalf * 10 + item;
            rightHalf /= 10;
        }
        //当数字长度为奇数时，我们可以通过revertedNumber/10去除处于中位的数字

        return leftHalf == rightHalf || rightHalf == leftHalf / 10;
    }


    public static void main(String[] args) {
        Num9 num9 = new Num9();
//        System.out.println(num9.isPalindrome(123));
//        System.out.println(num9.isPalindromeV2(121));
        System.out.println(num9.isPalindromeV3(0));
    }


}
