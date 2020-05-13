package com.bridgelabz.sort;

import java.util.Arrays;

public class MergeSort extends MergeSortAndQuickSort implements Runnable {
    void merge(int arr[], int beg, int mid, int end) {
        int left = mid - beg + 1;
        int right = end - mid;

        int LeftArray[] = new int[left];
        int RightArray[] = new int[right];

        for (int index = 0; index < left; ++index)
            LeftArray[index] = arr[beg + index];

        for (int index = 0; index < right; ++index)
            RightArray[index] = arr[mid + 1 + index];

        int index1 = 0, index2 = 0;
        int temp = beg;
        while (index1 < left && index2 < right) {
            if (LeftArray[index1] <= RightArray[index2]) {
                arr[temp] = LeftArray[index1];
                index1++;
            } else {
                arr[temp] = RightArray[index2];
                index2++;
            }
            temp++;
        }
        while (index1 < left) {
            arr[temp] = LeftArray[index1];
            index1++;
            temp++;
        }

        while (index2 < right) {
            arr[temp] = RightArray[index2];
            index2++;
            temp++;
        }
    }

    void sort(int arr[], int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            sort(arr, beg, mid);
            sort(arr, mid + 1, end);
            merge(arr, beg, mid, end);
        }
    }

    @Override
    public void run() {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(mergeSortArray,0,mergeSortArray.length - 1);
        System.out.println("Sorted array:"+Arrays.toString(mergeSortArray));
    }
}