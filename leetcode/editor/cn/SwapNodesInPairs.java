package editor.cn;


public class SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
    }




class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        ListNode left = dummy.next;

        while(left != null && left.next != null){
            ListNode cur = left.next;
            left.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;


            pre = left;
            left = left.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}