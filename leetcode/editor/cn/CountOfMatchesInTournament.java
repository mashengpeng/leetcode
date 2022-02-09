package editor.cn;


public class CountOfMatchesInTournament{
    public static void main(String[] args) {
        Solution solution = new CountOfMatchesInTournament().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfMatches(int n) {
        int res = 0;
        while(n != 1){
            res += n/2;
            if(n % 2 == 0){

                n /= 2;
            }else{

                n = n / 2 + 1;
            }

        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}