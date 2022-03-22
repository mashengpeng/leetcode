package editor.cn;


public class RangeSumQueryImmutable{
    public static void main(String[] args) {
        //Solution solution = new RangeSumQueryImmutable().new Solution();
        //Solution solution = new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    int[] preSum;
    int[] nums;
    public NumArray(int[] nums) {
        preSum = new int[nums.length];
        this.nums = nums;
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right] - preSum[left] + nums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
}