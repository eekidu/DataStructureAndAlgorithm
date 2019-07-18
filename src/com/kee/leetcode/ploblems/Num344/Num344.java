package com.kee.leetcode.ploblems.Num344;

public class Num344 {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            int rpoint = s.length - 1 - i;
            change(s, i, rpoint);
        }
        System.out.println(s);
    }

    public void reverseStringV2(char[] s) {
        int lpoint = 0;
        int rpoint = s.length - 1;
        while (lpoint < rpoint) {
            change(s, lpoint, rpoint);
            lpoint++;
            rpoint--;
        }
    }

    private void change(char[] s, int left, int right) {
//        char temp = s[left];
//        s[left] = s[right];
//        s[right] = temp;

        s[left] ^= s[right];
        s[right] ^= s[left];
        s[left] ^= s[right];
    }


    public static void main(String[] args) {
        Num344 num344 = new Num344();
        char[] chars = "Hello".toCharArray();

//        num344.reverseString(chars);
        num344.reverseStringV2(chars);

        System.out.println(chars);

    }
}
