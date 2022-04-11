package editor.cn;


import java.util.Deque;
import java.util.LinkedList;

public class ReverseSubstringsBetweenEachPairOfParentheses{
    public static void main(String[] args) {
        Solution solution = new ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
        System.out.println(solution.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    char[] cs;
    public String reverseParentheses(String s) {
//        cs = s.toCharArray();
//        int n = s.length();
//
//        LinkedList<Character> list = new LinkedList<>();
//        LinkedList<Character> tmp = new LinkedList<>();
//        StringBuilder sb = new StringBuilder();
//        for (char c : cs) {
//            if(list.size() == 0 && c != '('){
//                sb.append(c);
//            }
//            if((list.size() != 0 || c == '(') && c != ')'){
//                list.addLast(c);
//            }
//            if(c == ')'){
//                while(list.getLast() != '('){
//                    tmp.addLast(list.pollLast());
//                }
//                list.pollLast();
//                while(!tmp.isEmpty()){
//                    if(list.isEmpty()){
//                        sb.append(tmp.pollFirst());
//                    }else{
//                        list.addLast(tmp.pollFirst());
//                    }
//                }
//            }
//        }
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int[] jump = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else if(s.charAt(i) == ')'){
                int j = stack.pop();
                jump[i] = j;
                jump[j] = i;
            }
        }

        int i = 0, step = 1;
        while(i < n){

            char c = s.charAt(i);
            if(c != '(' && c != ')'){
                sb.append(c);
            }else{
                i = jump[i];
                step = -step;
            }
            i += step;
        }

        return sb.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}