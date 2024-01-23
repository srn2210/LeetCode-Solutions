class Solution {
    boolean containsDup(Set<Character> set, String s) {
        var selfSet = new HashSet<Character>();
        for(char ch : s.toCharArray()) {
            if(set.contains(ch) || selfSet.contains(ch)) {
                return true;
            }
            else selfSet.add(ch);
        }
        return false;
    }
    int solve(List<String> arr, int idx, Set<Character> set) {
        if(idx == arr.size()) return set.size();
        int ans = solve(arr, idx+1, set);
        if(!containsDup(set, arr.get(idx))) {
            for(char ch : arr.get(idx).toCharArray()) {
                set.add(ch);
            }
            ans = Math.max(ans, solve(arr, idx+1, set));
            for(char ch : arr.get(idx).toCharArray()) {
                set.remove(ch);
            }
        }
        return ans;
    }
    public int maxLength(List<String> arr) {
        List<String> list = new ArrayList<>();
        return solve(arr, 0, new HashSet<Character>());
    }
}