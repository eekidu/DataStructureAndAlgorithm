package com.kee.leetcode.ploblems.Num292;

/**
 * 292. Nim 游戏
 * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 * <p>
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nim-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num292 {

    /**
     * 赢：1、2、3   5、6、7      9、10、11
     * 输：       4           8           12
     *
     * 石头数量不能被4整除，可以赢得比赛
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }


    public static void main(String[] args) {
        Num292 num292 = new Num292();
        boolean b = num292.canWinNim(5);
        System.out.println(b);
    }
}
