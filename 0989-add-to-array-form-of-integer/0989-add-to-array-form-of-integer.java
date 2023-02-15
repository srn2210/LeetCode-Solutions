class Solution {
    void reverse(List<Integer> ans) {
        int l = 0;
        int r = ans.size()-1;
        while(l < r) {
            var t = ans.get(l);
            ans.set(l++, ans.get(r));
            ans.set(r--, t);
        }
    }
    public List<Integer> addToArrayForm(int[] num, int k) {
        var ans = new ArrayList<Integer>();
        int carry = 0;
        for(int i=num.length-1; i>=0; i--) {
            int t = num[i] + (k%10) + carry;
            ans.add(t%10);
            carry = t/10;
            k /= 10;
        }
        while(k != 0) {
            int t = (k%10) + carry;
            ans.add(t%10);
            k /= 10;
            carry = t/10;
        }
        if(carry != 0) ans.add(carry);
        reverse(ans);
        return ans;
    }
}