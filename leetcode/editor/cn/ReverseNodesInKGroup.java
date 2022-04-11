package editor.cn;


public class ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
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
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            n++;
        }
        int loop = n / k;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode left = head;

        for (int i = 0; i < loop; i++) {
            for (int j = 0; j < k - 1; j++) {

                //头插法翻转k-1个节点得到k个逆序的节点
                cur = left.next;
                left.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }

            //移动到下一个需要反转的位置
            pre = left;
            left = left.next;
        }

        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}