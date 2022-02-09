package editor.cn;
 
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class FindKPairsWithSmallestSums{
    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    boolean flag = true;
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        if(nums1.length > nums2.length){
            flag = false;
            return kSmallestPairs(nums2, nums1, k);
        }
        List<List<Integer>> ans = new ArrayList<>();

        PriorityQueue<int[]> p =
                new PriorityQueue<>((a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);

        for(int i = 0; i < nums1.length; i++){
            p.add(new int[]{i, 0});
        }

        for(int i = 0; i < k; i++){
            if(p.isEmpty()){
                break;
            }
            int[] tmp = p.poll();

            ans.add(new ArrayList<Integer>(){{
                add(flag ? nums1[tmp[0]] : nums2[tmp[1]]);
                add(flag ? nums2[tmp[1]] : nums1[tmp[0]]);
            }
            });

            if(tmp[1] + 1 < nums2.length){
                p.add(new int[]{tmp[0], tmp[1] + 1});
            }

        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}