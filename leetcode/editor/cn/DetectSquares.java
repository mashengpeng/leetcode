package editor.cn;
 
import java.util.*; 


//public class DetectSquares{
//    public static void main(String[] args) {
//        Solution solution = new DetectSquares().new Solution();
//    }
//
    
//leetcode submit region begin(Prohibit modification and deletion)
class DetectSquares {

    Map<Integer, Map<Integer,Integer>> h;


    public DetectSquares() {
        h = new HashMap<>();

    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        if(h.containsKey(x)){
            if(h.get(x).containsKey(y)){
                h.get(x).put(y, h.get(x).get(y) + 1);
            }else{
                h.get(x).put(y, 1);
            }
        }else{
            HashMap<Integer,Integer> tmp = new HashMap<>();
            tmp.put(y, 1);
            h.put(x, tmp);
        }

    }
    
    public int count(int[] point) {
        int ans = 0;
        int x = point[0], y = point[1];
        Map<Integer,Integer> tmp;
        if(!h.containsKey(x)){
            return 0;
        }else{
            tmp = h.get(x);
        }

        for(int ny : tmp.keySet()){
            int len = Math.abs(ny - y);
            if(len == 0){
                continue;
            }
            if(h.containsKey(x + len)){
                ans += tmp.get(ny)
                        * h.get(x + len).getOrDefault(ny, 0)
                        * h.get(x + len).getOrDefault(y, 0);
            }

            if(h.containsKey(x - len)){
                ans += tmp.get(ny)
                        * h.get(x - len).getOrDefault(ny, 0)
                        * h.get(x - len).getOrDefault(y, 0);
            }
        }
        return ans;

    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
//leetcode submit region end(Prohibit modification and deletion)


//}