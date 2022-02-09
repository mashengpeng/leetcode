package editor.cn;
 
import java.util.*; 


public class ContainsDuplicateIii{
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        System.out.println(solution.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));;

    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> ts = new TreeSet<>();

        for(int i = 0; i < nums.length; i++){
            Long ceiling = ts.ceiling((long)nums[i]-t);
            if(ceiling != null && ceiling <= (long)nums[i] + t){
                return true;
            }
            ts.add((long)nums[i]);
            if(i >= k){
                ts.remove((long)nums[i-k]);
            }
        }
        return false;
    }

    int bs(List<Integer> list, int k){
        int left = 0, right = list.size()-1;
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) == k){
                return mid;
            }else if (list.get(mid) < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}