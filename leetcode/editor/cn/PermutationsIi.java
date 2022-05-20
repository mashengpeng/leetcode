package editor.cn;
 
import java.util.*; 


public class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        Arrays.fill(vis, false);
        Arrays.sort(nums);
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
            if(i - 1 >= 0 && nums[i-1] == nums[i] && !vis[i-1]){
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

class Solution2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> a = new ArrayList<>();
        List<List<Integer>> b = new ArrayList<>();

        a.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < a.size(); j++) {
                List<Integer> list = a.get(j);
                for (int k = 0; k <= list.size(); k++) {
                    if(k < list.size() && list.get(k) == nums[i]){
                        continue;
                    }
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(k, nums[i]);
                    b.add(tmp);
                }
            }
            a = b;
            b = new ArrayList<>();
        }
        return a;

    }
    int hash(List<Integer> list){
        int hash = 0;
        for (int i = 0; i < list.size(); i++) {
            hash |= (list.get(i) & 0xf) << (4 * i);
        }
        return hash;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
