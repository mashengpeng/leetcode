package editor.cn;


public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.winnerOfGame("ABBBBBBBAAA"));
    }
}
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean winnerOfGame(String colors) {
        int a = 0;
        int b = 0;
        int x = 0;
        int y = 0;
        int n = colors.length();
        char[] cs = colors.toCharArray();
        for (int i = 0; i < n; i++) {
            if(cs[i] == 'A'){
                x++;
                y = 0;
                if(x > 2){
                    a++;
                }
            }else{
                y++;
                x = 0;
                if(y > 2){
                    b++;
                }
            }
        }
        return a > b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


