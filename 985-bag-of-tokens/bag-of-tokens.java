class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int ans = 0;
        int score = 0;
        int left = 0, right = tokens.length-1;
        Arrays.sort(tokens);
        while(left <= right) {
            if(power >= tokens[left]) {
                score++;
                ans = Math.max(ans, score);
                power -= tokens[left++];
            }
            else if(score > 0) {
                score--;
                power += tokens[right--];
            }
            else break;
        }
        return ans;
    }
}