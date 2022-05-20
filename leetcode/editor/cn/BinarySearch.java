package editor.cn;


public class BinarySearch{
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
        System.out.println(solution.searchFirstMoreThanOrEqualTarget(new int[]{5,5,5,5,5,5,5}, 5));
        System.out.println(solution.searchFirstMoreThanTarget(new int[]{5,5,5,5,5,5,5}, 5));
        System.out.println(solution.searchLastLessThanOrEqualTarget(new int[]{5,5,5,5,5,5,5}, 5));
        System.out.println(solution.searchLastLessThanTarget(new int[]{5,5,5,5,5,5,5}, 5));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) >> 1;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public int searchFirstMoreThanOrEqualTarget(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) >> 1;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public int searchFirstMoreThanTarget(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) >> 1;
            if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public int searchLastLessThanOrEqualTarget(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right + 1) >> 1;
            if(nums[mid] <= target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public int searchLastLessThanTarget(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right + 1) >> 1;
            if(nums[mid] < target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
