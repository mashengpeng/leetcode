package editor.cn;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class MinimumHeightTrees{
    public static void main(String[] args) {
        Solution solution = new MinimumHeightTrees().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        int[] cnt = new int[n];
        Arrays.fill(cnt, 0);
        List<List<Integer>> c = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            c.add(new ArrayList<>());
        }
        for (int[] x : edges) {
            c.get(x[0]).add(x[1]);
            c.get(x[1]).add(x[0]);
            cnt[x[0]]++;
            cnt[x[1]]++;
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(cnt[i] == 1){
                list.add(i);
            }
        }
        int remain = n;
        while(remain > 2){
            int len = list.size();
            remain -= len;
            for (int i = 0; i < len; i++) {
                int cur = list.removeFirst();

                List<Integer> next = c.get(cur);
                for (int j = 0; j < next.size(); j++) {
                    int tmp = next.get(j);
                    if (--cnt[tmp] == 1){
                        list.add(tmp);
                    }
                }
            }
        }

        while(!list.isEmpty()){
            ans.add(list.removeFirst());
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
