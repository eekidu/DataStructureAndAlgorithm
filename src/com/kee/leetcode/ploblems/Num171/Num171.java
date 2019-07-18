package com.kee.leetcode.ploblems.Num171;

/**
 * 171. Excel表列序号
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class Num171 {

    public int titleToNumber(String s) {
        char[] chars = s.toUpperCase().toCharArray();
        int count = 0;
        for (int length = chars.length - 1; length >= 0; length--) {
            int pow = (int) Math.pow(26, chars.length - length - 1);
            int currentNum = (byte) chars[length] - (byte) 'A' + 1;
            count += currentNum * pow;
        }
        return count;
    }

    public int titleToNumberV2(String s) {
        char[] chars = s.toUpperCase().toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            int curNum = chars[i] - 'A' + 1;
            ans = ans * 26 + curNum;
        }

        return ans;
    }

    public static void main(String[] args) {


        Num171 num171 = new Num171();
        int count = num171.titleToNumber("AA");
        int ans = num171.titleToNumberV2("AA");
        System.out.println(count + " " + ans);

    }

}
