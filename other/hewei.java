import java.util.*;

public class hewei {
}
class One{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.next();
            boolean valid = true;
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '('){
                    stack.addLast(-1);
                    continue;
                }
                if(s.charAt(i) == '['){
                    stack.addLast(-2);
                    continue;
                }

                if(s.charAt(i) == ')'){
                    int cur = 0;
                    while(!stack.isEmpty() && stack.getLast() != -1 && stack.getLast() != -2){
                        cur += stack.pollLast();
                    }

                    if(stack.isEmpty() || stack.getLast() == -2){
                        System.out.println(-1);
                        valid = false;
                        break;
                    }

                    stack.pollLast();
                    if(cur != 0){
                        stack.addLast(cur * 2);
                    }else{
                        stack.addLast(1);
                    }
                    continue;
                }

                if(s.charAt(i) == ']'){
                    int cur = 0;
                    while(!stack.isEmpty() && stack.getLast() != -1 && stack.getLast() != -2){
                        cur += stack.pollLast();
                    }

                    if(stack.isEmpty() || stack.getLast() == -1){
                        System.out.println(-1);
                        valid = false;
                        break;
                    }

                    stack.pollLast();
                    if(cur != 0){
                        stack.addLast(cur + 1);
                    }else{
                        stack.addLast(1);
                    }
                    continue;
                }
            }
            if(!valid){
                continue;
            }
            int ans = 0;
            while(!stack.isEmpty()){
                if(stack.getLast() == -1 || stack.getLast() == -2){
                    System.out.println(-1);
                    valid = false;
                    break;
                }
                ans += stack.pollLast();
            }
            if(!valid){
                continue;
            }
            System.out.println(ans);
        }
    }
}

class Two{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] nums = new int[n];
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt() - 1;
            }
            int ans = 0;

            LinkedList<Integer> list = new LinkedList<>();
            ArrayList<Integer> tmp = new ArrayList<>();
            list.addLast(0);
            visited[0] = true;

            a:while(!list.isEmpty() || !tmp.isEmpty()){

                int size = list.size();
                for (int i = 0; i < tmp.size(); i++) {
                    if(!visited[tmp.get(i)]){
                        list.addLast(tmp.get(i));
                        visited[tmp.get(i)] = true;
                    }
                }
                tmp.clear();

                for (int i = 0; i < size; i++) {
                    int cur = list.pollFirst();

                    System.out.println(cur);
                    if(cur == n-1){
                        System.out.println("zhongdiancishu:" + ans);
                        break a;
                    }
                    visited[cur] = true;
                    int to = nums[cur];
                    if(!visited[to]){
                        list.addLast(to);
                        visited[to] = true;
                    }
                    if(to - 1 >= 0 && !visited[to-1]){
                        tmp.add(to-1);
                    }
                    if(to + 1 < n && !visited[to+1]){
                        tmp.add(to+1);
                    }
                }
                System.out.println("------------");
                if(size != 0){
                    ans++;
                }
            }
        }
    }
}

class Three{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            int money = in.nextInt();
            Arrays.sort(nums);

            int cnt = 0;
            int curMoney = 0;
            for (int i = 0; i < n; i++) {
                if(curMoney + nums[i] <= money){
                    curMoney += nums[i];
                    cnt++;
                }else{
                    break;
                }
            }
            System.out.println(cnt);

            int[] dp = new int[money+1];
            int ans = 0;
            Arrays.fill(dp, 0);
            dp[0] = 1;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 1; j <= money; j++) {
                    if(j - nums[i] >= 0){
                        dp[j] += dp[j - nums[i]];
                    }
                }
            }
            for (int i = curMoney; i <= money; i++) {
                ans += dp[i];
            }
            System.out.println(ans);



        }
    }
}

