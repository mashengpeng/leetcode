import java.util.*;

public class honor {


    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            String s = in.next();
            String[] ans = new String[n];
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                if(s.charAt(9 * i) == '1'){
                    sb.append(s, 9*i+1, 9*i+9);
                    ans[i] = sb.toString();
                }else if(s.charAt(9 * i) == '0'){
                    sb.append(s, 9*i+1, 9*i+9);
                    ans[i] = sb.reverse().toString();
                }
            }
            for (int i = 0; i < n - 1; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.print(ans[n - 1]);
        }
    }


    public static void main2(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int left = in.nextInt();
            int right = in.nextInt();

            boolean[] a = new boolean[right - left];
            Arrays.fill(a, false);
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 2; i < (int)Math.sqrt(right) + 1; i++) {
                int offset = left / i;
                int cur = offset * i;
                while(cur < right){
                    if(cur < left){
                        cur += i;
                        continue;
                    }
                    a[cur - left] = true;
                    cur += i;
                }
            }

            for (int i = 0; i < a.length; i++) {
                if(a[i]){
                    continue;
                }
                int cur = i + left;
                sum2 += cur % 10;
                cur /= 10;
                sum1 += cur % 10;
                //System.out.println(i + left);
            }
            System.out.println(Math.min(sum1, sum2));
        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.next();
            String[] s1 = s.split("/");
            int n = Integer.parseInt(s1[1]);
            String[] t = s1[0].split(";");

            List<Task> info = new ArrayList<>(t.length);
            for (int i = 0; i < t.length; i++) {
                info.add(new Task());
            }


            HashMap<String,Integer> map = new HashMap<>();
            int id = 0;
            for (int i = 0; i < t.length; i++) {

                String[] f = t[i].split(":");
                //b [a] 2

                if(!map.containsKey(f[0])){
                    map.put(f[0], id++);
                }
                int idx = map.get(f[0]);
                Task cur = info.get(idx);
                cur.time = Integer.parseInt(f[2]);

                String[] ts = f[1].substring(1, f[1].length()-1).split(",");

                cur.indegree = ts.length;

                for (int j = 0; j < ts.length; j++) {
                    if(ts[j].length() == 0){
                        cur.indegree = 0;
                        break;
                    }
                    if(!map.containsKey(ts[j])){
                        map.put(ts[j], id++);
                    }
                    info.get(map.get(ts[j])).next.add(idx);
                }

            }

            LinkedList<Task> queue = new LinkedList<>();

            PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x.endTime));
            for (int i = 0; i < info.size(); i++) {
                if(info.get(i).indegree == 0){
                    queue.add(info.get(i));
                }
            }

            long curTime = 0;

            for (int i = 0; i < Math.min(queue.size(), n); i++) {
                Task tmp = queue.removeFirst();
                tmp.endTime = curTime + tmp.time;
                pq.add(tmp);
            }
            while(!queue.isEmpty() || !pq.isEmpty()){
                Task tmp = pq.poll();
                curTime = tmp.endTime;

                List<Integer> next = tmp.next;
                for (int i = 0; i < next.size(); i++) {
                    if(--info.get(next.get(i)).indegree == 0){
                        queue.addLast(info.get(next.get(i)));
                    }
                }

                while(!queue.isEmpty() && pq.size() < n){
                    Task first = queue.removeFirst();
                    first.endTime = curTime + first.time;
                    pq.add(first);
                }
            }

            System.out.println(curTime);
        }
    }


}

class Task{

    List<Integer> next;
    long time;
    long indegree;
    long endTime;
    public Task() {
        next = new LinkedList<>();
        time = 0;
        indegree = 0;
        endTime = 0;
    }
    public Task(List<Integer> next) {
        this.next = next;
    }
}
