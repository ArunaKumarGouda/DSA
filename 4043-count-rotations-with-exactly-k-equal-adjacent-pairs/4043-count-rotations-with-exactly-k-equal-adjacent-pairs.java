class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        int count = 0;

        for (int start = 0; start < n; start++) {

            String rotation = s.substring(start) + s.substring(0, start);

            int score = 0;

            for (int i = 0; i < n - 1; i++) {

                if (rotation.charAt(i) == rotation.charAt(i + 1)) {
                    score++;
                }
            }

            if (score == k) {
                count++;
            }
        }

        return count;
    }
}