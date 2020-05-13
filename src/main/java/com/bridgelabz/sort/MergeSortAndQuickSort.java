package com.bridgelabz.sort;

public class MergeSortAndQuickSort {
    int mergeSortArray[] = {50, 14, 33, 1, 32, 10, 50, 23, 41,19};
    int quickSortArray[] = {23, 45, 22, 47, 24, 53, 11, 122, 63};

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();
        Thread thread1 = new Thread(mergeSort);
        Thread thread2 = new Thread(quickSort);
        thread1.run();
        thread2.run();
    }
}
