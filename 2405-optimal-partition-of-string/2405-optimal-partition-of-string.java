class Solution {
    public int partitionString(String s) {
        int mask = 0;
        int ans = 1;
        for(char ch : s.toCharArray()) {
            int bit = 1 << (int) (ch-'a');
            int check = bit & mask;
            if(check != 0) {
                ans++;
                mask = 0;
            }
            mask += bit;
        }
        return ans;
    }
}