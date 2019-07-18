package com.kee.leetcode.ploblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num136 {
    public int singleNumber(int[] nums) {
        Set<Integer> cacheSet = new HashSet<>();
        for (int num : nums) {
            if (cacheSet.contains(num)) {
                cacheSet.remove(num);
            } else {
                cacheSet.add(num);
            }
        }
        return cacheSet.iterator().next();
    }


    /**
     * 数学：2∗(a+b+c)−(a+a+b+b+c)=c
     *
     * @param nums
     * @return
     */
    public int singleNumberV2(int[] nums) {
        Set<Integer> singleCache = new HashSet<>();
        Arrays.stream(nums).forEach(singleCache::add);

        int sum = Arrays.stream(nums).sum();
        int sum2 = 0;

        for (Integer integer : singleCache) {
            sum2 += integer;
        }
        return sum2 * 2 - sum;
    }


    /**
     * 位操作
     * <p>
     * 如果我们对 0 和二进制位做 XOR（异或） 运算，得到的仍然是这个二进制位
     * 如果我们对相同的二进制位做 XOR 运算，返回的结果是 0
     * XOR 满足交换律和结合律
     * 所以我们只需要将所有的数进行 XOR 操作，得到那个唯一的数字。
     *
     * @param nums
     * @return
     */
    public int singleNumberV3(int[] nums) {
        int tempAsn = 0;
        for (int num : nums) {
            tempAsn ^= num;
        }
        return tempAsn;
    }


    public static void main(String[] args) {
        int[] src = {4, 1, 2, 1, 2};
        Num136 num136 = new Num136();
//        int ans = num136.singleNumber(src);
//        int ans = num136.singleNumberV2(src);
        int ans = num136.singleNumberV3(src);
        System.out.println(ans);

    }
}
