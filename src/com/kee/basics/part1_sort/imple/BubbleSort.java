package com.kee.basics.part1_sort.imple;

import com.kee.basics.part1_sort.Sort;

public class BubbleSort implements Sort {
    @Override
    public void sort(int[] arr) {
        bubbleSortV3(arr);
    }

    /**
     * 冒泡排序
     * <a href="https://mp.weixin.qq.com/s/wO11PDZSM5pQ0DfbQjKRQA">讲解及其优化</a>
     */
    private void bubbleSort(int[] array) {
        print(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        print(array);
    }

    public void bubbleSortV2(int[] array) {
        print(array);
        for (int i = 0; i < array.length; i++) {
            boolean endIsSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    endIsSorted = false;
                }
            }
            if (endIsSorted) {
                break;
            }
            print(array);
        }
        print(array);
    }

    /**
     * 冒泡排序 with 两个优化点
     * 1.后面元素如果已经有序，则跳出排序
     * 2.界定无序区的边界，只对无序区进行排序
     */
    public void bubbleSortV3(int[] array) {
        print(array);
        //无序数列的边界，每次比较只需要比较到这里为止
        int sortBord = array.length - 1;


        for (int i = 0; i < array.length; i++) {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;
            //记录最后一次交换的位置
            int lastExchangeIndex = 0;

            for (int j = 0; j < sortBord; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                    //把无序的数列边界更新为最后一次变换的元素的位置
                    lastExchangeIndex = j + 1;
                }
            }
            sortBord = lastExchangeIndex;
            if (isSorted) {
                break;
            }
            print(array);
        }
        print(array);
    }


    /**
     * 鸡尾酒排序，双向冒泡排序
     * <a href="https://mp.weixin.qq.com/s/CoVZrvis6BnxBQgQrdc5kA"></a>
     */
    public void bubbleSortV4(int[] array) {

    }
}
