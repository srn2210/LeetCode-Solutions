class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0, itr = piles.length / 3;
        int ptr = piles.length-2;
        while(itr-- > 0) {
            ans += piles[ptr];
            ptr -= 2;
        }
        return ans;
    }
}