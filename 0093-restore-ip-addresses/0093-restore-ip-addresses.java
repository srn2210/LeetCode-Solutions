class Solution {
    boolean isValid(StringBuilder curr) {
        String[] arr = curr.toString().split("[.]");
        if(arr.length != 4) return false;
        for(String s : arr) {
            if(s.length() == 0 || (s.charAt(0) == '0' && s.length() != 1) || Integer.parseInt(s) > 255) return false;
        }
        return true;
    }
    void backtrack(List<String> ans, int cnt, String s, StringBuilder curr, int idx) {
        if(cnt == 3 ) {
            for(int i=idx; i<s.length(); i++) curr.append(s.charAt(i));
            if(isValid(curr)) {
                ans.add(curr.toString());
                return;
            }
        }
        else if(cnt < 3) {
            int num = 0;
            for(int i=idx; i<s.length(); i++) {
                curr.append(s.charAt(i));
                num *= 10;
                num += Character.getNumericValue(s.charAt(i));
                int t = 4 - cnt - 1;
                t *= 3;
                if(s.length() - i - 1 > 0 && s.length() - i - 1 <= t) {
                    if(num > 255) return;
                    curr.append('.');
                    int l = curr.length() - 1;
                    backtrack(ans, cnt + 1, s, curr, i+1);
                    while(curr.length() > l) curr.deleteCharAt(curr.length()-1);
                }
            }
        }
        else return;
    }
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        backtrack(ans, 0, s, new StringBuilder(), 0);
        return ans;
    }
}