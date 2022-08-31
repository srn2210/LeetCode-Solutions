class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1) return Integer.valueOf(tokens[0]);
        
        Stack<Integer> st = new Stack();
        
        for(String s:tokens) {
            if(s.equals("+")) {
                int temp = st.pop();
                temp += st.pop();
                st.push(temp);
            }
            else if(s.equals("-")) {
                int temp = st.pop();
                temp = st.pop() - temp;
                st.push(temp);
            }
            else if(s.equals("*")) {
                int temp = st.pop();
                temp *= st.pop();
                st.push(temp);
            }
            else if(s.equals("/")) {
                int temp = st.pop();
                temp = st.pop() / temp;
                st.push(temp);
            }
            else {
                st.push(Integer.valueOf(s));
            }
        }
        
        return st.pop();
    }
}