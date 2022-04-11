package editor.cn;
 
import java.util.*; 


public class CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] c;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        for (int i = 0; i < candidates.length; i++) {
            map.put(candidates[i], map.getOrDefault(candidates[i], 0) + 1);
        }
        //candidates = Arrays.stream(candidates).filter(x->x<=target).distinct().sorted().toArray();
        candidates = Arrays.stream(candidates).distinct().sorted().toArray();
        c = candidates;
        dfs(0, target);
        return ans;
    }

    void dfs(int idx, int target){
        if(target == 0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if(idx == c.length || c[idx] > target){
            return;
        }
        dfs(idx + 1, target);

        List<Integer> save = new ArrayList<>(tmp);
        for (int i = 1; i <= map.get(c[idx]); i++) {
            tmp.add(c[idx]);
            int t = target - c[idx] * i;
            if(t  < 0){
                break;
            }
            dfs(idx + 1, t);
        }

        tmp = save;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
