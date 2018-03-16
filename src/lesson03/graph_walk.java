package lesson03;

import java.util.Scanner;

public class graph_walk {
    static int[][] matrix = {
            //   1  2  3  4  5  6
            {0, 0, 0, 0, 1, 0},//1
            {0, 0, 0, 0, 1, 0},//2
            {0, 0, 0, 0, 1, 1},//3
            {0, 0, 0, 0, 1, 1},//4
            {1, 1, 1, 1, 0, 1},//5
            {0, 0, 1, 1, 1, 0} //6
    };

    // 5 is goal
    public static void main(String[] args) {
    }

    public static void print() {
        String abc = "abcdefghijklmn";
        System.out.print("  ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(abc.charAt(i) + " ");
        }
        int c;
        System.out.println();
        for (int x = 0; x < matrix.length; x++) {
            System.out.print(abc.charAt(x) + "|");
            for (int y = 0; y < matrix.length; y++) {
                c = matrix[x][y];
                if (c == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print(matrix[x][y] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}