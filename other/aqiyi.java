public class aqiyi {

    public static void main(String[] args) {
        aqiyi a = new aqiyi();

        List list = a.new List();

    }

    class List{
        ListNode dummy;
        ListNode cur;

        List(){
            dummy = new ListNode(-1);
            dummy.pre = dummy;
            dummy.next = dummy;
            cur = dummy;
        }

        void add(ListNode node){
            cur.next = node;
            node.pre = cur;
            node.next = dummy;
            cur = node;
        }

        void fun1(){
            ListNode head = dummy.next;
            while(head != dummy){
                System.out.println(head);
                head = head.next;
            }
        }

        void fun2(){
            ListNode tail = dummy.pre;
            while(tail != dummy){
                System.out.println(tail);
                tail = tail.pre;
            }
        }

    }
    class ListNode{
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}




