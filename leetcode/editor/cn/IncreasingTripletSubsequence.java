package editor.cn;


public class IncreasingTripletSubsequence{
    public static void main(String[] args) {
        Solution solution = new IncreasingTripletSubsequence().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for(int n : nums){
            if(n <= a){
                a = n;
            }else if(n <= b){
                b = n;
            }else{
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}