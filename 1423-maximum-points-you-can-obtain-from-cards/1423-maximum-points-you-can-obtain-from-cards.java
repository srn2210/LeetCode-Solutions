class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int st = 0;
        int end = n-k-1;
        int ans = 0;
        int tot = 0;
        
        for(int i:cardPoints){
            tot += i;
        }
        
        for(int i=0; i<n-k; i++){
            ans += cardPoints[i];
        }
        
        
        int temp = ans;
        
        for(int i=end+1; i<n; i++){
            temp = temp + cardPoints[i] - cardPoints[st];            
            ans = Math.min(ans, temp);
            st++;
        }
        
        int sol = tot - ans;
        
        return sol;
    }
}