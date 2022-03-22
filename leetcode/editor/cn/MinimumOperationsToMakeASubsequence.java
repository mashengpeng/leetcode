package editor.cn;
 
import java.util.*; 


public class MinimumOperationsToMakeASubsequence{
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToMakeASubsequence().new Solution();
        System.out.println(solution.minOperations(new int[]{16,7,20,11,15,13,10,14,6,8},
                new int[]{11,14,15,7,5,5,6,10,11,6}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if(map.containsKey(cur)){
                list.add(map.get(cur));

            }
        }

        int[] dp = new int[list.size()+1];
        dp[0] = -1;
        int len = 0;
        for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i);
            if(cur > dp[len]){
                dp[++len] = cur;
                continue;
            }

//            int left = 0, right = len;
//            while(left < right){
//                int mid = (left + right) / 2;
//                if(dp[mid] == cur){
//                    left = mid;
//                    break;
//                }else if(dp[mid] > cur){
//                    right = mid;
//                }else{
//                    left = mid + 1;
//                }
//            }

            int pos = Arrays.binarySearch(dp, 0, len + 1, cur);
            if(pos > 0){
                dp[pos] = cur;
            }else{
                dp[-pos-1] = cur;
            }

        }
        return target.length - len;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
