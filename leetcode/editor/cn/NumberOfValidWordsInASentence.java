package editor.cn;


public class NumberOfValidWordsInASentence{
    public static void main(String[] args) {
        Solution solution = new NumberOfValidWordsInASentence().new Solution();
        System.out.println(solution.countValidWords(" o6 t"));
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countValidWords(String sentence) {
        //sentence = sentence.trim();
        int ans = 0;
        for(String s : sentence.split("\\s")){
            if(s.length() != 0 && s.matches("[a-z]*([a-z]-[a-z])?[a-z]*[!,.]?")){
                ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}