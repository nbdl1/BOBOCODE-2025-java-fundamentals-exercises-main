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
    private static final int ARRAY_SIZE = 10;
    private static final int[] toSort = new int[ARRAY_SIZE];

    public static void main(String[] args) {
        fulfillArrayWithRandomIntegers();
        //System.out.println(Arrays.toString(toSort));
        long start = new Date().getTime();
        int[] insertionSortedArray = insertionSort(toSort);
        long endOfInsertionSorting = new Date().getTime();
        long durationOfInsertionSorting = endOfInsertionSorting - start;
        //System.out.println("insertionSortedArray = " + Arrays.toString(insertionSortedArray));
        System.out.println("durationOfInsertionSorting = " + durationOfInsertionSorting);

        start = new Date().getTime();
        int[] bubbleSortedArray = bubbleSort(toSort);
        long endOfBubbleSorting = new Date().getTime();
        long durationOfBubbleSorting = endOfBubbleSorting - start;
        //System.out.println("bubbleSortedArray = " + Arrays.toString(bubbleSortedArray));
        System.out.println("durationOfBubbleSorting = " + durationOfBubbleSorting);

        start = new Date().getTime();
        int[] mergeSortedArray = mergeSort(toSort);
        long endOfmergeSorting = new Date().getTime();
        long durationOfmergeSorting = endOfmergeSorting - start;
        //System.out.println("mergeSortedArray = " + Arrays.toString(mergeSortedArray));
        System.out.println("durationOfmergeSorting = " + durationOfmergeSorting);
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
        while(leftElementIndex>=0&&arrayToCheck[leftElementIndex]>currentElement) {
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

        sortedArray = Arrays.copyOf(divideAndSort(sortedArray),sortedArray.length);

        //todo implement merging algorithm

        return sortedArray;
    }

    private static int[] divideAndSort(int[] arrayTosort) {
        if(arrayTosort.length==1){
            return arrayTosort;
        }
        int centerOfArray = arrayTosort.length / 2;
        int[] leftArray = Arrays.copyOfRange(arrayTosort, 0, centerOfArray);
        int[] rightArray = Arrays.copyOfRange(arrayTosort, centerOfArray, arrayTosort.length);
        leftArray = divideAndSort(leftArray);
        rightArray = divideAndSort(rightArray);

        return mergeLeftAndRight(leftArray,rightArray);

    }

    private static int[] mergeLeftAndRight(int[] leftArray, int[] rightArray) {
        int[] mergedArray = new int[leftArray.length + rightArray.length];
        int i = 0, j = 0, k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                mergedArray[k++] = leftArray[i++];
            } else {
                mergedArray[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) mergedArray[k++] = leftArray[i++];
        while (j < rightArray.length) mergedArray[k++] = rightArray[j++];


        return mergedArray;
    }



    private static void fulfillArrayWithRandomIntegers() {
        for (int elementIndex = 0; elementIndex < toSort.length; elementIndex++) {
            toSort[elementIndex] = (int) (Math.random() * ARRAY_SIZE);
        }
    }
}
