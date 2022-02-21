package editor.cn;


public class SuperPow{
    public static void main(String[] args) {
        Solution solution = new SuperPow().new Solution();
        System.out.println(solution.qpow(2,11));
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int mod = 1337;
    public int superPow(int a, int[] b) {
        int n = b.length;
        a %= mod;
        return dfs(a, b, n);
    }

    int dfs(int a, int[] b, int n){
        if(n == 1){
            return qpow(a, b[0]);
        }
        int tmp = qpow(a, b[n-1]) ;
        int x = qpow(dfs(a, b, n - 1), 10);
        return (x * tmp) % mod;
    }

    int qpow(int a, int b){
        int ans = 1;
        while(b != 0){
            if((b & 1) == 0){
                a = a * a % mod;
                b >>= 1;
            }else{
                b--;
                ans = ans * a % mod;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}