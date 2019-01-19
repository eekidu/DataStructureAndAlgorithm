package com.kee.basics.part1_sort.imple;

import com.kee.basics.part1_sort.Sort;

public class SelectionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        selectionSortV2(arr);
    }

    /**
     * 选择排序
     * 思路：按数据角标循环，每次循环找出当前角标后面数中的最小值，并与当前位置交互
     * 时间复杂度：<a>O(n&sup2)</a>
     * <p>
     * 稳定性：不稳
     */
    private void selectionSort(int[] array) {
        print(array);
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
//            System.out.print("第 " + i + " 次循环，数组的内容： ");
            print(array);
        }
    }


    /**
     * 选择排序V2
     * 思路：按数据角标循环，每次循环找出当前角标后面数中的最小值和最大值，最小值并与当前位置交互，最大值与数组后面部分交互
     */
    private void selectionSortV2(int[] array) {
//        print(array);
        for (int i = 0; i < (array.length / 2 + 1); i++) {
            int targetMin = i;
            int minIndex = targetMin;
            int targetMax = array.length - i - 1;
            int maxIndex = targetMax;

            for (int j = targetMin; j <= targetMax; j++) {
                minIndex = array[j] < array[minIndex] ? j : minIndex;
                maxIndex = array[j] > array[maxIndex] ? j : maxIndex;
            }
//            System.out.println("targetMin=" + targetMin + " , minIndex =" + minIndex + ",targetMax= " + targetMax + "  ,maxIndex= " + maxIndex);

            //这里比较绕，需要处理四个参数中有相同值的情况下交互的顺序
            if (maxIndex == targetMin && minIndex == targetMax) {
                swap(array, maxIndex, minIndex);
            } else if (maxIndex == targetMin) {
                swap(array, targetMax, maxIndex);
                swap(array, targetMin, minIndex);
            } else if (minIndex == targetMax) {
                swap(array, targetMin, minIndex);
                swap(array, targetMax, maxIndex);
            } else {
                swap(array, targetMin, minIndex);
                swap(array, targetMax, maxIndex);
            }
//            System.out.print("第 " + (i + 1) + " 次循环，数组的内容： ");
//            print(array);
        }
    }
}
