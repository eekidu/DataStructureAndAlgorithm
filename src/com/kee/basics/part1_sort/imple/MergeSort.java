package com.kee.basics.part1_sort.imple;

import com.kee.basics.part1_sort.Sort;

/**
 * 归并排序
 */
public class MergeSort implements Sort {



    @Override
    public void sort(int[] arr) {
        merge(arr, 0, arr.length);
    }

    /**
     * @param arr
     * @param leftBoarder
     * @param rightBoarder
     */
    private void merge(int[] arr, int leftBoarder, int rightBoarder) {
        if (leftBoarder + 1 == rightBoarder) return;
        int mid = leftBoarder + (rightBoarder - leftBoarder) / 2;

        merge(arr, leftBoarder, mid);
        merge(arr, mid, rightBoarder);

        sortMain(arr, leftBoarder, mid, rightBoarder);

    }


    /**
     * 写法可优化：
     * 1.三目运算
     * 2.++ 连写
     *
     * @param arr
     * @param leftP
     * @param rightP
     * @param rightBoard
     */
    private void sortMain(int[] arr, int leftP, int rightP, int rightBoard) {
        int recordLeftP = leftP;
        int mid = rightP;

        int[] tempArr = new int[rightBoard - leftP];
        int tempP = 0;

        while (leftP < mid && rightP < rightBoard) {
            if (arr[leftP] < arr[rightP]) {
                tempArr[tempP] = arr[leftP];
                leftP++;
                tempP++;
            } else {
                tempArr[tempP] = arr[rightP];
                rightP++;
                tempP++;
            }
        }
        while (leftP < mid) {
            tempArr[tempP] = arr[leftP];
            leftP++;
            tempP++;
        }
        while (rightP < rightBoard) {
            tempArr[tempP] = arr[rightP];
            rightP++;
            tempP++;
        }

        for (int i = 0; i < tempArr.length; i++) {
            arr[recordLeftP + i] = tempArr[i];
        }

    }
}
