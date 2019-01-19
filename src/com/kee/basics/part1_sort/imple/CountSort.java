package com.kee.basics.part1_sort.imple;

import com.kee.basics.part1_sort.Sort;

/**
 * 计数排序适用于特定问题，样本很大，但是样本值的范围很小且可知
 *
 * @author kee
 */
public class CountSort implements Sort {
    @Override
    public void sort(int[] arr) {
        int[] ranges = dataRange(arr);
        int dataRange = ranges[1] - ranges[0];
        /*
         * 如果取值范围100-150，计数数组长度为51
         * 需要映射到数组0-50的范围
         */
        int map = ranges[0];

        /**
         * 取值的范围
         */
        int[] count = new int[dataRange + 1];

        /*
         * 计数器，统计每个值出现的次数
         */
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - map]++;
        }

        /*
         * 累加计数器，映射出每个值在结果数组中对应的位置角标上限
         */
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }


        /*
         * 源数组排序写入到结果数组中
         */
        int[] resArr = new int[arr.length];

//        for (int i = 0; i < arr.length; i++) {
        for (int i = arr.length - 1; i >= 0; i--) {
            resArr[--count[arr[i] - map]] = arr[i];
        }

        /*
         * 排好序的数组回写到源数组
         */
        System.arraycopy(resArr, 0, arr, 0, arr.length);

    }


    /**
     * 计数排序适用于特定问题，样本很大，但是样本值的范围很小且可知.
     * 该方法模拟范围可知。比如年龄，成绩等
     *
     * @param arr
     * @return
     */
    public int[] dataRange(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return new int[]{min, max};
    }
}
