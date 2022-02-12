package editor.cn;


public class RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
    }

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode tail = dummy;

        while(head != null){
            if(head.next == null || head.val != head.next.val){
                tail.next = head;
                tail = head;
            }
            while(head.next != null && head.val == head.next.val){
                head = head.next;
            }
            head = head.next;
        }
        tail.next = null;
        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}