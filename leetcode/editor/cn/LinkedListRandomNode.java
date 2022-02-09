package editor.cn;

import java.util.*;


public class LinkedListRandomNode{
    public static void main(String[] args) {
        Solution solution = new LinkedListRandomNode().new Solution();
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
    Random random;
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
        random = new Random(20220124);
    }
    public Solution(){}
    
    public int getRandom() {
        ListNode tmp = head;
        int res = tmp.val;
        int idx = 0;
        while(tmp != null){
            if(random.nextInt(++idx) == 0){
                res = tmp.val;
            }
            tmp = tmp.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)


}