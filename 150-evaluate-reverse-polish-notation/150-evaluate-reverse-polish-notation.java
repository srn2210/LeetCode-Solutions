class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1) return Integer.valueOf(tokens[0]);
        
        Stack<Integer> st = new Stack();
        int temp = 0;
        
        for(String s:tokens) {
            switch(s) {
                case "+": 
                    temp = st.pop();
                    temp += st.pop();
                    st.push(temp);
                    break;
                case "-":
                    temp = st.pop();
                    temp = st.pop() - temp;
                    st.push(temp);
                    break;
                case "*":
                    temp = st.pop();
                    temp *= st.pop();
                    st.push(temp);
                    break;
                case "/":
                    temp = st.pop();
                    temp = st.pop() / temp;
                    st.push(temp);
                    break;
                default:
                    st.push(Integer.valueOf(s));
                    break;
            }
        }
        
        return st.pop();
    }
}