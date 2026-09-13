import java.util.Arrays;

class Solution {
    public int thirdMax(int[] nums) {
         Arrays.sort(nums);

        int count = 1;
        int n = nums.length;
        int max = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            if (nums[i] != max) {
                count++;
                max = nums[i];
            }

            if (count == 3) {
                return max;
            }
        }

        return nums[n - 1];
    }
}