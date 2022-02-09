package editor.cn;

import java.util.*;
import java.util.stream.Collectors;


public class FourSjJUc{
    public static void main(String[] args) {
        Solution solution = new FourSjJUc().new Solution();
        int[] candidates = {2,5,2,1,2};
        System.out.println(solution.combinationSum2(candidates,5));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        int[] tmp;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            tmp = candidates;
            Arrays.sort(tmp);
            dfs(0, target);
            res = res.stream().distinct().collect(Collectors.toList());
            return res;
        }

        public void dfs(int i, int target){

            if(target == 0){
                res.add(new ArrayList<>(l));
                return;
            }

            if(i == tmp.length || target < 0 ){
                return;
            }

            int x = tmp[i];

            if(x <= target){
                l.add(x);
                dfs(i + 1, target-x);
                l.remove(l.size()-1);
            }

            int j = i + 1;
            while(j < tmp.length && x == tmp[j]){
                j++;
            }
            dfs(j, target);

        }
    }

//leetcode submit region end(Prohibit modification and deletion)


}