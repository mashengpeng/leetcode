package editor.cn;
 
import java.util.*; 


public class TagValidator{
    public static void main(String[] args) {
        Solution solution = new TagValidator().new Solution();
        System.out.println(solution.isValid("<"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String code) {
        LinkedList<String> stack = new LinkedList<>();

        int n = code.length();
        String cdata1 = "<![CDATA[";
        String cdata2 = "]]>";
        int i = 0;
        while(i < n) {
            if(i + 8 < n && code.substring(i, i + 9).equals(cdata1)){
                if(i == 0){
                    return false;
                }
                if(stack.isEmpty()){
                    return false;
                }
                int j = i+9;
                while(j+2 < n && !code.substring(j, j+3).equals(cdata2)){
                    j++;
                }
                if(j+2 == n){
                    return false;
                }else{
                    i = j + 3;
                }
            }else if(code.charAt(i) == '<'){
                if(i == n - 1){
                    return false;
                }
                if(code.charAt(i+1) == '/'){
                    if(stack.isEmpty()){
                        return false;
                    }
                    int j = i + 2;
                    while(j < n && code.charAt(j) != '>'){
                        if(!Character.isUpperCase(code.charAt(j))){
                            return false;
                        }
                        j++;
                    }
                    if(j == n){
                        return false;
                    }
                    int len = j - i - 2;
                    if(len < 1 || len > 9){
                        return false;
                    }
                    String cur = code.substring(i+2, j);
                    if(!stack.getLast().equals(cur)){
                        return false;
                    }else{
                        stack.removeLast();
                    }
                    i = j + 1;
                }else{
                    int j = i + 1;
                    while(j < n && code.charAt(j) != '>'){
                        if(!Character.isUpperCase(code.charAt(j))){
                            return false;
                        }
                        j++;
                    }
                    if(j == n){
                        return false;
                    }
                    int len = j - i - 1;
                    if(len < 1 || len > 9){
                        return false;
                    }
                    String cur = code.substring(i+1, j);
                    if(stack.isEmpty() && i != 0){
                        return false;
                    }

                    stack.addLast(cur);
                    i = j + 1;
                }
            }else{

                if(i == 0 || stack.isEmpty()){
                    return false;
                }
                i++;

            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
