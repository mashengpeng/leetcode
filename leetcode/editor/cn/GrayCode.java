package editor.cn;
 
import java.util.ArrayList;
import java.util.List;


public class GrayCode{
    public static void main(String[] args) {
        Solution solution = new GrayCode().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for(int i = 0; i < n; i++){
            int len = ans.size();
            int off = 1 << i;
            for(int j = len - 1; j >= 0; j--){
                ans.add(ans.get(j) + off);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}