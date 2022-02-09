package editor.cn;
 
import java.util.*; 


public class MapOfHighestPeak{
    public static void main(String[] args) {
        Solution solution = new MapOfHighestPeak().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] ans = new int[m][n];

        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    list.addLast(toHash(i, j));
                    ans[i][j] = -1;
                }
            }
        }

        int cnt = 1;
        while(!list.isEmpty()){
            int len = list.size();

            for(int i = 0; i < len; i++){
                int cur = list.pollFirst();
                int x = cur / 1001;
                int y = cur % 1001;

                if(x - 1 >= 0 && ans[x - 1][y] == 0){
                    list.addLast(toHash(x - 1, y));
                    ans[x - 1][y] = cnt;
                }
                if(y - 1 >= 0 && ans[x][y - 1] == 0){
                    list.addLast(toHash(x, y - 1));
                    ans[x][y - 1] = cnt;
                }
                if(x + 1 < m && ans[x + 1][y] == 0){
                    list.addLast(toHash(x + 1, y));
                    ans[x + 1][y] = cnt;
                }
                if(y + 1 < n && ans[x][y + 1] == 0){
                    list.addLast(toHash(x, y + 1));
                    ans[x][y + 1] = cnt;
                }
            }
            cnt++;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(ans[i][j] == -1){
                    ans[i][j] = 0;
                }
            }
        }
        return ans;

    }

    int toHash(int x, int y){
        return x * 1001 + y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}