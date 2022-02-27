package editor.cn;
 
import java.util.*; 


public class MinimumOperationsToConvertNumber{
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToConvertNumber().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[1001];
        Arrays.fill(visited, false);
        int len = nums.length;
        int ans = 0;
        list.addLast(start);
        visited[start] = true;
        while(!list.isEmpty()){
            ans++;
            int n = list.size();
            for(int i = 0; i < n; i++){
                int cur = list.pollFirst();


                for (int j = 0; j < len; j++) {
                    int tmp;
                    tmp = cur + nums[j];
                    if(tmp == goal){
                        return ans;
                    }else if(tmp >= 0 && tmp <= 1000 && !visited[tmp]){
                        list.addLast(tmp);
                        visited[tmp] = true;
                    }

                    tmp = cur - nums[j];
                    if(tmp == goal){
                        return ans;
                    }else if(tmp >= 0 && tmp <= 1000 && !visited[tmp]){
                        list.addLast(tmp);
                        visited[tmp] = true;
                    }

                    tmp = cur ^ nums[j];
                    if(tmp == goal){
                        return ans;
                    }else if(tmp >= 0 && tmp <= 1000 && !visited[tmp]){
                        list.addLast(tmp);
                        visited[tmp] = true;
                    }
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}