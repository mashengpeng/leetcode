import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class meituan324{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int c = in.nextInt();
            LinkedList<Integer> list = new LinkedList<>();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                list.add(a[i]);
            }
            System.out.println(new meituan324().new solution().fun(n,m,c,list));

        }
    }

    class solution{
        public int fun(int n, int m, int c, List<Integer> list){
            int ans = 0;

            while(!list.isEmpty()){
                int back = 0;
                for (int i = 0; i < m; i++) {
                    int cur = i - back;
                    if(cur >= list.size()){
                        break;
                    }
                    list.set(cur, list.get(cur)-c);
                    if(list.get(cur) <= 0){
                        list.remove(cur);
                        back++;
                    }
                }
                ans++;
            }
            return ans;
        }
    }

}

