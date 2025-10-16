package com.bobocode;


/*
*Given an array of strings of unspecified length, write a function that will print its contents in 5 COLUMNS. The minimum distance between COLUMNS is 4 spaces.

Please take a look at the following example. Assume the array is called "inputTable" and is passed into the function.

Input:
String[] inputTable = new String[]{"1", "2", "3", "x", "5", "6", "a", "porosiatko", "c", "10", "11", "12", "13", "14", "15", "16"};

Output: (this should be printed to the console)

1     2     3             x     5
6     a     porosiatko    c     10
11    12    13            14    15
16

*
*
*
* */
public class PrintFormattedTableTask {

    public static final String[] inputTable = new String[]{"1", "2", "3", "x", "5", "6", "a",
            "porosiatko", "c", "10", "11", "12", "13", "14", "15", "16"};
    public static final int COLUMNS = 5;
    public static final int MIN_CELL_PADDING = 4;
    public static final int[] MAX_CELL_WIDTHS = new int[COLUMNS];

    public static void main(String[] args) {
        printFormattedTable();
    }

    public static void printFormattedTable() {


        getMaxColumnWidths();
        for (int inputElementIndex = 0; inputElementIndex < inputTable.length; inputElementIndex++) {
            printElement(inputTable[inputElementIndex], inputElementIndex, getElementColumn(inputElementIndex));
        }
    }

    private static void printElement(String element, int elementPosition, int column) {
        System.out.print(element);
        printSpaces(getRequiredSpacesForCell(element, MAX_CELL_WIDTHS[column]));
        boolean ifCurrentElementIsLastColumnElement = ((elementPosition + 1) % COLUMNS) == 0;
        if (ifCurrentElementIsLastColumnElement) {
            System.out.print("\n");
        }
    }

    private static int getRequiredSpacesForCell(String cellString, int maxCellStringWidthForCurrentColumn) {
        return maxCellStringWidthForCurrentColumn - cellString.length() + MIN_CELL_PADDING;
    }

    private static void printSpaces(int needSpaces) {
        for (int space = 0; space < needSpaces; space++) {
            System.out.print(" ");
        }
    }

    private static void getMaxColumnWidths() {
        for (int column = 0; column < COLUMNS; column++) {
            int maxColumnWidth = 0;
            for (int elementPosition = column; elementPosition < inputTable.length; elementPosition = elementPosition + COLUMNS) {
                maxColumnWidth = Math.max(maxColumnWidth, inputTable[elementPosition].length());
            }
            MAX_CELL_WIDTHS[column] = maxColumnWidth;
        }
    }

    private static int getElementColumn(int elementPosition) {
        return (elementPosition) % COLUMNS;
    }
}
