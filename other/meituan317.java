import java.util.Scanner;

public class meituan317 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String a = in.next();
            String b = in.next();

            int cnt = 0;
            int i = 0;
            int ans = 0;
            while(cnt < b.length()){
                if(a.charAt(i) == b.charAt(cnt)){
                    cnt++;
                    ans--;
                }

                if(i == a.length()-1){
                    i = 0;
                }else{
                    i++;
                }
                ans++;

            }
            System.out.println(ans);
        }
    }
}
