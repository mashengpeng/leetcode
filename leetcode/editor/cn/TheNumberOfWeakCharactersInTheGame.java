package editor.cn;
 
import java.util.*; 


public class TheNumberOfWeakCharactersInTheGame{
    public static void main(String[] args) {
        Solution solution = new TheNumberOfWeakCharactersInTheGame().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int ans = 0;
        Arrays.sort(properties, (o1, o2)-> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        int a = Integer.MAX_VALUE, b = 0, c = 0;
        //b是当前攻击力的最高防御力，c是更高攻击力的最高防御力。

        for(int i = 0; i < properties.length; i++){
            int x = properties[i][0], y = properties[i][1];
            if(x == a){
                b = Math.max(b, y);
                if(y < c){
                    ans++;
                }
                continue;
            }

            a = x;
            c = Math.max(c, b);
            b = y;

            if(y < c){
                ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}