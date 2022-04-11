package editor.cn;
 
import java.util.*; 


public class BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        Deque<TreeNode> p = new ArrayDeque<>();
        q.addLast(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.removeLast();
                l.add(cur.val);

                if(flag){
                    if(cur.left != null){
                        p.addLast(cur.left);
                    }
                    if(cur.right != null){
                        p.addLast(cur.right);
                    }
                }else{
                    if(cur.right != null){
                        p.addLast(cur.right);
                    }
                    if(cur.left != null){
                        p.addLast(cur.left);
                    }
                }
            }
            q.addAll(p);
            p.clear();
            flag = !flag;
            ans.add(l);
        }
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
