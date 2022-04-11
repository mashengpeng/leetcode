import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class alibaba {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.next();
            long mod = (long) 1e9+7;
            int n = 2;

            for (int i = 0; i < s.length(); i++) {
                if(Character.isDigit(s.charAt(i))){
                    n = Math.max(n, s.charAt(i) - '0' + 1);
                }else{
                    n = Math.max(n, s.charAt(i) - 'A' + 11);
                }
            }

            List<Long> ans = new ArrayList<>();
            for (int i = n; i <= 16; i++) {
                long x = 0;
                for (int j = 0; j < s.length(); j++) {
                    long cur;
                    if(Character.isDigit(s.charAt(j))){
                        cur = s.charAt(j) - '0';
                    }else{
                        cur = s.charAt(j) - 'A' + 10;
                    }
                    x *= i;
                    x %= mod;
                    x += cur;

                }
                ans.add(x);
            }
            ans = ans.stream().distinct().sorted().collect(Collectors.toList());
            for (int i = 0; i < ans.size(); i++) {

                System.out.println(ans.get(i));
            }
        }

    }

    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();

            int[] cnt = new int[26];
            char[] cs = s.toCharArray();
            int num = 0;
            for (int i = 0; i < cs.length; i++) {
                if(++cnt[cs[i] - 'a'] == 1){
                    num++;
                }
            }
            int ans = 0;
            for (int i = 0; i < cs.length; i++) {
                int[] tmp = Arrays.copyOf(cnt, cnt.length);
                int cur = num;
//                for (int j = 0; j < i; j++) {
//                    if(--tmp[cs[j] - 'a'] == 0){
//                        cur--;
//                    }
//                }

                for (int j = i; j < cs.length; j++) {
                    if(--tmp[cs[j] - 'a'] == 0){
                        cur--;
                    }
                    if(cur >= k){
                        ans++;
                    }else{
                        break;
                    }
                }
            }
            System.out.println(ans);

        }

    }
}