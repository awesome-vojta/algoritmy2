package lesson06;

public class m_squares {
    static int magic[][]={{0,0,0},
                          {0,0,0},
                          {0,0,0}};

    public static void main(String[] args) {
        int n = magic.length * magic.length;
        int posList[][]=new int[n][2];
        int pos[] = {0,magic.length/2};
        int x; int y;
        for (int i = 1; i <= n; i++) {
            x=pos[0];y=pos[1];
            magic[x][y]=i;
            vypis(magic);

            if(i==n){ break; }
            posList[i][0]=x;
            posList[i][1]=y;

            pos=upLeft(pos);
            // If pos is full, take previous and go down by one
            if(magic[pos[0]][pos[1]]!=0){
                System.out.println("go down");
                pos=goDown(posList[i]);
            }
        }
    }

    public static int[] goDown(int pos[]){
        pos[0]++;
        return pos;
    }

    public static int[] upLeft(int pos[]){
        // todo ternary expression
        // If x is uppermost, set it to bottommost
        if(pos[0]==0){
            pos[0]=magic.length-1;
        }else{ // If x is some other num, set it up
            pos[0]--;
        }
        // If y is rightmost, set it to leftmost
        if(pos[1]==magic.length-1){
            pos[1]=0;
        }else {
            pos[1]++; // Set y right by one
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
                if(c==1000 || c == 0){
                    System.out.print("0 ");
                }
                else{System.out.print(pole[x][y] + " ");}
            }
            System.out.println();
        }
        System.out.println();
    }

}
