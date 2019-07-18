package com.kee.leetcode.ploblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数
 */
public class Num169 {

    /**
     * 暴力法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (num == elem) {
                    count++;
                }
            }
            if (count > majorityCount) {
                return num;
            }
        }
        return -1;
    }


    /**
     * 方法二：哈希表
     *
     * @param nums
     * @return
     */
    public int majorityElementV2(int[] nums) {
        int majorityCount = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Set<Integer> set = map.keySet();
        for (Integer integer : set) {
            if (map.get(integer) > majorityCount) {
                return integer;
            }
        }
        return -1;
    }


    /**
     * 方法三：排序
     *
     * @param nums
     * @return
     */
    public int majorityElementV3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * 方法六：Boyer-Moore 投票算法
     * <p>
     * 如果我们把众数记为 +1+1 ，把其他数记为 -1−1 ，将它们全部加起来，显然和大于 0 ，从结果本身我们可以看出众数比其他数多。
     *
     * @param nums
     * @return
     */
    public int majorityElementV4(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


    public static void main(String[] args) {
        Num169 num169 = new Num169();
        int asnwer = num169.majorityElementV4(new int[]{8, 7, 6, 3, 3, 3, 3});
        System.out.println(asnwer);
    }
}
