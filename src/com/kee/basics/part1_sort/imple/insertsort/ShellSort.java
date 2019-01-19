package com.kee.basics.part1_sort.imple.insertsort;

import com.kee.basics.part1_sort.Sort;

/**
 * 希尔排序
 *
 * @author kee
 */
public class ShellSort implements Sort {

    /**
     * 增量序列一般规则：h = 3h + 1;
     *
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        int length = arr.length;
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }
        for (int i = h; i > 0; i = (i - 1) / 3) {
            System.out.println(arr.length + "  " + i);
            insertSort(arr, i);
        }

    }

    public void insertSort(int[] arr, int gaps) {
        for (int i = gaps; i < arr.length; i++) {
            for (int j = i; j >= gaps && arr[j - gaps] > arr[j]; j -= gaps) {
                swap(arr, j, j - gaps);
            }
        }
    }
}
