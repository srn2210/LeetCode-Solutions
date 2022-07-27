class Solution {
    public boolean isValid(String s) {
        Stack st = new Stack();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                st.push(s.charAt(i));
            }
            else if(!st.empty() && s.charAt(i) == ')' && st.peek().equals('(')){
                st.pop();
            }
            else if(!st.empty() && s.charAt(i) == ']' && st.peek().equals('[')){
                st.pop();
            }
            else if(!st.empty() && s.charAt(i) == '}' && st.peek().equals('{')){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        if(st.empty()){
            return true;
        }
        else{
            return false;
        }
    }
}