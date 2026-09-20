class Solution {
    public int reverseDegree(String s) {
        int ans = 0;

        for(int i = 0; i < s.length(); i++) {
            int alphabetIndex = 'z' - s.charAt(i) + 1;
            int index = i + 1;
            ans += alphabetIndex * index;
        }

        return ans;
    }
}