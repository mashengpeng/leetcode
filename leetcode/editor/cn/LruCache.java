package editor.cn;
 
import java.util.*; 


public class LruCache{
    public static void main(String[] args) {
        //Solution solution = new LruCache().new Solution();
        LRUCache cache = new LruCache().new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);

    }
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    HashMap<Integer, ListNode> map;
    int capacity;
    int size;
    MyList list;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new MyList();
        size = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            list.delete(map.get(key));
            list.addFirst(map.get(key));
            return map.get(key).val;
        }else{
            return -1;
        }

    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            if(size == capacity) {
                map.remove(list.getLast().key);
                list.removeLast();
                size--;
            }
            ListNode node = new ListNode(key, value);
            list.addFirst(node);
            size++;
            map.put(key, node);
            return;
        }
        map.get(key).val = value;
        get(key);


    }

}
class MyList {
    ListNode head;
    ListNode tail;
    ListNode getLast() {
        return tail.prev;
    }
    MyList(){
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    void addFirst(ListNode node) {
        ListNode tmp = head.next;
        head.next = node;
        node.next = tmp;
        tmp.prev = node;
        node.prev = head;
    }

    void removeLast() {
        delete(tail.prev);
    }

    void delete(ListNode node){
        ListNode p = node.prev;
        ListNode n = node.next;
        p.next = n;
        n.prev = p;
    }


}
class ListNode{
    int key;
    int val;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    ListNode prev;
    ListNode next;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

