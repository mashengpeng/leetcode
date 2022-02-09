package editor.cn;
 
import java.util.*; 


public class EscapeALargeMaze{
    public static void main(String[] args) {
        Solution solution = new EscapeALargeMaze().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        int n = blocked.length;

        HashSet<Integer> s = new HashSet<>();
        for(int[] block : blocked){
            s.add(has(block[0], block[1]));
        }
        LinkedList<int[]> list = new LinkedList<>();

        list.add(source);

        int k = 0;
        while(k++ < n * n / 2){
            if(list.isEmpty()){
                return false;
            }
            int[] cur = list.pollFirst();
            int x = cur[0], y = cur[1];

            if(x == target[0] && y == target[1]){
                return true;
            }

            if(x - 1 >= 0 && !s.contains(has(x - 1, y))){
                list.addLast(new int[]{x - 1, y});
                s.add(has(x - 1, y));
            }

            if(x + 1 < 1000000 && !s.contains(has(x + 1, y))){
                list.addLast(new int[]{x + 1, y});
                s.add(has(x + 1, y));
            }

            if(y - 1 >= 0 && !s.contains(has(x, y - 1))){
                list.addLast(new int[]{x, y - 1});
                s.add(has(x , y- 1));
            }

            if(y + 1 < 1000000 && !s.contains(has(x, y + 1))){
                list.addLast(new int[]{x, y + 1});
                s.add(has(x, y + 1));
            }

        }

        s.clear();
        list.clear();
        list.add(target);
        for(int[] block : blocked){
            s.add(has(block[0], block[1]));
        }
        k = 0;
        while(k++ < n * n / 2){
            if(list.isEmpty()){
                return false;
            }
            int[] cur = list.pollFirst();
            int x = cur[0], y = cur[1];

            if(x - 1 >= 0 && !s.contains(has(x - 1, y))){
                list.addLast(new int[]{x - 1, y});
                s.add(has(x - 1, y));
            }

            if(x + 1 < 1000000 && !s.contains(has(x + 1, y))){
                list.addLast(new int[]{x + 1, y});
                s.add(has(x + 1, y));
            }

            if(y - 1 >= 0 && !s.contains(has(x, y - 1))){
                list.addLast(new int[]{x, y - 1});
                s.add(has(x , y- 1));
            }

            if(y + 1 < 1000000 && !s.contains(has(x, y + 1))){
                list.addLast(new int[]{x, y + 1});
                s.add(has(x, y + 1));
            }

        }
        return true;


    }
    int has(int x, int y){
        return x * 131 + y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}