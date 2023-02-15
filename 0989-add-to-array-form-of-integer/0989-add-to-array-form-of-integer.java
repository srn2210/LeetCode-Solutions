class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        var ans = new LinkedList<Integer>();
        int carry = 0;
        for(int i=num.length-1; i>=0; i--) {
            int t = num[i] + (k%10) + carry;
            ans.addFirst(t%10);
            carry = t/10;
            k /= 10;
        }
        while(k != 0) {
            int t = (k%10) + carry;
            ans.addFirst(t%10);
            k /= 10;
            carry = t/10;
        }
        if(carry != 0) ans.addFirst(carry);
        //Collections.reverse(ans);
        return ans;
    }
}