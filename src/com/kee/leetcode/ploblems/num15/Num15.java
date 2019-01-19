package com.kee.leetcode.ploblems.num15;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class Num15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new LinkedList<>();
        int left = 0;
        int mid = left + 1;
        int right = mid + 1;
        Set<String> keySet = new HashSet<>();
        while (left < nums.length - 2) {
            while (mid < nums.length - 1) {
                while (right < nums.length) {
                    int numSum = nums[left] + nums[mid] + nums[right];
//                    System.out.println(numSum);
                    if (numSum == 0) {
                        int[] key = {nums[left], nums[mid], nums[right]};
                        Arrays.sort(key);
                        String setKey = key[0] + "_" + key[1] + "_" + key[2];
                        if (!keySet.contains(setKey)) {
                            keySet.add(setKey);
                            List<Integer> item = new ArrayList<>();
                            for (int i : key) {
                                item.add(i);
                            }
                            resultList.add(item);
                        }
                    }
                    right++;
                }
                mid++;
                right = mid + 1;

            }

            left++;
            mid = left + 1;
            right = mid + 1;
        }
        return resultList;
    }

    public static void main(String[] args) {

    }
}
