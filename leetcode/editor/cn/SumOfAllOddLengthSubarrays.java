package editor.cn;


public class SumOfAllOddLengthSubarrays{
    public static void main(String[] args) {
        Solution solution = new SumOfAllOddLengthSubarrays().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int leftCount = i, rightCount = n - i - 1;
            int leftOdd = (leftCount + 1) / 2;
            int rightOdd = (rightCount + 1) / 2;
            int leftEven = leftCount / 2 + 1;
            int rightEven = rightCount / 2 + 1;
            sum += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return sum;
    }
}


//class Solution {
//    public int sumOddLengthSubarrays(int[] arr) {
//        int n = arr.length;
//        for(int i = 1; i < n; i++){
//            arr[i] += arr[i-1];
//        }
//        int ans = 0;
//        for(int i = 1; i <= n; i+=2){
//            for(int j = 0; j + i <= n; j++){
//                if(j == 0){
//                    ans = ans + arr[j + i - 1];
//                }else{
//                    ans = ans + arr[j + i - 1] - arr[j - 1];
//                }
//
//            }
//        }
//        return ans;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)


}