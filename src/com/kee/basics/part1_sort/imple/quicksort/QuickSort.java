package com.kee.basics.part1_sort.imple.quicksort;

import com.kee.basics.part1_sort.Sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 思路：分治法
 * <p>
 * 每次把数列分成两部分，选定一个基准元素，让其他比它大的元素移动到数列的一边，比它小的元素移动到另一边，从而把数列拆解成两部分
 * <p>
 * <p>
 * 核心：元素的移动有两种方法：
 * 选定轴后，元素的移动
 * 1.挖坑法
 * 2.指针交互法
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] arr) {
//        quickSort(arr, 0, arr.length - 1);
        quickSortV2(arr);
    }


    /**
     * 形式一：采用递归形式，调用核心方法
     *
     * @param arr
     * @param leftIndex
     * @param rightIndex
     */
    private void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
//        int zhouIndex = partitionV1(arr, leftIndex, rightIndex);
        int zhouIndex = partitionV2(arr, leftIndex, rightIndex);
        quickSort(arr, leftIndex, zhouIndex - 1);
        quickSort(arr, zhouIndex + 1, rightIndex);
    }

    /**
     * 形式二：栈形式
     * 代码中一层一层的方法调用，本身就是一个函数栈。
     * 每次进入一个新方法，新方法入栈；每次方法返回，就相当于出栈。
     *
     * @param arr
     */
    private void quickSortV2(int[] arr) {
        final String KEY_LEFTBOUND = "leftBound";
        final String KEY_RIGHTBOUND = "rightBound";

        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap();
        map.put(KEY_LEFTBOUND, 0);
        map.put(KEY_RIGHTBOUND, arr.length - 1);
        stack.push(map);
        while (!stack.isEmpty()) {
            Map<String, Integer> pop = stack.pop();
            int privotIndex = partitionV2(arr, pop.get(KEY_LEFTBOUND), pop.get(KEY_RIGHTBOUND));

            if (pop.get(KEY_LEFTBOUND) < privotIndex - 1) {
                Map<String, Integer> leftMap = new HashMap<>();
                leftMap.put(KEY_LEFTBOUND, pop.get(KEY_LEFTBOUND));
                leftMap.put(KEY_RIGHTBOUND, privotIndex - 1);
                stack.push(leftMap);
            }

            if (pop.get(KEY_RIGHTBOUND) > privotIndex + 1) {
                Map<String, Integer> rightMap = new HashMap<>();
                rightMap.put(KEY_LEFTBOUND, privotIndex + 1);
                rightMap.put(KEY_RIGHTBOUND, pop.get(KEY_RIGHTBOUND));
                stack.push(rightMap);
            }
        }
    }

    /**
     * 挖坑法
     *
     * @param arr
     * @param leftBound
     * @param rightBound
     * @return
     */
    private int partitionV1(int[] arr, int leftBound, int rightBound) {
        int left = leftBound;
        int right = rightBound;

        int zhou = arr[leftBound];
        int kengIndex = leftBound;


        while (left < right) {
            while (right > left) {
                if (arr[right] < zhou) {
                    arr[kengIndex] = arr[right];
                    kengIndex = right;
                    left++;
                    break;
                }
                right--;
            }
            while (left < right) {
                if (arr[left] > zhou) {
                    arr[kengIndex] = arr[left];
                    kengIndex = left;
                    right--;
                    break;
                }
                left++;
            }
        }
//        System.out.println(left + "  " + right);
        arr[kengIndex] = zhou;
        return kengIndex;
    }

    /**
     * 左右双指针
     * <p>
     * 1.选定轴
     * 2.右指针找比轴小的元素，并向左移动
     * 3.左指针找比轴大的元素，并向右移动
     * <p>
     * 如果左右指针不重合，则两个指针元素交互位置。重合，则为轴元素位置
     *
     * @param arr
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    private int partitionV2(int[] arr, int leftIndex, int rightIndex) {
        int left = leftIndex;
        int right = rightIndex;

        int privot = arr[left];
        while (left < right) {
            while (left < right && arr[right] > privot) {
                right--;
            }
            while (left < right && arr[left] <= privot) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, leftIndex, left);
        return left;
    }
}
