package editor.cn;
 
import java.util.*; 


public class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> a = new ArrayList<>();
        List<List<Integer>> b = new ArrayList<>();

        a.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < a.size(); j++) {
                List<Integer> list = a.get(j);
                for (int k = 0; k <= list.size(); k++) {
                    if(k < list.size() && list.get(k) == nums[i]){
                        continue;
                    }
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
    int hash(List<Integer> list){
        int hash = 0;
        for (int i = 0; i < list.size(); i++) {
            hash |= (list.get(i) & 0xf) << (4 * i);
        }
        return hash;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
