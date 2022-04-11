package editor.cn;
 
import java.util.*; 


public class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> a = new ArrayList<>();
        List<List<Integer>> b = new ArrayList<>();

        a.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < a.size(); j++) {
                List<Integer> list = a.get(j);
                for (int k = 0; k <= list.size(); k++) {
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(k, nums[i]);
                    b.add(tmp);
                }
            }
            a = b;
            b = new ArrayList<>();
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
