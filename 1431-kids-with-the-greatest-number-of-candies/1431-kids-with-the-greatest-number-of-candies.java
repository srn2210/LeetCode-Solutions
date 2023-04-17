class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for(int i : candies) max = Math.max(max, i);
        var ans = new ArrayList<Boolean>();
        for(int i : candies) {
            if(i + extraCandies >= max) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}