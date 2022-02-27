package editor.cn;


import java.util.ArrayList;

public class BuddyStrings{
    public static void main(String[] args) {
        Solution solution = new BuddyStrings().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        boolean flag = false;
        int[] cnt = new int[26];

        int n = s.length();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(!flag){
                cnt[s.charAt(i) - 'a']++;
                if(cnt[s.charAt(i) - 'a'] > 1){
                    flag = true;
                }
            }
            if(s.charAt(i) != goal.charAt(i)){
                list.add(i);
                if(list.size() > 2){
                    return false;
                }
            }
        }
        if(list.size() == 0){
            return flag;
        }
        if(list.size() != 2){
            return false;
        }
        int i = list.get(0), j = list.get(1);
        return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}