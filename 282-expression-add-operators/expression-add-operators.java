class Solution {
    List<Character> ops = List.of('+', '-', '*');
    long evaluate(String expression) {
        var st = new Stack<Long>();
        long ans = 0;
        // System.out.println(expression);
        for(int i=0; i<expression.length(); i++) {
            
            var curr = new StringBuilder();
            while(i < expression.length() && !ops.contains(expression.charAt(i))) {
                curr.append(expression.charAt(i));
                i++;
            }
            if(curr.length() != 0) {
                if(curr.charAt(0) == '0' && curr.length() > 1) return Integer.MAX_VALUE+1;
                st.push(Long.parseLong(curr.toString()));
            }
            if(i == expression.length()) break;
            char op = expression.charAt(i);
            if(op == '*') {
                // st.push(st.pop() * num);
                i++;
                curr = new StringBuilder();
                while(i < expression.length() && !ops.contains(expression.charAt(i))) {
                    curr.append(expression.charAt(i));
                    i++;
                }
                if(curr.charAt(0) == '0' && curr.length() > 1) return Integer.MAX_VALUE+1;
                var next = Long.parseLong(curr.toString());
                st.push(st.pop() * next);
                i--;
            }
            else if(op == '-') {
                // st.push(-1 * num);
                i++;
                curr = new StringBuilder();
                while(i < expression.length() && !ops.contains(expression.charAt(i))) {
                    curr.append(expression.charAt(i));
                    i++;
                }
                if(curr.charAt(0) == '0' && curr.length() > 1) return Integer.MAX_VALUE+1;
                var next = Long.parseLong(curr.toString());
                st.push(-1 * next);
                i--;
            }
            // else st.push(num);
        }
        if(st.isEmpty()) return Integer.MAX_VALUE+1;
        while(!st.isEmpty()) ans += st.pop();
        // System.out.println(ans);
        return ans;
    }
    void backtrack(String num, int target, int idx, List<String> ans, StringBuilder curr, boolean appChar) {
        if(idx == num.length()) {
            // System.out.println(curr);
            long res = evaluate(curr.toString());
            if(res == target) ans.add(curr.toString());
            return;
        }
        else {
            
            if(appChar) {
                for(var op : ops) {
                    curr.append(op);
                    backtrack(num, target, idx, ans, curr, false);
                    curr.deleteCharAt(curr.length()-1);
                }
            }
            curr.append(num.charAt(idx));
            backtrack(num, target, idx+1, ans, curr, true);
            curr.deleteCharAt(curr.length()-1);
        }
    }
    public List<String> addOperators(String num, int target) {
        var ans = new ArrayList<String>();
        var sb = new StringBuilder();
        backtrack(num, target, 0, ans, sb, false);
        return ans;
    }
}