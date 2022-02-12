package editor.cn;
 
import java.util.*; 


public class MaximumNumberOfEatenApples{
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfEatenApples().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> p = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int n = apples.length;
        for(int i = 0; i < n; i++){
            if(apples[i] != 0){
                p.add(new int[]{apples[i], i + days[i]});
            }

            while(!p.isEmpty() && (p.peek()[1] <= i || p.peek()[0] == 0)){
                p.poll();
            }

            if(!p.isEmpty()){
                p.peek()[0]--;
                ans++;

            }
        }
        int day = n;
        while(!p.isEmpty()){
            while(!p.isEmpty() && (p.peek()[1] <= day || p.peek()[0] == 0)){
                p.poll();
            }
            if(!p.isEmpty()){
                int[] tmp = p.poll();
                int num = Math.min(tmp[0], tmp[1] - day);

                day += num;
                ans += num;

            }
        }

        return ans;


    }
}
//leetcode submit region end(Prohibit modification and deletion)


}