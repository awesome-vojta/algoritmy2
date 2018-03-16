package lesson05;

public class graph_pairing {
    static int[][] G = {
            //   0  1  2  3  4  5
           /*0*/{0, 1, 0, 1, 0, 0},
           /*1*/{1, 0, 1, 1, 1, 1},
           /*2*/{0, 1, 0, 0, 0, 1},
           /*3*/{1, 1, 0, 0, 1, 0},
           /*4*/{0, 1, 0, 1, 0, 1},
           /*5*/{0, 1, 1, 0, 1, 0}
    };
    public static void omit(int r, int c){
        for (int i = r+1; i < G.length; i++) {
            G[i][c]=0;
            G[c][i]=0;
        }
        G[r][c] = 1;
        G[r][c] = 1;
    }
    public static void main(String[] args) {
        for (int r = 0; r < G.length; r++) {
            for (int c = 0; c < G.length; c++) {
                if (G[r][c] == 1) {
                    omit(r, c);
                    break;
                }
            }
        }
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
                if(c==1000 || c == 0){
                    System.out.print("?? ");
                }
                else{System.out.print(pole[x][y] + " ");}
            }
            System.out.println();
        }
        System.out.println();
    }

}
