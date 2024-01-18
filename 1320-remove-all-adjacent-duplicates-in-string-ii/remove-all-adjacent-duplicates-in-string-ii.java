class Solution {
    public String removeDuplicates(String s, int k) {
        var st = new ArrayDeque<Pair<Character, Integer>>();
        for(var curr : s.toCharArray()) {
            if(!st.isEmpty() && curr == st.peek().getKey()) {
                int count = st.pop().getValue();
                if(count+1 != k) st.push(new Pair(curr, count+1));
            }
            else st.push(new Pair(curr, 1));
        }
        var ans = new StringBuilder();
        int count = 0;
        char ch = 'A';
        while(!st.isEmpty()) {
            ch = st.peek().getKey();
            count = st.pop().getValue();
            while(count-- > 0) {
                ans.append(ch);
            }
        }
        return ans.reverse().toString();
    }
}