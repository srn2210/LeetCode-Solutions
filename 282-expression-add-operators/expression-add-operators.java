class Solution {
    void backtrack(String num, int target, int idx, List<String> ans, String curr, long sum, long last) {
        if(idx == num.length()) {
            if(sum == target) ans.add(curr);
            return;
        }
        else {
            for(int i=idx; i<num.length(); i++) {
                var number = Long.parseLong(num.substring(idx, i+1));
                if(i-idx+1 > 1 && num.charAt(idx) == '0') break;
                if(curr.length() == 0) backtrack(num, target, i+1, ans, num.substring(idx, i+1), sum + number, number);
                else{
                    backtrack(num, target, i+1, ans, curr + "+" + num.substring(idx, i+1), sum + number, number);
                    backtrack(num, target, i+1, ans, curr + "-" + num.substring(idx, i+1), sum - number, -number);
                    backtrack(num, target, i+1, ans, curr + "*" + num.substring(idx, i+1), sum - last + last * number, last * number);
                }
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        var ans = new ArrayList<String>();
        backtrack(num, target, 0, ans, "", 0, 0);
        return ans;
    }
}