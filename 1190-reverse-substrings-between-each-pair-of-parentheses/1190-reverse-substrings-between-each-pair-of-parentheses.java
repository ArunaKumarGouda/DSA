class Solution {
    public String reverseParentheses(String s) {
        
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Save current string
                stack.push(current.toString());
                
                // Start a new string
                current = new StringBuilder();
            } 
            
            else if (ch == ')') {
                // Reverse current substring
                current.reverse();

                // Get previous string
                String previous = stack.pop();

                // Attach reversed string
                current = new StringBuilder(previous + current);
            } 
            
            else {
                // Add normal character
                current.append(ch);
            }
        }

        return current.toString();
    }
}