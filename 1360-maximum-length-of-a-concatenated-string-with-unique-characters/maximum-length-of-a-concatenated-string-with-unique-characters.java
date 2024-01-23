class Solution {
    Map<Pair<Integer, Integer>, Integer> dp;
    int getMask(String s) {
        int mask = 0;
        for(char ch : s.toCharArray()) {
            mask |= 1 << (ch-'a');
        }
        return mask;
    }
    int solve(List<String> arr, int idx, int mask) {
        if(idx == arr.size()) return 0;
        var p = new Pair<Integer, Integer>(idx, mask);
        if(dp.containsKey(p)) return dp.get(p);
        int ans = 0;
        for(int i=idx; i<arr.size(); i++) {
            int curr = getMask(arr.get(i));
            if(arr.get(i).length() != Integer.bitCount(curr)) continue;
            if((curr & mask) != 0) continue;
            ans = Math.max(ans, arr.get(i).length() + solve(arr, idx+1, mask | curr));
        }
        dp.put(p, ans);
        return ans;
    }
    public int maxLength(List<String> arr) {
        dp = new HashMap<>();
        return solve(arr, 0, 0);
    }
}