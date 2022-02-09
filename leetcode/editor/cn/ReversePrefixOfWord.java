package editor.cn;


public class ReversePrefixOfWord{
    public static void main(String[] args) {
        Solution solution = new ReversePrefixOfWord().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reversePrefix(String word, char ch) {
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == ch){
                return new StringBuilder(word.substring(0, i + 1)).reverse().append(word.substring(i + 1)).toString();
            }
        }
        return word;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}