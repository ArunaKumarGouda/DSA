class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;

        int[] newSum = new int[n];

        int sum = 0;
        int i = 0;
        while(i < n) {
            sum += nums[i];
            newSum[i] = sum;
            i++;
        }
        return newSum;
    }
}