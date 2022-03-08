package editor.cn;
 
import java.util.HashMap;
import java.util.LinkedList;


public class LfuCache{
    public static void main(String[] args) {
        LFUCache lfuCache = new LfuCache().new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 3);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {

    HashMap<Integer, LinkedList<Node>> f;
    HashMap<Integer, Node> m;
    int capacity;
    int min;
    public LFUCache(int capacity) {
        f = new HashMap<>();
        m = new HashMap<>();
        this.capacity = capacity;

    }
    
    public int get(int key) {
        if(!m.containsKey(key) || capacity == 0){
            return -1;
        }

        Node node = m.get(key);
        int value = node.value;
        int cnt = node.cnt;
        f.get(cnt).remove(node);
        if(f.get(cnt).size() == 0){
            f.remove(cnt);
            if(min == cnt) {
                min++;
            }
        }

        node.cnt++;
        LinkedList<Node> list = f.getOrDefault(cnt + 1, new LinkedList<>());
        list.addFirst(node);
        f.put(cnt + 1, list);
        //m.put(key, list.peekFirst());
        m.put(key, node);
        return value;

    }
    
    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        if(!m.containsKey(key) && m.size() == capacity){
            Node node = f.get(min).getLast();
            f.get(min).removeLast();
            m.remove(node.key);
            if(f.get(min).size() == 0){
                f.remove(min);
                min = 1;
            }
        }

        if(m.containsKey(key)){
            Node node = m.get(key);
            int cnt = node.cnt;
            f.get(cnt).remove(node);
            if(f.get(cnt).size() == 0){
                f.remove(cnt);
                if(min == cnt) {
                    min++;
                }
            }
            node.value = value;
            node.cnt++;
            LinkedList<Node> list = f.getOrDefault(cnt + 1, new LinkedList<>());
            list.addFirst(node);
            f.put(cnt + 1, list);
            //m.put(key, list.peekFirst());
            m.put(key, node);
        }else{
            Node node = new Node(key, value, 1);
            LinkedList<Node> list = f.getOrDefault(1, new LinkedList<>());
            list.addFirst(node);
            f.put(1, list);
            //m.put(key, list.peekFirst());
            m.put(key, node);
            min = 1;
        }


    }
}
class Node{
    int key, value, cnt;

    public Node(int key, int value, int cnt) {
        this.key = key;
        this.value = value;
        this.cnt = cnt;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)


}