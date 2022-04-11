package editor.cn;


import java.util.Random;

public class SortAnArray{
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();

//        for (int i = 0; i < 100; i++) {
//            System.out.println(solution.randomIndex(4,7));
//        }
        for(int n : solution.sortArray(new int[]{5,2,3,1,234,231,54,6543,21234512,65,341,234,64})){
            System.out.println(n);
        };
    }
    
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] nums;
    public int[] sortArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        quickSort(0, n - 1);
        return this.nums;
    }

    void quickSort(int left, int right){
        if(left >= right){//关键
            return;
        }
        int idx = new Random().nextInt(right - left + 1) + left;
        int pivot = nums[idx];
        swap(idx, left);

        int i = left + 1;//关键
        int j = right;
        while(i < j){
            while(i < j && nums[j] > pivot){//关键
                j--;
            }
            while(i < j && nums[i] <= pivot){//关键
                i++;
            }
            if(i < j){
                swap(i, j);
            }
        }
        swap(left, i);
        quickSort(left, i - 1);
        quickSort(i + 1, right);
    }

    void swap(int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}