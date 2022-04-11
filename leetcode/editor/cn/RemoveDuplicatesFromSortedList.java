package editor.cn;


public class RemoveDuplicatesFromSortedList{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
    }

class ListNode {
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
        ListNode dummy = new ListNode(-1000);
        ListNode tail = dummy;

        ListNode tmp = head;
        while(tmp != null){
            if(tail.val != tmp.val){
                tail.next = tmp;
                tail = tail.next;
            }
            tmp = tmp.next;
            tail.next = null;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}