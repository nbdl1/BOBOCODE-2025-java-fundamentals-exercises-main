package com.bobocode;


/*
*Given an array of strings of unspecified length, write a function that will print its contents in 5 columns. The minimum distance between columns is 4 spaces.

Please take a look at the following example. Assume the array is called "input" and is passed into the function.

Input:
String[] input = new String[]{"1", "2", "3", "x", "5", "6", "a", "porosiatko", "c", "10", "11", "12", "13", "14", "15", "16"};

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

    public static void main(String[] args) {
        printFormattedTable();
    }


    public static final String[] input = new String[]{"1", "2", "3", "x", "5", "6", "a",
            "porosiatko", "c", "10", "11", "12", "13", "14", "15", "16"};
    public static final int columns = 5;
    public static final int minCellPadding = 4;
    public static void printFormattedTable() {


       for(int i = 0; i < input.length; i++) {
           printElement(input[i], i, getElementColumn(i));
       }
    }
    private static void printElement(String element,int elementPosition, int column){
        System.out.print(element);
        printSpaces(
                getRequiredSpacesForCell(
                        element,
                        getMaxCellWidthForCurrentColumn(elementPosition)
                )
        );
        if(elementPosition>0&&((elementPosition+1)%columns)==0){
            System.out.print("\n");
        };
    }
    private static int getRequiredSpacesForCell(String cellString, int maxCellStringWidthForCurrentColumn) {
        return maxCellStringWidthForCurrentColumn - cellString.length()+minCellPadding;
    }
    private static void printSpaces(int needSpaces){
        for(int j = 0; j <= needSpaces; j++){
            System.out.print("\s");
        }
    }

    private static int getMaxCellWidthForCurrentColumn(int elementPosition) {
        int maxCellWidthForCurrentColumn = 0;
        for (int i = elementPosition%columns; i < input.length; i=i+columns) {
            maxCellWidthForCurrentColumn = Math.max(maxCellWidthForCurrentColumn, input[i].length());
        }
        return maxCellWidthForCurrentColumn;
    }
    private static int getElementColumn(int elementPosition) {
        return (elementPosition)%columns;
       }
}
