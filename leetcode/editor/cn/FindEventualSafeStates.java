package editor.cn;
 
import java.util.*; 


public class FindEventualSafeStates{
    public static void main(String[] args) {
        Solution solution = new FindEventualSafeStates().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] out = new int[n];
        LinkedList<Integer> list = new LinkedList<>();
        List<List<Integer>> back = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            back.add(new ArrayList<>());
            out[i] = graph[i].length;
            if(out[i] == 0){
                list.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                back.get(graph[i][j]).add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();

        while(!list.isEmpty()){
            int len = list.size();
            for (int i = 0; i < len; i++) {
                int x = list.removeFirst();

                for (int j = 0; j < back.get(x).size(); j++) {
                    if(--out[back.get(x).get(j)] == 0){
                        list.add(back.get(x).get(j));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(out[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
