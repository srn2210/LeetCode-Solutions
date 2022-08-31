class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 1) return Integer.valueOf(tokens[0]);
        
        Stack<Integer> st = new Stack();
        int temp;
        
        for(String s:tokens) {
            switch(s) {
                case "+": 
                    temp = st.pop();
                    st.push(temp + st.pop());
                    break;
                case "-":
                    temp = st.pop();
                    st.push(st.pop() - temp);
                    break;
                case "*":
                    temp = st.pop();
                    st.push(temp * st.pop());
                    break;
                case "/":
                    temp = st.pop();
                    st.push(st.pop() / temp);
                    break;
                default:
                    st.push(Integer.valueOf(s));
                    break;
            }
        }
        
        return st.pop();
    }
}