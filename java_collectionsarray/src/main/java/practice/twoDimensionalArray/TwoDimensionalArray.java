package practice.twoDimensionalArray;

import java.util.Arrays;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getTwoDimensionalArray(7)));
    }

    public static final char SYMBOL = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ SYMBOL по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
        char[][] array = new char[size][size];
        int i,j;

        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                array[i][j] = ' ';
            }
        }

        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                array[i][i] = SYMBOL;
                array[i][array[i].length - i - 1] = SYMBOL;
            }
        }
        return array;
    }
}
