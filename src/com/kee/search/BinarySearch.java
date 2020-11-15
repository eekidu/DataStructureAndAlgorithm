package com.kee.search;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * 二分查找：
 * 1、有序、数组（利用数组随机存取特性，角标定位）
 * 2、查找的时间复杂度O（logN）
 *
 * @author kuan
 */
public class BinarySearch {

    public static void main(String[] args) {
        char[] chars=new char[]{55,51,50,71};
        System.out.println(java.lang.String.valueOf(chars));


//        int[] src = new int[]{39, 59};
//        int want = 39;
//
//
//        src = new int[2000];
//        for (int i = 0; i < src.length; i++) {
//            src[i] = i;
//        }
//        want = 1001;
//
//
//        int 二分查找 = 二分查找(src, want);
//        System.out.println(二分查找);
//
//        int i = binarySearchRecursive(src, want, 0, src.length - 1);
//        System.out.println(i);
    }

    public static int 二分查找(int[] src, int target) {
        int startIndex = 0;
        int endIndex = src.length - 1;
        while (startIndex <= endIndex) {
            int index = (startIndex + endIndex) / 2;
            if (target == src[index]) {
                return index;
            } else if (target < src[index]) {
                endIndex = index-1;
            } else if (target > src[index]) {
                startIndex = index + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] src, int want, int startIndex, int endIndex) {
        int midIndex = (startIndex + endIndex) / 2;
        if (want < src[midIndex]) {
            return binarySearchRecursive(src, want, startIndex, midIndex-1);
        } else if (want > src[startIndex]) {
            return binarySearchRecursive(src, want, midIndex + 1, endIndex);
        } else {
            return midIndex;
        }
    }
}
