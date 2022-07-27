class Solution {
    int count(int x){
        return (x*(x+1))/2;
    }
    public int candy(int[] ratings) {
        if(ratings.length <= 1) return ratings.length;
        int ans = 1;
        int up = 0;
        int down = 0;
        int pslope = 0;
        
        for(int i=1; i<ratings.length; i++){
            int slope = ratings[i] - ratings[i - 1];
            if((pslope > 0 && slope == 0) || (pslope < 0 && slope >= 0)){
                ans += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (slope > 0) up++;
            else if (slope < 0) down++;
            else ans++;
            pslope = slope;
        }
        ans += count(up) + count(down) + Math.max(up, down);
        
        return ans;
    }
}