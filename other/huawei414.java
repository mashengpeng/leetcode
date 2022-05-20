public class huawei414 {

    public static void main(String[] args) {
        System.out.println(fun(new int[]{1, 1, 1, 1, 1, 1, 1}, 3));
        System.out.println(fun(new int[]{1, 4, 1, 1, 1, 1, 1}, 5));
        System.out.println(fun(new int[]{1, 2, 3, 10, 4, 7}, 10));
        System.out.println(fun(new int[]{0,0,0,0,0,0,0}, 5));
        System.out.println(fun(new int[]{5,4,3,2,1}, 6));

    }

    public static int fun(int[] nums, int target){
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int i = 0, j = 0;
        int cur = 0;
        while(i < n && j < n){
            while(j < n && cur < target){
                cur += nums[j++];
            }
            if(cur >= target){
                ans = Math.min(ans, j - i + 1);
            }
            while(i <= j && cur >= target){
                cur -= nums[i++];
                ans = Math.min(ans, j - i + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
