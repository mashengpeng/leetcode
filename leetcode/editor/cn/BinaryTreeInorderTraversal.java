package editor.cn;
 
import java.util.*; 


public class BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
    List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(root != null){
            stack.addLast(root);
            root = root.left;
        }

        while(!stack.isEmpty()){
            TreeNode cur = stack.removeLast();
            ans.add(cur.val);

            cur = cur.right;
            while(cur != null){
                stack.addLast(cur);
                cur = cur.left;
            }
        }
        return ans;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }

        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
