package editor.cn;

import java.util.LinkedList;


public class ReorderList{
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
    }
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
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode back = slow.next;
        slow.next = null;
        back = reverseList(back);

        while(head != null && back != null){
            cur.next = head;
            head = head.next;
            cur = cur.next;

            cur.next = back;
            back = back.next;
            cur = cur.next;
        }

        if(head != null){
            cur.next = head;
            head = head.next;
            cur = cur.next;
        }
        if(back != null){
            cur.next = back;
            back = back.next;
            cur = cur.next;
        }

    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public void reorderList2(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode dummy = new ListNode(-1);

        ListNode cur = dummy;
        while(head != null){
            list.offer(head);
            head = head.next;
        }
        boolean flag = true;
        while(!list.isEmpty()){
            if(flag){
                cur.next = list.pollFirst();
                cur = cur.next;
            }else{
                cur.next = list.pollLast();
                cur = cur.next;
            }
            flag = !flag;
        }
        cur.next = null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
