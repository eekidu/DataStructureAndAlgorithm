package com.kee.basics.part1_sort.imple;

import com.kee.basics.part1_sort.Sort;

/**
 * 基数排序
 * 多关键字排序，例如int[]排序，一次多个位、十位直至最高位，每一位就是一种关键字，依次排序，利用稳定性特性，最终达到排序结果
 * 应用：字符串排序
 * <p>
 * 计数排序的进阶版本
 */
public class RadixSort implements Sort {
    @Override
    public void sort(int[] arr) {
        int max = findMax(arr);
        int length = Integer.valueOf(max).toString().length();
        for (int i = 0; i < length; i++) {
            sortR(arr, i);
        }

    }

    private int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * @param arr
     * @param positionInNum 0:个位，1：十位，2：百位，依次类推
     */
    private void sortR(int[] arr, int positionInNum) {
        int division = (int) Math.pow(10, positionInNum);
        /*
         * 取值的范围0-9,十个数字
         */
        int[] count = new int[10];

        /*
         * 计数器，统计每个值出现的次数
         */
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] / division % 10]++;
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
        for (int i = arr.length - 1; i >= 0; i--) {
            resArr[--count[arr[i] / division % 10]] = arr[i];
        }

        /*
         * 排好序的数组回写到源数组
         */
        System.arraycopy(resArr, 0, arr, 0, arr.length);
    }
}
