class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;

        int ans = 0;
        int count = 0;
        int count_ans = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                ans++;
                count = ans;
            }

            if(nums[i] == 0) {
                ans = 0;
            }
            if(ans > count) {
                count = ans;
            }

            if(count > count_ans) {
                count_ans = count;
            }
        }
        return count_ans;
    }
}