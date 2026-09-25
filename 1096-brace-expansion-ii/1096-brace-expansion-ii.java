class Solution {

    int index = 0;

    public List<String> braceExpansionII(String expression) {

        Set<String> result = parse(expression);

        List<String> answer = new ArrayList<>(result);

        Collections.sort(answer);

        return answer;
    }

    private Set<String> parse(String expression) {

        Set<String> result = new HashSet<>();

        while (index < expression.length()
                && expression.charAt(index) != '}'
                && expression.charAt(index) != ',') {

            Set<String> current;

            char ch = expression.charAt(index);

            // Case 1: Letter
            if (Character.isLetter(ch)) {

                current = new HashSet<>();

                current.add(String.valueOf(ch));

                index++;
            }

            // Case 2: Braces
            else {

                index++; // skip '{'

                current = parse(expression);

                index++; // skip '}'
            }

            // Concatenate current with result
            if (result.isEmpty()) {

                result = current;

            } else {

                Set<String> combined = new HashSet<>();

                for (String a : result) {

                    for (String b : current) {

                        combined.add(a + b);
                    }
                }

                result = combined;
            }
        }

        // Handle comma-separated union
        while (index < expression.length()
                && expression.charAt(index) == ',') {

            index++; // skip ','

            Set<String> next = parse(expression);

            result.addAll(next);
        }

        return result;
    }
}