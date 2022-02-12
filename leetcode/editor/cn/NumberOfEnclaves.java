package editor.cn;
 
import java.util.*; 


public class NumberOfEnclaves{
    public static void main(String[] args) {
        Solution solution = new NumberOfEnclaves().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1){
                q.addLast(new int[]{i, 0});
            }
            if(grid[i][n-1] == 1){
                q.addLast(new int[]{i, n-1});
            }
        }

        for(int i = 0; i < n; i++){
            if(grid[0][i] == 1){
                q.addLast(new int[]{0, i});
            }
            if(grid[m-1][i] == 1){
                q.addLast(new int[]{m-1, i});
            }
        }

        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int[] pos = q.pollFirst();
                int x = pos[0];
                int y = pos[1];

                if(grid[x][y] == 0){
                    continue;
                }
                grid[x][y] = 0;

                if(x - 1 >= 0 && grid[x-1][y] == 1){
                    q.addLast(new int[]{x-1, y});
                }
                if(y - 1 >= 0 && grid[x][y-1] == 1){
                    q.addLast(new int[]{x, y-1});
                }
                if(x + 1 < m && grid[x+1][y] == 1){
                    q.addLast(new int[]{x+1, y});
                }
                if(y + 1 < n && grid[x][y+1] == 1){
                    q.addLast(new int[]{x, y+1});
                }
            }
        }
        int ans = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}