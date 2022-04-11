package editor.cn;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class ArrayOfDoubledPairs{
    public static void main(String[] args) {
        Solution solution = new ArrayOfDoubledPairs().new Solution();
        System.out.println(solution.canReorderDoubled(new int[]{1,2,4,16,8,4}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int N = 200001;
    int M = 100000;
    int[] cnt = new int[N];
    int[] in = new int[N];
    public boolean canReorderDoubled(int[] arr) {
        Arrays.fill(cnt, 0);
        Arrays.fill(in, 0);
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : arr) {
            if(++cnt[x+M] == 1 && x != 0){
                list.add(x);
            }
        }
        if((cnt[M] & 1) != 0){
            return false;
        }
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            if((cur & 1) != 0){
                q.addLast(cur);
                continue;
            }

            in[cur + M] = cnt[cur / 2 + M];
            if (in[cur + M] == 0) {
                q.addLast(cur);
            }
        }

        while (!q.isEmpty()) {

            int cur = q.removeFirst();

            if (cur * 2 + M >= N) {
                return false;
            }

            in[cur * 2 + M] -= cnt[cur + M];
            cnt[cur * 2 + M] -= cnt[cur + M];
            if (cnt[cur * 2 + M] < 0) {
                return false;
            }
            if(in[cur * 2 + M] == 0 && cnt[cur * 2 + M] != 0){
                q.addLast(cur * 2);
            }

            if (cur * 4 + M < N) {
                in[cur * 4 + M] -= cnt[cur + M];
                if (in[cur * 4 + M] == 0 && cnt[cur * 4 + M] != 0) {
                    q.addLast(cur * 4);
                }
            }

        }

        return true;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
