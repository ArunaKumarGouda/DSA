class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;
        
        int finalCount = 0;
        int number = 0;

        for(int i = 0; i < n; i++) {
            number = nums[i];

            int count = 0;

            while(number != 0) {
                count++;
                number = number / 10;
            }
            
            if(count % 2 == 0) {
                finalCount++;
            }   
        }

        return finalCount;
    }
}