class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        List<String> ans = new ArrayList<>();

        int[] first = new int[26];
        int[] last = new int[26];

        // Find first and last position of each character
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
            last[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (first[index] == -1) {
                first[index] = i;
            }

            last[index] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < 26; i++) {

            if (first[i] == -1) {
                continue;
            }

            int start = first[i];
            int end = last[i];

            boolean valid = true;

            for (int j = start; j <= end; j++) {
                int index = s.charAt(j) - 'a';

                if (first[index] < start) {
                    valid = false;
                    break;
                }

                end = Math.max(end, last[index]);
            }

            if (valid) {
                intervals.add(new int[]{start, end});
            }
        }

        intervals.sort((a, b) -> a[1] - b[1]);

        int previousEnd = -1;

        for (int[] interval : intervals) {

            if (interval[0] > previousEnd) {
                ans.add(s.substring(interval[0], interval[1] + 1));
                previousEnd = interval[1];
            }
        }

        return ans;
    }
}