package editor.cn;


import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion{
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 4));
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {

        if(numRows == 1){
            return s;
        }

        List<StringBuilder> l = new ArrayList<>(numRows);
        for(int i = 0; i < numRows; i++){
            l.add(new StringBuilder());
        }
        boolean flag = true;
        int x = 0;
        for(int i = 0; i < s.length(); i++){
            l.get(x).append(s.charAt(i));
            if(flag){
                x++;
            }else{
                x--;
            }

            if(x == 0){
                flag = true;
            }else if(x == numRows - 1){
                flag = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder v:l){
            sb.append(v.toString());
        }
        return sb.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}