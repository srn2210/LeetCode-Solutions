class Solution {
    int binarySearch(int[] potions, int target) {
        int lo = 0;
        int hi = potions.length;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(potions[mid] < target) lo = mid + 1;
            else {
                hi = mid;
            }
        }
        return lo;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0; i<spells.length; i++) {
            int target = (int)Math.ceil(success / (double) spells[i]);
            int idx = binarySearch(potions, target);
            //idx = idx < 0 ? -idx-1 : idx;
            ans[i] = potions.length - idx;
        }
        return ans;
    }
}