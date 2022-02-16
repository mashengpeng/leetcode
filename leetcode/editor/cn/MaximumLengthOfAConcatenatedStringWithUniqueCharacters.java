package editor.cn;
 
import java.util.*; 


public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters{
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfAConcatenatedStringWithUniqueCharacters().new Solution();
        System.out.println(solution.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int ans = 0;
    List<Integer> list = new ArrayList<>();

    public int maxLength(List<String> arr) {
        Set<Integer> set = new HashSet<>();
        for(String s : arr){
            int n = s.length();
            int mask = 0;
            boolean flag = true;
            for(int i = 0; i < n; i++){
                int tmp = 1 << (s.charAt(i)-'a');
                if((mask & tmp) == 0){
                    mask |= tmp;
                }else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                set.add(mask);
            }
        }
        list.addAll(set);

        dfs(0, 0);
        return ans;
    }

    void dfs(int pos, int state){
        ans = Math.max(ans, cal(state));
        if(pos == list.size()){
            return;
        }
        int cur = list.get(pos);
        if((state & cur) == 0){
            int tmp = state;
            state |= cur;
            dfs(pos+1, state);
            dfs(pos+1, tmp);
        }else{
            dfs(pos+1, state);
        }
    }

    int cal(int x){
        int res = 0;
        while(x != 0){
            x -= (x & (-x));
            res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}