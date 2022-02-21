package editor.cn;
 
import java.util.*; 


public class PushDominoes{
    public static void main(String[] args) {
        Solution solution = new PushDominoes().new Solution();
        System.out.println(solution.pushDominoes("..L.L"));
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String pushDominoes(String dominoes) {
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        char[] cs = dominoes.toCharArray();
        int n = dominoes.length();
        for(int i = 0; i < n; i++){
            if(dominoes.charAt(i) == 'L' && i > 0 && dominoes.charAt(i - 1) == '.'){
                left.addLast(i - 1);
            }else if(dominoes.charAt(i) == 'R' && i < n - 1 && dominoes.charAt(i + 1) == '.'){
                right.addLast(i + 1);
            }
        }
        while(!left.isEmpty() || !right.isEmpty()){
            int len = left.size();
            for(int i = 0; i < len; i++){
                int cur = left.pollFirst();
                if(cs[cur] != 'R'){
                    cs[cur] = 'L';
                }
                if(cur - 1 >= 0 && cs[cur - 1] == '.'){
                    left.addLast(cur - 1);
                }

            }

            len = right.size();
            for(int i = 0; i < len; i++){
                int cur = right.pollFirst();
                if(cs[cur] == 'L'){
                    cs[cur] = '.';
                }else{
                    cs[cur] = 'R';
                }
                if(cur + 1 < n && cs[cur + 1] == '.'){
                    right.addLast(cur + 1);
                }

            }
        }

        return String.valueOf(cs);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}