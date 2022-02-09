package editor.cn;
 
import java.util.*;


public class StockPriceFluctuation{
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPriceFluctuation().new StockPrice();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
//class StockPrice {
//
//
//    PriorityQueue<int[]> h = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));
//    PriorityQueue<int[]> l = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
//    HashMap<Integer, Integer> hashMap = new HashMap<>();
//    int maxTimeStamp;
//
//    public StockPrice() {
//        maxTimeStamp = 0;
//    }
//
//    public void update(int timestamp, int price) {
//        maxTimeStamp = Math.max(timestamp, maxTimeStamp);
//        hashMap.put(timestamp, price);
//
//        h.add(new int[]{timestamp, price});
//        l.add(new int[]{timestamp, price});
//    }
//
//    public int current() {
//        return hashMap.get(maxTimeStamp);
//    }
//
//    public int maximum() {
//        while(true){
//            int[] tmp = h.peek();
//            if(hashMap.get(tmp[0]) == tmp[1]){
//                return tmp[1];
//            }
//            h.poll();
//        }
//    }
//
//    public int minimum() {
//        while(true){
//            int[] tmp = l.peek();
//            if(hashMap.get(tmp[0]) == tmp[1]){
//                return tmp[1];
//            }
//            l.poll();
//        }
//    }
//}

class StockPrice {
    TreeMap<Integer, Integer> treeMap;
    HashMap<Integer, Integer> hashMap;
    int maxTimeStamp;
    public StockPrice() {
        treeMap = new TreeMap<>();
        hashMap = new HashMap<>();
        maxTimeStamp = 0;
    }

    public void update(int timestamp, int price) {
        maxTimeStamp = Math.max(maxTimeStamp, timestamp);
        if (hashMap.containsKey(timestamp)){// 有过
            int oldPrice = hashMap.get(timestamp);
            int cnt = treeMap.get(oldPrice);
            if (cnt == 1){
                treeMap.remove(oldPrice);
            }else {
                treeMap.put(oldPrice, cnt - 1);
            }

        }

        treeMap.put(price, treeMap.getOrDefault(price, 0) + 1);

        hashMap.put(timestamp, price);

    }

    public int current() {
        return hashMap.get(maxTimeStamp);
    }

    public int maximum() {
        return treeMap.lastKey();
    }

    public int minimum() {
        return treeMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
//leetcode submit region end(Prohibit modification and deletion)


}