package com.kee.basics.part1_sort.imple.insertsort;

import com.kee.basics.part1_sort.Sort;

public class InsertionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        insertSortV2(arr);
    }


    /**
     * 插入排序
     * 思路：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到响应位置插入。
     */
    public void insertSort(int[] array) {
        print(array);
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j, j - 1);
            }
            print(array);
        }
        print(array);
    }

    /**
     * 修改算法，用临时变量记录标记项(待排序的项)，从后向前遍历有序序列，遍历到的有序队列元素，向后移动，腾出插入位置，找到应该插入的位置后，把待排序项进行插入，去掉swap方法
     *
     */
    public void insertSortV2(int[] array) {
        print(array);
        for (int i = 1; i < array.length; i++) {
            int tartNum = array[i];
            int j = i;
            while (j > 0 && tartNum < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = tartNum;
        }
        print(array);
    }
}
