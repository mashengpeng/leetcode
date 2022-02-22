package editor.cn;


public class ReplaceAllSToAvoidConsecutiveRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new ReplaceAllSToAvoidConsecutiveRepeatingCharacters().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String modifyString(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(cs[i] == '?'){
                char c = 'a';
                if(i - 1 >= 0 && cs[i - 1] == c){
                    c++;
                }
                if(i + 1 < n && cs[i + 1] == c){
                    c++;
                }
                if(i - 1 >= 0 && cs[i - 1] == c){
                    c++;
                }
                cs[i] = c;
            }
        }
        return String.valueOf(cs);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}