package editor.cn;
 
import java.util.*;


public class JumpGameIv{
    public static void main(String[] args) {
        Solution solution = new JumpGameIv().new Solution();
        System.out.println(solution.minJumps(new int[]{11,22,7,7,7,7,7,7,7,22,13}));
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minJumps(int[] arr) {
        int res = 0;
        boolean[] flag = new boolean[arr.length];
        Arrays.fill(flag, false);
        flag[0] = true;
        HashMap<Integer, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            if(m.containsKey(arr[i])){
                m.get(arr[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                m.put(arr[i], list);
            }
        }

        LinkedList<Integer> list = new LinkedList<>();

        list.add(0);
        int l;
        while (true){
            l = list.size();
            for (int i = 0; i < l; i++){
                int cur = list.get(0);
//                System.out.println(cur);
                list.poll();

                if (cur == arr.length - 1){
                    return res;
                }

//                if(flag[cur]){
//                    continue;
//                }

                if(cur - 1 >= 0 && !flag[cur - 1]){
                    flag[cur - 1] = true;
                    list.add(cur - 1);
                }
                if(cur + 1 < arr.length && !flag[cur + 1]){
                    flag[cur + 1] = true;
                    list.add(cur + 1);
                }
                for(int x : m.get(arr[cur])){
                    if(!flag[x]){
                        flag[x] = true;
                        list.add(x);
                    }
                }
                m.get(arr[cur]).clear();
            }
            res++;

        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)


}