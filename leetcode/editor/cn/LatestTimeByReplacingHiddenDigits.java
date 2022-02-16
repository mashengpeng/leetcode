package editor.cn;


public class LatestTimeByReplacingHiddenDigits{
    public static void main(String[] args) {
        Solution solution = new LatestTimeByReplacingHiddenDigits().new Solution();
        System.out.println(solution.maximumTime("?4:03"));
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String maximumTime(String time) {


        StringBuilder sb = new StringBuilder();

        sb.append(time.charAt(0) == '?' ? (time.charAt(1) < '4' || time.charAt(1) == '?' ? '2' : '1') : time.charAt(0));
        sb.append(time.charAt(1) == '?' ? (time.charAt(0) == '?' || time.charAt(0) == '2' ? '3' : '9') : time.charAt(1));
        sb.append(':');
        sb.append(time.charAt(3) == '?' ? '5' : time.charAt(3));
        sb.append(time.charAt(4) == '?' ? '9' : time.charAt(4));

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}