package com.kee.leetcode.ploblems;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 */
public class Num557 {

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            stringBuilder.append(reverse(split[i]));
            if(i<split.length-1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    private String reverse(String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Num557 num557 = new Num557();
        String ans = num557.reverseWords("Let's take LeetCode contest");
        System.out.println(ans);
    }
}
