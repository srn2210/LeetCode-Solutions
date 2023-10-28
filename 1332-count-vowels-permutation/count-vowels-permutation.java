class Solution {
    int mod = (int)1e9+7;
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    Map<Pair<Character, Integer>, Integer> dp;
    int solve(char ch, int n) {
        if(n == 0) return 1;
        var curr = new Pair<>(ch, n);
        if(dp.containsKey(curr)) return dp.get(curr);
        long ans = 0;
        switch(ch) {
            case 'a':
                ans += solve('e', n-1);
                ans %= mod;
                break;
            case 'e':
                ans += solve('a', n-1);
                ans %= mod;
                ans += solve('i', n-1);
                ans %= mod;
                break;
            case 'i':
                for(char c : vowels) {
                    if(c == 'i') continue;
                    ans += solve(c, n-1);
                    ans %= mod;
                }
                break;
            case 'o':
                ans += solve('i', n-1);
                ans %= mod;
                ans += solve('u', n-1);
                ans %= mod;
                break;
            case 'u':
                ans += solve('a', n-1);
                ans %= mod;
                break;
        }
        dp.put(curr, (int)ans);
        return (int)ans;
    }
    public int countVowelPermutation(int n) {
        int ans = 0;
        dp = new HashMap<>();
        for(char ch : vowels) {
            ans += solve(ch, n-1);
            ans %= mod;
        }
        return ans;
    }
}