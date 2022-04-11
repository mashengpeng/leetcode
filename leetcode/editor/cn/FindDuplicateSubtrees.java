package editor.cn;
 
import java.util.*;


public class FindDuplicateSubtrees{
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<String, Integer> map;
    HashMap<Integer, Integer> cnt;
    List<TreeNode> ans;
    int x = 0;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        ans = new ArrayList<>();
        cnt = new HashMap<>();
        dfs(root);
        return ans;

    }

    public int dfs(TreeNode root){
        if(root == null){
            return -1000;
        }
        String cur = root.val + "," + dfs(root.left) + "," + dfs(root.right);

        map.putIfAbsent(cur, x++);
        int id = map.get(cur);
        cnt.put(id, cnt.getOrDefault(id, 0) + 1);
        if(cnt.get(id) == 2){
            ans.add(root);
        }
        return id;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}