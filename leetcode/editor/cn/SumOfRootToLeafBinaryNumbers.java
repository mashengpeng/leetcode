package editor.cn;


public class SumOfRootToLeafBinaryNumbers{
    public static void main(String[] args) {
        Solution solution = new SumOfRootToLeafBinaryNumbers().new Solution();
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
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    int dfs(TreeNode root, int cur){
        if(root == null){
            return 0;
        }
        cur = (cur << 1) + root.val;
        if(root.left == null && root.right == null){
            return cur;
        }
        return dfs(root.left, cur) + dfs(root.right, cur);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
