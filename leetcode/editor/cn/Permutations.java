package editor.cn;
 
import java.util.*; 


public class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
        vis = new boolean[nums.length];
        Arrays.fill(vis, false);
        dfs(nums);
        return ans;
    }

    void dfs(int[] nums){
        if(tmp.size() == nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(vis[i]){
                continue;
            }
            vis[i] = true;
            tmp.add(nums[i]);
            dfs(nums);
            tmp.remove(tmp.size()-1);
            vis[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
