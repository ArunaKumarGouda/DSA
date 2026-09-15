class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;

        int number = 0;
        for(int i = 0; i < n; i++) {
            number ^= nums[i];
        }

        return number;
    }
}