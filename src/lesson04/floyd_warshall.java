package lesson04;
/**
 * Floyd Warshall algorithm is really simple
 *   Say we have two nodes, connected by an edge.
 *   Is there another node, through which I my path would be shorter?
 *   (G[i][j] > G[i][k] + G[k][j])
 */
public class floyd_warshall {
    static int[][] G = {
            //      0    1   2     3   4    5    6
           /*0*/{1000, 10, 1000, 50, 1000, 1000, 1000},
           /*1*/{1000, 1000, 15, 1000, 40, 1000, 1000},
           /*2*/{1000, 1000, 1000, 5, 20, 1000, 1000},
           /*3*/{1000, 1000, 1000, 1000, 0, 0, 0},
           /*4*/{1000, 1000, 1000, 1000, 1000, 20, 10},
           /*5*/{1000, 1000, 1000, 1000, 1000, 1000, 5},
           /*6*/{1000, 1000, 1000, 25, 1000, 1000, 1000}
    };
    static int[][] G_copy = {
            //      0    1   2     3   4    5    6
               /*0*/{1000, 10, 1000, 50, 1000, 1000, 1000},
               /*1*/{1000, 1000, 15, 1000, 40, 1000, 1000},
               /*2*/{1000, 1000, 1000, 5, 20, 1000, 1000},
               /*3*/{1000, 1000, 1000, 1000, 0, 0, 0},
               /*4*/{1000, 1000, 1000, 1000, 1000, 20, 10},
               /*5*/{1000, 1000, 1000, 1000, 1000, 1000, 5},
               /*6*/{1000, 1000, 1000, 25, 1000, 1000, 1000}
    };

    public static void main(String[] args) {
        String abc = "ABCDEFGHIKL";
        int n = G.length;
        // kij ij ik kj
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.println("comparing: " + abc.charAt(i) + abc.charAt(j) +
                            " and " + abc.charAt(i) + abc.charAt(k) +
                            " + " + abc.charAt(k) + abc.charAt(j));
                    if (G[i][j] > G[i][k] + G[k][j]){
                        G[i][j] = G[i][k] + G[k][j];
                        System.out.println(abc.charAt(i) + abc.charAt(k) +
                                " + " + abc.charAt(k) + abc.charAt(j) +
                                " is shorter than " + abc.charAt(i) + abc.charAt(j));
                    }
                }
            }
        }
        vypis(G_copy);
        vypis(G);

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