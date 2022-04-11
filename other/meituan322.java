import java.util.Scanner;

public class meituan322 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            int x = 0;
            int y = 1;
            for (int i = 0; i < m - 2; i++) {
                int cur = a[x][y] - 1;
                x = y;
                y = cur;
            }
            System.out.println(y+1);
        }
    }
}
//3 7
//0 3 2
//3 0 3
//2 1 0