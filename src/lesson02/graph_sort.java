package lesson02;

public class graph_sort {

    static String abc = "abcdefghijklmn";
    static int[][] matrix = {
            {0, 7, 3, 8, 2},
            {7, 0, 6, 0, 0},
            {3, 6, 0, 4, 5},
            {8, 0, 0, 0, 1},
            {2, 0, 5, 1, 0}
    };

    public static void main(String[] args) {
        int matrix_cells = matrix.length*matrix.length;
        int diagonal = matrix.length;
        String[] l = new String[(matrix_cells-diagonal)/2]; // number of unique vertices

        //Lets make another array full of valid and non-duplicate values (distances)
        int p=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(i<j) { // because we need just those cells that are above the diagonal > m[0][1],m[0][2],m[1][2],...
                    l[p] = String.valueOf(matrix[i][j])+ "-" + abc.charAt(i) + abc.charAt(j);
                    p++;
                    // Pushes a String in form of "4-cd"
                }
            }
        }

        // Bubble Sort
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l.length; j++) {
                if(l[i].charAt(0)<l[j].charAt(0)){ // since there are single digit numbers
                    String t = l[i];
                    l[i] = l[j];
                    l[j] = t;
                }
            }

        }

        // Print out the result
        for (int i = 0; i < l.length; i++) {
            System.out.println(l[i]);
        }
    }

    public static void print() {
        String abc = "abcdefghijklmn";
        System.out.print("  ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(abc.charAt(i)+" ");
        }
        int c;
        System.out.println();
        for (int x = 0; x < matrix.length; x++) {
            System.out.print(abc.charAt(x)+ "|");
            for (int y = 0; y < matrix.length; y++) {
                c = matrix[x][y];
                if(c==0){
                    System.out.print("0 ");
                }
                else{System.out.print(matrix[x][y] + " ");}
            }
            System.out.println();
        }
        System.out.println();
    }
}