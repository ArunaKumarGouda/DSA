class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];

        int duplicate = 0;
        int original = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] == nums[j]) {
                    duplicate = nums[i];
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            boolean found = false;
            for(int j = 0; j < n; j++) {
                if(nums[j] == i) {
                    found = true;
                    break;
                }
            }

            if(found == false) {
                original = i;
            }
        }
        ans[0] = duplicate;
        ans[1] = original;
        return ans;
    }
}