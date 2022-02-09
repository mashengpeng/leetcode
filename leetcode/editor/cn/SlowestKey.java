package editor.cn;


public class SlowestKey{
    public static void main(String[] args) {
        Solution solution = new SlowestKey().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        char ans = keysPressed.charAt(0);
        for(int i = 1; i < releaseTimes.length; i++){
            if(releaseTimes[i] - releaseTimes[i - 1] > max){
                max = releaseTimes[i] - releaseTimes[i - 1];
                ans = keysPressed.charAt(i);
            }else if(releaseTimes[i] - releaseTimes[i - 1] == max && keysPressed.charAt(i) > ans){
                ans = keysPressed.charAt(i);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}