package com.kee.basics.part1_sort;

import java.util.Arrays;

/**
 *
 */
public interface Sort {

    void sort(int[] arr);

    /**
     * 打印
     *
     * @param arr
     */
    default void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr
     * @param index1
     * @param index2
     */
    default void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
