package com.bridgelabz.sort;

import java.util.Arrays;

public class QuickSort extends MergeSortAndQuickSort implements Runnable {

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        while (low <= high) {
            while (arr[low] < pivot) {
                low++;
            }
            while (arr[high] > pivot) {
                high--;
            }
            if (low <= high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }

    public void quickSortRecursion(int[] arr, int low, int high) {
        int pi = partition(arr, low, high);
        if (low < pi - 1) {
            quickSortRecursion(arr, low, pi - 1);
        }
        if (pi < high) {
            quickSortRecursion(arr, pi, high);
        }
    }

    @Override
    public void run() {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSortRecursion(quickSortArray,0,quickSortArray.length-1);
        System.out.println("Sorted Array :"+ Arrays.toString(quickSortArray));
    }
}
