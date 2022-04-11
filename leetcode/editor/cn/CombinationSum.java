package editor.cn;
 
import java.util.*;


public class CombinationSum{
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        System.out.println(solution.combinationSum(new int[]{1, 2}, 3));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] c;
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        candidates = Arrays.stream(candidates).filter(x->x<=target).toArray();
        c = candidates;

        dfs(0, target);
        return ans;
    }

    void dfs(int i, int target){
        if(i == c.length){
            return;
        }

        if(target == 0){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        dfs(i + 1, target);

        if(c[i] <= target){
            tmp.add(c[i]);
            dfs(i, target - c[i]);
            tmp.remove(tmp.size()-1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
