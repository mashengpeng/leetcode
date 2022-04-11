package editor.cn;


public class NextPermutation{
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        solution.nextPermutation(new int[]{2,2,7,5,4,3,2,2,1});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i;
        for (i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]){
                break;
            }
        }
        if (i == 0) {
            int left = 0, right = n - 1;
            while (left < right) {
                swap(nums, left++, right--);
            }
            return;
        }

        int left = i, right = n - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }

        int index = search(nums, i, n - 1, nums[i - 1]);
        swap(nums, index, i - 1);

        sort(nums, i, n - 1);
    }

    void sort(int[] nums, int left, int right){
        for (int i = left + 1; i <= right; i++) {
            int cur = i;
            while(cur > left && nums[cur - 1] > nums[cur]){
                swap(nums, cur - 1, cur);
                cur--;
            }
        }
    }


    int search(int[] nums, int left, int right, int target){
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }


    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
