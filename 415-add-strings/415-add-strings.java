class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder t1 = new StringBuilder();
        t1.append(num1).reverse();
        num1 = t1.toString();
        StringBuilder t2 = new StringBuilder();
        t2.append(num2).reverse();
        num2 = t2.toString();
        String greater = num1.length() > num2.length() ? num1 : num2;
        String lesser = num1.length() < num2.length() ? num1 : num2;
        int carry = 0;
        String res = new String();
        Stack<Character> st = new Stack();
        
        for(int i=0; i<=greater.length(); i++){
            if(i >= lesser.length()){
                if(carry != 0){
                    if( i == greater.length() && carry != 0){
                        st.push('1');
                        continue;
                    }
                    char temp = (char) (greater.charAt(i) + carry);
                    carry = 0;
                    if(temp > '9'){
                        carry = 1;
                        temp -= 10;
                    }
                    st.push(temp);
                    continue;
                }
                else {
                    if(i == greater.length()) continue;
                    st.push(greater.charAt(i));
                    continue;
                }
            }
            char temp = (char) (num1.charAt(i) - '0' + num2.charAt(i));
            temp = (char) (temp + carry);
            carry = 0;
            if(temp > '9'){
                carry = 1;
                temp -= 10;
            }
            st.push(temp);
        }
        
        while(!st.isEmpty())res += st.pop();
        
        return res;
    }
}