package editor.cn;


public class IntegerToRoman{
    public static void main(String[] args) {
        Solution solution = new IntegerToRoman().new Solution();
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        if(num >= 1000){
            int a = num / 1000;
            while (a > 0){
                sb.append("M");
                a--;
            }
            num %= 1000;
        }


        if(num >= 900){
            sb.append("CM");
            num -= 900;
        }

        if(num >= 500){
            sb.append("D");
            num -= 500;
        }

        if(num >= 400){
            sb.append("CD");
            num -= 400;
        }

        if(num >= 100){
            int a = num / 100;
            while (a > 0){
                sb.append("C");
                a--;
            }
            num %= 100;
        }

        if(num >= 90){
            sb.append("XC");
            num -= 90;
        }

        if(num >= 50){
            sb.append("L");
            num -= 50;
        }

        if(num >= 40){
            sb.append("XL");
            num -= 40;
        }

        if(num >= 10){
            int a = num / 10;
            while (a > 0){
                sb.append("X");
                a--;
            }
            num %= 10;
        }

        if(num >= 9){
            sb.append("IX");
            num -= 9;
        }

        if(num >= 5){
            sb.append("V");
            num -= 5;
        }

        if(num >= 4){
            sb.append("IV");
            num -= 4;
        }

        if(num >= 1){
            int a = num / 1;
            while (a > 0){
                sb.append("I");
                a--;
            }
            num %= 1;
        }


        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}