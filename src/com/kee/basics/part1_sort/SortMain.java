package com.kee.basics.part1_sort;

import com.kee.basics.part1_sort.imple.insertsort.ShellSort;

/**
 * 使用对数器对排序的实现类进行检验，
 *
 * @author kee
 */
public class SortMain {

    public static void main(String[] args) {
        int a = 8 >> 1;
        System.out.println(a);


        DataChecker dataChecker = new DataChecker()
                .setDebug(true)
//                .setTargetArr(new int[]{3, 2, 1})
//                .setTargetArr(new int[]{9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2})
                .setTargetArr(new int[]{5, 4, 3, 2, 1,6})
                .setRunTimes(10)
                .setArrLength(100);

        Sort sort = null;
//        sort = new MergeSort();
//        sort = new SelectionSort();
//        sort = new BubbleSort();
//        sort = new InsertionSort();
//        sort = new QuickSort();
//        sort = new CountSort();
//        sort = new RadixSort();
        sort = new ShellSort();

        System.out.println("排序是否通过验证：" + dataChecker.check(sort));

    }

}
