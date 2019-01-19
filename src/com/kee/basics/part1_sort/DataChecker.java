package com.kee.basics.part1_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 对数器:用于检查排序算法是否正确。
 *
 * @author kee
 * @date 2015/05/18
 */
public class DataChecker {
    private static List<int[]> testCases;

    static {
        testCases = new ArrayList<>();
        testCases.add(new int[]{0});
        testCases.add(new int[]{1});
        testCases.add(new int[]{1, 2});
        testCases.add(new int[]{2, 1});
        testCases.add(new int[]{1, 1, 2});
        testCases.add(new int[]{1, 2, 2});
        testCases.add(new int[]{2, 2, 1});
        testCases.add(new int[]{2, 1, 2});
        testCases.add(new int[]{1, 2, 3, 4, 5});
        testCases.add(new int[]{5, 4, 3, 2, 1});
    }


    private boolean isDebug = true;
    private int runTimes = 1;
    private int arrLength = 5;
    private int[] targetArr;


    public boolean check(Sort sort) {
        if (targetArr != null) {
            return itemCheck(sort, targetArr);
        }

        for (int k = 0; k < runTimes; k++) {
            int[] datas = targetArr == null ? generateArr(arrLength) : targetArr;
            if (!itemCheck(sort, datas)) {
                return false;
            }
        }
        for (int[] testCose : testCases) {
            if (!itemCheck(sort, testCose)) {
                return false;
            }
        }

        return true;
    }

    private boolean itemCheck(Sort sort, int[] datas) {
        int[] shadowData = new int[datas.length];
        if (isDebug) {
            System.out.print("排序前：");
            sort.print(datas);
        }

        System.arraycopy(datas, 0, shadowData, 0, datas.length);
        sort.sort(datas);
        Arrays.sort(shadowData);

        if (isDebug) {
            System.out.print("排序后：");
            sort.print(datas);
        }
        for (int i = 0; i < datas.length; i++) {
            if (datas[i] != shadowData[i]) {
                return false;
            }
        }
        if (isDebug) {
            System.out.println();
        }
        return true;
    }


    private int[] generateArr(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size + 10);
        }
        return arr;
    }

    public DataChecker setDebug(boolean debug) {
        isDebug = debug;
        return this;
    }

    public DataChecker setRunTimes(int runTimes) {
        this.runTimes = runTimes;
        return this;
    }

    public DataChecker setArrLength(int arrLength) {
        this.arrLength = arrLength;
        return this;
    }

    public DataChecker setTargetArr(int[] targetArr) {
        this.targetArr = targetArr;
        return this;
    }
}
