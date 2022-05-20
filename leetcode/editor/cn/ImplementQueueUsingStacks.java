package editor.cn;
 
import java.util.*; 


public class ImplementQueueUsingStacks{
    public static void main(String[] args) {
        //Solution solution = new ImplementQueueUsingStacks().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {
    LinkedList<Integer> in;
    LinkedList<Integer> out;

    public MyQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }
    
    public void push(int x) {
        in.addLast(x);
    }
    
    public int pop() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.addLast(in.removeLast());
            }
        }
        return out.removeLast();
    }
    
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.addLast(in.removeLast());
            }
        }
        return out.getLast();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)


}