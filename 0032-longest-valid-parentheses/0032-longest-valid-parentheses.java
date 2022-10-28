class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0 || s.length() == 1){
            return 0;
        }
        Stack<Character> st = new Stack();
        Stack st1 = new Stack();
        int count=0, count_prev=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
                st1.push(i);
            }
            else if(s.charAt(i) == ')'){
                if(!st.empty() && s.charAt(i) == ')' && st.peek() == '('){
                    st.pop();
                    st1.pop();
                }
                else{
                    st.push(s.charAt(i));
                    st1.push(i);
                }
            }            
        }
        if(st1.empty()){
            count_prev = s.length();
        }
        while(!st1.empty()){
            int temp = (int)st1.pop();
            if(count_prev == 0){
                count_prev = s.length()-temp-1;
            }
            if(!st1.empty()){
                count = temp - (int)st1.peek()-1;
                if(count > count_prev){
                    count_prev = count;
                }
            }
            else{
                count = temp;
                if(count>count_prev){
                    count_prev = count;
                }
            }
        }
        if(count_prev == 1){
            return 0;
        }
        return count_prev;
    }
}