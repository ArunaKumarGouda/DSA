class Solution {
    public int dominantIndex(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        for(int i = 0; i < n; i++) {
            if(i != index) {
                int twice = nums[i] * 2;
                if(twice > max) {
                    return -1;
                }
            }
        }
        return index;
    }
}