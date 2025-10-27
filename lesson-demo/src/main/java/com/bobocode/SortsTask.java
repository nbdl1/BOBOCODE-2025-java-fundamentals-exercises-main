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
    private static final int ARRAY_SIZE = 100_000;
    private static final int[] toSort = new int[ARRAY_SIZE];

    public static void main(String[] args) {
        fulfillArrayWithRandomIntegers();

        long start = new Date().getTime();
        int[] insertionSortedArray = insertionSort(toSort);
        long endOfInsertionSorting = new Date().getTime();
        long durationOfInsertionSorting = endOfInsertionSorting - start;

        System.out.println("durationOfInsertionSorting = " + durationOfInsertionSorting);

        start = new Date().getTime();
        int[] bubbleSortedArray = bubbleSort(toSort);
        long endOfBubbleSorting = new Date().getTime();
        long durationOfBubbleSorting = endOfBubbleSorting - start;
        System.out.println("durationOfBubbleSorting = " + durationOfBubbleSorting);

        start = new Date().getTime();
        int[] mergeSortedArray = mergeSort(toSort);
        long endOfmergeSorting = new Date().getTime();
        long durationOfmergeSorting = endOfmergeSorting - start;
        System.out.println("durationOfmergeSorting = " + durationOfmergeSorting);

        start = new Date().getTime();
        int[] quickSortedArray = quickSort(toSort);
        long endOfQuickSorting = new Date().getTime();
        long durationOfQuickSorting = endOfQuickSorting - start;
        System.out.println("durationOfQuickSorting = " + durationOfQuickSorting);

        // System.out.println("Original Array: "+Arrays.toString(toSort));
       // System.out.println("quickSortedArray = " + Arrays.toString(quickSortedArray));
        //System.out.println("insertionSortedArray = " + Arrays.toString(insertionSortedArray));
        //System.out.println("mergeSortedArray = " + Arrays.toString(mergeSortedArray));
        //System.out.println("bubbleSortedArray = " + Arrays.toString(bubbleSortedArray));
    }


    private static int[] insertionSort(int[] arrayTosort) {
        int[] sortedArray = Arrays.copyOf(arrayTosort, arrayTosort.length);
        for (int rightElementIndex = 1; rightElementIndex < sortedArray.length; rightElementIndex++) {
            compareAndSwap(sortedArray, rightElementIndex);
        }
        return sortedArray;
    }

    private static void compareAndSwap(int[] arrayToCheck, int rightElementIndex) {
        int currentElement = arrayToCheck[rightElementIndex];
        int leftElementIndex = rightElementIndex - 1;
        while (leftElementIndex >= 0 && arrayToCheck[leftElementIndex] > currentElement) {
            arrayToCheck[leftElementIndex + 1] = arrayToCheck[leftElementIndex];
            leftElementIndex--;
        }
        arrayToCheck[leftElementIndex + 1] = currentElement;
    }

    private static int[] bubbleSort(int[] arrayTosort) {
        int[] sortedArray = Arrays.copyOf(arrayTosort, arrayTosort.length);
        boolean swaped = true;
        while (swaped) {
            swaped = false;
            for (int leftElementIndex = 0; leftElementIndex < arrayTosort.length - 1; leftElementIndex++) {
                if (sortedArray[leftElementIndex] > sortedArray[leftElementIndex + 1]) {
                    swaped = true;
                    int temp = sortedArray[leftElementIndex];
                    sortedArray[leftElementIndex] = sortedArray[leftElementIndex + 1];
                    sortedArray[leftElementIndex + 1] = temp;
                }
            }
        }
        return sortedArray;
    }

    private static int[] mergeSort(int[] arrayTosort) {
        int[] sortedArray = Arrays.copyOf(arrayTosort, arrayTosort.length);

        sortedArray = Arrays.copyOf(divide(sortedArray), sortedArray.length);

        return sortedArray;
    }

    private static int[] divide(int[] arrayTosort) {
        if (arrayTosort.length == 1) {
            return arrayTosort;
        }
        int centerOfArray = arrayTosort.length / 2;
        int[] leftArray = Arrays.copyOfRange(arrayTosort, 0, centerOfArray);
        int[] rightArray = Arrays.copyOfRange(arrayTosort, centerOfArray, arrayTosort.length);
        leftArray = divide(leftArray);
        rightArray = divide(rightArray);

        return sortAndMergeLeftAndRight(leftArray, rightArray);

    }

    private static int[] sortAndMergeLeftAndRight(int[] leftArray, int[] rightArray) {
        int[] mergedArray = new int[leftArray.length + rightArray.length];
        int leftArrayElementIndex = 0, rightArrayElementIndex = 0, mergedArrayElementIndex = 0;

        while (leftArrayElementIndex < leftArray.length && rightArrayElementIndex < rightArray.length) {
            if (leftArray[leftArrayElementIndex] <= rightArray[rightArrayElementIndex]) {
                mergedArray[mergedArrayElementIndex++] = leftArray[leftArrayElementIndex++];
            } else {
                mergedArray[mergedArrayElementIndex++] = rightArray[rightArrayElementIndex++];
            }
        }

        while (leftArrayElementIndex < leftArray.length)
            mergedArray[mergedArrayElementIndex++] = leftArray[leftArrayElementIndex++];
        while (rightArrayElementIndex < rightArray.length)
            mergedArray[mergedArrayElementIndex++] = rightArray[rightArrayElementIndex++];

        return mergedArray;
    }

    private static int[] quickSort(int[] arrayTosort) {
        int[] sortedArray = Arrays.copyOf(arrayTosort, arrayTosort.length);
        sortedArray = choosePivotAndSort(sortedArray);
        return sortedArray;

    }

    private static int[] choosePivotAndSort(int[] arrayTosort) {
        int pivotIndex = 0;
        int originalArrayLength = arrayTosort.length;
        int pivotElement = arrayTosort[pivotIndex];
        int[] leftArray = new int[originalArrayLength - 1];
        int[] rightArray = new int[originalArrayLength - 1];
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        for (int itemIndex = 1; itemIndex < originalArrayLength; itemIndex++) {
            if (arrayTosort[itemIndex] < pivotElement) {
                leftArray[leftArrayIndex++] = arrayTosort[itemIndex];
            } else {
                rightArray[rightArrayIndex++] = arrayTosort[itemIndex];
            }
        }

        leftArray = Arrays.copyOfRange(leftArray, 0, leftArrayIndex);
        rightArray = Arrays.copyOfRange(rightArray, 0, rightArrayIndex);

        if (leftArray.length > 1) {
            leftArray = choosePivotAndSort(leftArray);
        }
        if (rightArray.length > 1) {
            rightArray = choosePivotAndSort(rightArray);
        }
        int[] resultArray = new int[originalArrayLength];

        int resultArrayIndex = 0;
        for (int element : leftArray) {
            resultArray[resultArrayIndex++] = element;
        }
        resultArray[resultArrayIndex++] = pivotElement;
        for (int element : rightArray) {
            resultArray[resultArrayIndex++] = element;
        }

        return resultArray;
    }


    private static void fulfillArrayWithRandomIntegers() {
        for (int elementIndex = 0; elementIndex < toSort.length; elementIndex++) {
            toSort[elementIndex] = (int) (Math.random() * ARRAY_SIZE);
        }
    }
}
