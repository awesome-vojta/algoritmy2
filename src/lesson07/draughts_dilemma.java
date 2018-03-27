package lesson07;

import java.util.ArrayList;

public class draughts_dilemma {
    // 1 - draught
    // 0 - empty
    // 8 - abandoned
    public static ArrayList<int[]> draughts = new ArrayList<int[]>(4);
//    static int[][] draughts = new int[4][2];
    public static int[][] matrix={{0,0,0,0},
                           {1,0,0,0},
                           {0,0,0,0},
                           {0,0,0,0}};

    public static void main(String[] args) {
        /**
         * A Draught is visually represented as "D"
         * Codewise it is 1
         * A Place targeted by Draught is visually represented as "x"
         * Codewise it is 8
         */

        int[] draughtPosition = {1,0};
        int x = draughtPosition[0]; int y = draughtPosition[1];
        matrix[x][y] = 1; // place Draught
        draughts.add(draughtPosition);

        crossOut(draughts.get(0));
        vypis(matrix);

        if(placeDraught()){
            crossOut(draughts.get(1));
            vypis(matrix);
        }
        if(placeDraught()){
            crossOut(draughts.get(2));
            vypis(matrix);
        }
        if(placeDraught()){
            crossOut(draughts.get(3));
            vypis(matrix);
        }
        // place draught
        // cross out positions that cannot be filled
        // place another draught

    }

    /**
     * Function to determine which fields caused invalid by Draught
     * @param d_pos denotes position of Draught
     */
    public static void crossOut(int[] d_pos) {
        int x = d_pos[0];int y = d_pos[1];
        // cross out by rows and columns
        vertical_horizontal(x,y);
        // cross out diagonally
        upRight(x,y);
        upLeft(x,y);
        downRight(x,y);
        downLeft(x,y);
        matrix[x][y]=1;
    }

    /**
     * Goes field by field, testing if a Draught can be placed there
     * @return Can a Draught be placed?
     */
    public static boolean placeDraught(){
        int[] pos = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j]!=8 && matrix[i][j]!=1){
                    matrix[i][j]=1;
                    pos[0]=i;pos[1]=j;
                    draughts.add(pos);
                    System.out.print(i);
                    System.out.println(j);
                    return true;
                }
            }
        }
        return false;
    }
    public static void vertical_horizontal(int x, int y){
        for (int i = 0; i < matrix.length; i++) {
            matrix[x][i] = 8;
            matrix[i][y] = 8;
        }
    }
    public static void upRight(int x, int y) {
        for (int i = 0; i < matrix.length; i++) {
            try {
                x--;
                y++;
                matrix[x][y] = 8;
            } catch (ArrayIndexOutOfBoundsException outBound) {
                break;
            }
        }
    }
    public static void upLeft(int x, int y) {
        //upLeft
        for (int i = 0; i < matrix.length; i++) {
            try {
                x--;
                y--;
                matrix[x][y] = 8;
            } catch (ArrayIndexOutOfBoundsException outBound) {
                break;
            }
        }
    }
    public static void downRight(int x, int y) {
        //downRight
        for (int i = 0; i < matrix.length; i++) {
            try {
                x++;
                y++;
                matrix[x][y] = 8;
            } catch (ArrayIndexOutOfBoundsException outBound) {
                break;
            }
        }
    }
    public static void downLeft(int x, int y){
        //downLeft
        for (int i = 0; i < matrix.length; i++) {
            try {
                x++; y--;
                matrix[x][y]=8;
            }catch (ArrayIndexOutOfBoundsException outBound) {
                break;
            }
        }
    }
    public static int[] findDraught(){
        int[] pos = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j]==1){
                    pos[0]=i;
                    pos[1]=j;
                    return pos;
                }
            }
        }
        return pos;
    }
    public static void vypis(int[][] pole) {
        System.out.print("  ");
        for (int i = 0; i < pole.length; i++) {
            System.out.print(i+" ");
        }
        int c;
        System.out.println();
        for (int x = 0; x < pole.length; x++) {
            System.out.print(x+ "|");
            for (int y = 0; y < pole.length; y++) {
                c = pole[x][y];
                if(c==1){
                    System.out.print("D ");
                } else if(c==8){
                    System.out.print("x ");
                }
                else{System.out.print(pole[x][y] + " ");}
            }
            System.out.println();
        }
        System.out.println();
    }

}
