import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class huawei {
    static String[] num;
    static LinkedList<Node> list;
    static ArrayList<Node> l;
    static ArrayList<Node> result;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String input = in.next();
            input = input.substring(1, input.length()-1);
            num = input.split(",");
            list = new LinkedList<>();
            Node root = new Node(1, Integer.parseInt(num[0]));

            list.add(root);
            while(!list.isEmpty()){
                fun(list.pollFirst());
            }
            l = new ArrayList<>();
            addNode(root);
            result = new ArrayList<>();
            for (int i = 0; i < l.size(); i++) {
                for (int j = i+1; j < l.size(); j++) {
                    if(height(l.get(i)) != height(l.get(j))){
                        continue;
                    }
                    if(height(l.get(i)) == 1){
                        continue;
                    }

                    if(check(l.get(i), l.get(j))){
                        result.add(l.get(i));
                    }
                }
            }
            int maxHeight = 0;
            if(result.isEmpty()){
                System.out.println(-1);
                continue;
            }
            Node res = null;

            for (int i = 0; i < result.size(); i++) {
                if(height(result.get(i)) > maxHeight){
                    maxHeight = height(result.get(i));
                    res = result.get(i);
                }
            }

            ArrayList<String> ans = new ArrayList<>();

            LinkedList<Node> tmp = new LinkedList<>();

            tmp.add(res);

            while(!tmp.isEmpty()){
                int n = tmp.size();
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    Node cur = tmp.pollFirst();

                    if(cur.val == -1){
                        ans.add("null");
                        tmp.add(new Node(-1));
                        tmp.add(new Node(-1));
                        continue;
                    }

                    ans.add(String.valueOf(cur.val));

                    if(cur.left != null){
                        tmp.add(cur.left);
                        flag = true;
                    }else{
                        tmp.add(new Node(-1));
                    }

                    if(cur.right != null){
                        tmp.add(cur.right);
                        flag = true;
                    }else{
                        tmp.add(new Node(-1));
                    }

                }
                if(!flag){
                    break;
                }
            }

            System.out.println(ans);
        }
    }
    static void addNode(Node root){

        l.add(root);
        if(root.left != null){
            addNode(root.left);
        }
        if(root.right != null){
            addNode(root.right);
        }
    }
    static void fun(Node root){
        int id = root.id;
        int left = id*2;
        int right = id*2+1;


        if(left-1 >= 0 && left-1 < num.length){
            if("null".equals(num[left-1])){
                root.left = null;
            }else{
                root.left = new Node(left, Integer.parseInt(num[left-1]));
                list.add(root.left);
            }
        }else{
            root.left = null;
        }

        if(right-1 >= 0 && right-1 < num.length){
            if("null".equals(num[right-1])){
                root.right = null;
            }else{
                root.right = new Node(right, Integer.parseInt(num[right-1]));
                list.add(root.right);
            }
        }else{
            root.right = null;
        }


    }
    static int height(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    static boolean check(Node a, Node b){
        if(a == null && b == null){
            return true;
        }

        if(a.val != b.val){
            return false;
        }

        return check(a.left, b.left) && check(a.right, b.right);
    }


//    public static void main(String[] args) {
//        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
//        // please finish the function body here.
//        // please define the JAVA output here. For example: System.out.println(s.nextInt());
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            int m = in.nextInt();
//            int n = in.nextInt();
//            //String s = in.next();\
//            //String[] ss = s.split(" ");
//
//            String[] ss = new String[n];
//            for (int i = 0; i < n; i++) {
//                ss[i] = in.next();
//            }
//            System.out.println(Arrays.toString(ss));
//            int x = 0, num = 4, y = 0;
//            int ans1 = 0, ans2 = 0;
//            boolean flag = true;
//            for (int i = 0; i < n; i++) {
//                if("A".equals(ss[i])){
//                    if(num == 4){
//                        x = Math.max(x, y) + 1;
//                        num = 1;
//                        if(x > m){
//                            flag = false;
//                            break;
//                        }
//                        ans1 = x;
//                        ans2 = num;
//                    }else{
//                        num++;
//                        ans1 = x;
//                        ans2 = num;
//                    }
//                }else if("B".equals(ss[i])){
//                    y = Math.max(x, y) + 1;
//                    if(y > m){
//                        flag = false;
//                        break;
//                    }
//                    ans1 = y;
//                    ans2 = 1;
//                }
//            }
//            if(flag){
//                System.out.println(ans1);
//                System.out.println(ans2);
//            }else{
//                System.out.println(0);
//                System.out.println(0);
//            }
////            5 6
////            A B A B A A
//
////            2 3
////            B A B
//        }
//
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            int m = in.nextInt();
//            int n = in.nextInt();
//
//            int sx = in.nextInt();
//            int sy = in.nextInt();
//
//            int ex = in.nextInt();
//            int ey = in.nextInt();
//
//            boolean[][] map = new boolean[m][n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    map[i][j] = true;
//                }
//            }
//
//            int num = in.nextInt();
//            for (int i = 0; i < num; i++) {
//                int x = in.nextInt();
//                int y = in.nextInt();
//                map[x][y] = false;
//            }
//            int ans1 = 0;//tiaoshu
//            int ans2 = 0;//zuiduanjuli
//
//            LinkedList<int[]> list = new LinkedList<>();
//            list.addLast(new int[]{sx, sy});
//            boolean flag = false;
//            while(!list.isEmpty()){
//
//                int len = list.size();
//                for (int i = 0; i < len; i++) {
//                    int[] cur = list.pollFirst();
//                    int x = cur[0];
//                    int y = cur[1];
//
//                    if(x == ex && y == ey){
//                        flag = true;
//                        ans1++;
//                        continue;
//                    }
//                    if(x - 1 >= 0 && map[x-1][y]){
//                        list.addLast(new int[]{x-1, y});
//                    }
//                    if(y - 1 >= 0 && map[x][y-1]){
//                        list.addLast(new int[]{x, y-1});
//                    }
//                    if(x + 1 < m && map[x+1][y]){
//                        list.addLast(new int[]{x+1, y});
//                    }
//                    if(y + 1 < n && map[x][y+1]){
//                        list.addLast(new int[]{x, y+1});
//                    }
//
//
//                }
//                if(flag){
//                    break;
//                }
//                ans2++;
//            }
//            System.out.println(ans1 + " " + ans2);
//
//
//        }
//    }

}
class Node{
    int id;
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
    Node(int id, int val){
        this.id = id;
        this.val = val;

    }
}