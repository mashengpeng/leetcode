package editor.cn;

import java.util.ArrayDeque;


public class EvenOddTree{
    public static void main(String[] args) {
        //Solution solution = new EvenOddTree().new Solution();
    }

    public class TreeNode {
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
    public boolean isEvenOddTree(TreeNode root) {
        ArrayDeque<TreeNode> list = new ArrayDeque<>();

        if(root == null){
            return false;
        }
        int pre;
        boolean isEven = true;
        list.add(root);

        while(!list.isEmpty()){
            int n = list.size();
            if(isEven){
                pre = 0;
            }else{
                pre = 1000001;
            }

            for (int i = 0; i < n; i++) {
                TreeNode cur = list.pollFirst();
                if(isEven){
                    if((cur.val & 1) != 1 || cur.val <= pre){

                        return false;
                    }
                }else {
                    if((cur.val & 1) != 0 || cur.val >= pre){

                        return false;
                    }
                }
                //System.out.println(cur.val);
                pre = cur.val;

                if(cur.left != null)    list.addLast(cur.left);

                if(cur.right != null)   list.addLast(cur.right);
            }
            isEven = !isEven;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
