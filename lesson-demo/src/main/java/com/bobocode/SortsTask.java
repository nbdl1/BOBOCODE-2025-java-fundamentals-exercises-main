package com.bobocode;

import java.util.Arrays;
import java.util.Date;

/*
* ●	Implement the Insertion Sort
●	Implement the Bubble Sort
●	Implement the Merge Sort
●	Measure the time for various datasets and build a graphic for Time Complexity on the same chart (so you can visually compare three algorithms).

* */
public class SortsTask {
    public static final int ARRAY_SIZE = 10;
    private static final int[] toSort = new int[ARRAY_SIZE];

    public static void main(String[] args) {
        fulfillArrayWithRandomIntegers();
        System.out.println(Arrays.toString(toSort));
        long start = new Date().getTime();
        int[] insertionSortedArray = insertionSort(toSort);
        long endOfInsertionSorting = new Date().getTime();
        long durationOfInsertionSorting = endOfInsertionSorting - start;
        System.out.println("insertionSortedArray = " + Arrays.toString(insertionSortedArray));
        System.out.println("durationOfInsertionSorting = " + durationOfInsertionSorting);

        start = new Date().getTime();
        int[] bubbleSortedArray = bubbleSort(toSort);
        long endOfBubbleSorting = new Date().getTime();
        long durationOfBubbleSorting = endOfBubbleSorting - start;
        System.out.println("bubbleSortedArray = " + Arrays.toString(bubbleSortedArray));
        System.out.println("durationOfBubbleSorting = " + durationOfBubbleSorting);

        start = new Date().getTime();
        int[] mergeSortedArray = mergeSort(toSort);
        long endOfmergeSorting = new Date().getTime();
        long durationOfmergeSorting = endOfmergeSorting - start;
        System.out.println("mergeSortedArray = " + Arrays.toString(mergeSortedArray));
        System.out.println("durationOfmergeSorting = " + durationOfmergeSorting);
    }


    private static int[] insertionSort(int[] arrayTosort) {
        int[] sortedArray = Arrays.copyOf(arrayTosort, arrayTosort.length);
        for (int i = 1; i < sortedArray.length; i++) {
            compareToTheLeftAndSwap(sortedArray, i);
        }
        return sortedArray;
    }

    private static void compareToTheLeftAndSwap(int[] arrayToCheck, int indexToCheck) {
        if (arrayToCheck[indexToCheck] < arrayToCheck[indexToCheck - 1]) {
            int temp = arrayToCheck[indexToCheck - 1];
            arrayToCheck[indexToCheck - 1] = arrayToCheck[indexToCheck];
            arrayToCheck[indexToCheck] = temp;
            if (indexToCheck > 1) {
                compareToTheLeftAndSwap(arrayToCheck, indexToCheck - 1);
            }
        }
    }

    private static int[] bubbleSort(int[] arrayTosort) {
        int[] sortedArray = Arrays.copyOf(arrayTosort, arrayTosort.length);
        boolean swaped = true;
        while (swaped) {
            swaped = false;
            for (int i = 0; i < arrayTosort.length - 1; i++) {
                if (sortedArray[i] > sortedArray[i + 1]) {
                    swaped = true;
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                }
            }
        }
        return sortedArray;
    }

    private static int[] mergeSort(int[] arrayTosort) {
        int[] sortedArray = Arrays.copyOf(arrayTosort, arrayTosort.length);

        //todo implement merging algorithm

        return sortedArray;
    }

    private static void fulfillArrayWithRandomIntegers() {
        for (int i = 0; i < toSort.length; i++) {
            toSort[i] = (int) (Math.random() * ARRAY_SIZE);
        }
    }
}
