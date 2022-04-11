package editor.cn;
 
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class NAryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();
    }



class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.

*/

class Solution {
//    ArrayList<Integer> ans = new ArrayList<>();
//    public List<Integer> preorder(Node root) {
//        dfs(root);
//        return ans;
//
//    }
//    void dfs(Node n){
//        if(n == null){
//            return;
//        }
//
//        ans.add(n.val);
//        for (Node node : n.children) {
//            dfs(node);
//        }
//    }


    ArrayList<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        ArrayDeque<Node> stack = new ArrayDeque<>();
        if(root == null){
            return ans;
        }
        Node cur = root;
        ans.add(cur.val);
        while(cur.children.size() != 0){
            for (int i = cur.children.size() - 1; i >= 1; i--) {
                stack.push(cur.children.get(i));
            }
            cur = cur.children.get(0);
            ans.add(cur.val);
        }

        while(!stack.isEmpty()){
            cur = stack.pop();
            ans.add(cur.val);
            while(cur.children.size() != 0){
                for (int i = cur.children.size() - 1; i >= 1; i--) {
                    stack.push(cur.children.get(i));
                }
                cur = cur.children.get(0);
                ans.add(cur.val);
            }

        }

        return ans;

    }

}
//leetcode submit region end(Prohibit modification and deletion)


}