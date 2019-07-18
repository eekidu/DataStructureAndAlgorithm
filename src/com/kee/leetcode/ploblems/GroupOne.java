package com.kee.leetcode.ploblems;

import com.kee.pojo.ListNode;

import java.util.*;

public class GroupOne {

    public static void main(String[] args) {
        GroupOne groupOne = new GroupOne();
        int abcde = groupOne.lengthOfLongestSubstring("aabce");
        System.out.println(abcde);

    }

    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int maxLength = 0;

        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, set.size());
            }
        }
        return maxLength;
    }

    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringV2(String s) {
        int n = s.length();
        int i = 0, j = 0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        while (i < n && j < n) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(i)), i);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return maxLength;
    }


    /**
     * 两数之和
     *
     * @param ln1
     * @param ln2
     * @return
     */
    public ListNode addTwoNumbers(ListNode ln1, ListNode ln2) {

        ListNode tempLn1 = ln1;
        ListNode tempLn2 = ln2;

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int cache = 0;

        while (tempLn1 != null || tempLn2 != null) {
            int v1 = tempLn1 == null ? 0 : tempLn1.val;
            int v2 = tempLn2 == null ? 0 : tempLn2.val;

            int sum = v1 + v2 + cache;
            cache = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (tempLn1 != null) {
                tempLn1 = tempLn1.next;
            }
            if (tempLn2 != null) {
                tempLn2 = tempLn2.next;
            }
        }
        if (cache > 0) {
            curr.next = new ListNode(1);
        }

        return dummyHead.next;
    }


    /**
     * 1.两数之和
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <br>
     * <a href="https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/">官方题解</a>
     * 方法一：暴力法
     * 方法二：两遍哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution!");
    }
}
