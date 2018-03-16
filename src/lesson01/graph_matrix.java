package lesson01;

import java.util.Scanner;

public class graph_matrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("type set of edges below");
        System.out.println("  '54'     means directed graph 5->4");
        System.out.println("type 'end' to end the input");
        String n = in.next();
        while (!n.equals("end")){
            int from = Character.getNumericValue(n.charAt(0));
            int to = Character.getNumericValue(n.charAt(1));
            pole[from][to] = 1;
            n = in.next();
        }
        vypis();
        for (int x = 0; x < pole.length; x++) {
            for (int y = 0; y < pole.length; y++) {
//                System.out.print(x+""+y+" ");
                if (pole[x][y] == 1 && pole[y][x] == 1){
                    if (x>y) { // we need to print this connection only ONCE!
                        System.out.println(x + "<-->" + y);
//                        pole[x][y] = 0;
                    }
                }
                else if (pole[x][y] == 1 && pole[y][x] == 0) {
                    System.out.println(x + "-->" + y);
                }
//                else if (pole[y][x] == 1 && pole[x][y] ==0) {
//                    System.out.println(y + "-->" + x);
//                }
            }
        }


    }
    static int[][] pole = new int[8][8];

    public static void vypis() {
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
                if(c==0){
                    System.out.print("_ ");
                }
                else{System.out.print(pole[x][y] + " ");}
            }
            System.out.println();
        }
        System.out.println();
    }
}
