package editor.cn;


public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK{
    public static void main(String[] args) {
        Solution solution = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinFibonacciNumbers(int k) {
        int[] f = new int[45];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i < f.length; i++){
            f[i] = f[i-1] + f[i-2];
        }
        int ans = 0;
        for(int i = f.length - 1; i >= 0; i--){


            if(k >= f[i]){
                ans += k / f[i];
                k %= f[i];

                if(k == 0){
                    break;
                }
            }


        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}