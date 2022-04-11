//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            String s = in.next();
//
//            int a = 0, b = 0, c = 0;
//
//            for (int i = 0; i < s.length(); i++) {
//                if(s.charAt(i) == 'a'){
//                    a++;
//                }else if(s.charAt(i) == 'b'){
//                    b++;
//                }else if(s.charAt(i) == 'c'){
//                    c++;
//                }
//            }
//            a -= 1;
//            c /= 3;
//
//
//            System.out.println(Math.min(Math.min(a, b), c));
//        }
//    }
//}


//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            int n = in.nextInt();
//            int[] pos = new int[n];
//            for (int i = 0; i < n; i++) {
//                pos[i] = in.nextInt();
//            }
//
//            int ans = pos[n-1] - pos[0];
//            for (int i = 0; i < n; i++) {
//                int cur = (pos[n-1] - pos[i]) - (pos[i] - pos[0]);
//                cur = Math.abs(cur);
//                ans = Math.min(cur, ans);
//            }
//            System.out.println(ans);
//        }
//    }
//}


//import java.util.*;
//
//public class Main {
//
//
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            int n = in.nextInt();
//            int[] nums = new int[n];
//            for (int i = 0; i < n; i++) {
//                nums[i] = in.nextInt();
//            }
//
//            int ans = 0;
//            //LinkedList<Integer>[] lists = new LinkedList[7];
//            List<List<Integer>> lists = new LinkedList<>();
//            for (int i = 0; i < 7; i++) {
//                lists.add(new ArrayList<>());
//            }
//
//            for (int i = 0; i < n; i++) {
//                int pos;
//                if(nums[i] < 0){
//                    pos = 7 + nums[i] % 7;
//                }else{
//                    pos = nums[i] % 7;
//                }
//                lists.get(pos).add(nums[i] - pos);
//            }
//
//
//            for (int i = 0; i < lists.size(); i++) {
//                lists.get(i).sort((a,b) -> b - a);
//            }
//            List<Integer> list = lists.get(0);
//            for (int i = 0; i < list.size(); i++) {
//                if(list.get(i) <= 0){
//                    break;
//                }
//                ans += list.get(i);
//            }
//
//            int i, j;
//            List<Integer> a;
//            List<Integer> b;
//
////            1 6
////            2 5
////            3 4
//            i = 0;
//            j = 0;
//            a = lists.get(1);
//            b = lists.get(6);
//            while(i < a.size() && j < b.size()){
//                int cur = a.get(i++) + b.get(j++) + 7;
//                if(cur <= 0){
//                    break;
//                }
//                ans += cur;
//            }
//
//            i = 0;
//            j = 0;
//            a = lists.get(2);
//            b = lists.get(5);
//            while(i < a.size() && j < b.size()){
//                int cur = a.get(i++) + b.get(j++) + 7;
//                if(cur <= 0){
//                    break;
//                }
//                ans += cur;
//            }
//
//            i = 0;
//            j = 0;
//            a = lists.get(3);
//            b = lists.get(4);
//            while(i < a.size() && j < b.size()){
//                int cur = a.get(i++) + b.get(j++) + 7;
//                if(cur <= 0){
//                    break;
//                }
//                ans += cur;
//            }
//
//            System.out.println(ans);
//        }
//    }
//}

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            int n = in.nextInt();
//            int[] nums = new int[n];
//            for (int i = 0; i < n; i++) {
//                nums[i] = in.nextInt();
//            }
//            Arrays.sort(nums);
//            int ans = 0;
//
//            int i = 0, j = nums.length - 1;
//            int cnt = 1;
//            while(i <= j){
//                ans += cnt * nums[i++];
//                ans += cnt * nums[j--];
//                cnt++;
//            }
//
//            System.out.println(ans);
//        }
//    }
//}


import java.util.*;

public class meituan {

//3
//4 0
//2 2 1 3
//3 0
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            C[] cs = new C[n+1];
            for (int i = 0; i < n + 1; i++) {
                cs[i] = new C();
            }
            //Arrays.fill(cs, new C());
            for (int i = 1; i <= n; i++) {
                int time = in.nextInt();
                cs[i].setTime(time);
                int next = in.nextInt();
                if(next == 0){
                    continue;
                }
                cs[i].setNext(new ArrayList<>(next));
                for (int j = 0; j < next; j++) {
                    int id = in.nextInt();
                    cs[i].getNext().add(cs[id]);
                    cs[id].setPre(cs[i]);
                }
            }
            for (int i = 1; i < n; i++) {
                System.out.print(dfs(cs[i]) + " ");
            }
            System.out.print(dfs(cs[n]));

        }
    }

    public static int dfs(C root){
        if(root.getNext() == null || root.getNext().size() == 0){
            return root.getTime();
        }

        int max = 0;
        for (int i = 0; i < root.getNext().size(); i++) {
            max = Math.max(max, dfs(root.getNext().get(i)));
        }
        return root.getTime() + max;
    }
}

class C{
    int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    C pre;
    ArrayList<C> next;

    public C getPre() {
        return pre;
    }

    public void setPre(C pre) {
        this.pre = pre;
    }

    public ArrayList<C> getNext() {
        return next;
    }

    public void setNext(ArrayList<C> next) {
        this.next = next;
    }


}
