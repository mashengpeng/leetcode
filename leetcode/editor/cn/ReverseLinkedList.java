package editor.cn;


//public class ReverseLinkedList{
//    public static void main(String[] args) {
//        Solution solution = new ReverseLinkedList().new Solution();
//    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//class Solution {
//    public ListNode reverseList(ListNode head) {
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode pre = dummy;
//        ListNode left = head;
//        ListNode cur = left.next;
//        while(left != null){
//            cur = left.next;
//            left.next = cur.next;
//            cur.next = pre.next;
//            pre.next = cur;
//
//        }
//
//        return dummy.next;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//
//}
//class ListNode {
//    int val;
//    editor.cn.ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, editor.cn.ListNode next) { this.val = val; this.next = next; }
//}