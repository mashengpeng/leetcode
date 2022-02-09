package editor.cn;
 
import java.util.*; 


public class UncommonWordsFromTwoSentences{
    public static void main(String[] args) {
        Solution solution = new UncommonWordsFromTwoSentences().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> m = new HashMap<>();
        for(String s : s1.split(" ")){
            m.put(s, m.getOrDefault(s, 0) + 1);
        }
        for(String s : s2.split(" ")){
            m.put(s, m.getOrDefault(s, 0) + 1);
        }

        return m.entrySet().stream().filter(x->x.getValue() == 1).map(Map.Entry::getKey).toArray(String[]::new);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}