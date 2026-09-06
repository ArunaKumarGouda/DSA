class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;

        int[] newSum = new int[n];

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum = sum + nums[i];
            newSum[i] = sum;
        }
        return newSum;
    }
}