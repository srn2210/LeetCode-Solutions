class Solution {
    boolean isValid(StringBuilder curr) {
        String[] arr = curr.toString().split("[.]");
        if(arr.length != 4) return false;
        for(String s : arr) {
            if(s.length() == 0 || (s.charAt(0) == '0' && s.length() != 1) || Integer.parseInt(s) > 255) return false;
        }
        return true;
    }
    void backtrack(List<String> ans, int cnt, StringBuilder curr, int idx) {
        if(cnt == 3 && isValid(curr)) {
            ans.add(curr.toString());
            return;
        }
        else if(cnt < 3) {
            for(int i=idx; i<curr.length(); i++) {
                int t = 4 - cnt - 1;
                t *= 3;
                if(curr.length() - i - 1 <= t) {
                    curr.insert(i+1, '.');
                    backtrack(ans, cnt + 1, curr, i+2);
                    curr.deleteCharAt(i+1);
                }
            }
        }
        else return;
    }
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        backtrack(ans, 0, new StringBuilder(s), 0);
        return ans;
    }
}