class Solution {
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;
        
        int[] newArray = new int[len];

        int newN = n;
        int num = 0;

        for(int i = 0; i < len; i++) {
            if(i % 2 == 0) {
                newArray[i] = nums[num];
                num++;
            }
            else {
                newArray[i] = nums[newN];
                newN++;
            }
        }
        return newArray;
    }
}