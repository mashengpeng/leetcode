package editor.cn;
 
import java.util.*; 


public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[]{0, 0, 0, 0}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }

            int target = -nums[i];

            if(target < 0){
                break;
            }

            int l = i + 1, r = n - 1;

            while(l < r){
                if(nums[l] + nums[r] > target){
                    do{
                        r--;
                    } while(l < r && nums[r + 1] == nums[r]);
                    continue;
                }
                if(nums[l] + nums[r] < target){
                    do{
                        l++;
                    } while(l < r && nums[l - 1] == nums[l]);
                    continue;
                }
                if(nums[l] + nums[r] == target){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    do{
                        r--;
                    } while(l < r && nums[r + 1] == nums[r]);
                    do{
                        l++;
                    } while(l < r && nums[l - 1] == nums[l]);
                }

            }
        }
        return ans;
    }
    String object;
}
//leetcode submit region end(Prohibit modification and deletion)

}


