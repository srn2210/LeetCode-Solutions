class Solution {
    boolean containsDup(Set<Character> set, String s) {
        for(char ch : s.toCharArray()) {
            if(set.contains(ch)) {
                return true;
            }
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
        for(String s : arr) {
            var set = new HashSet<Character>();
            boolean flag = true;
            for(char ch : s.toCharArray()) {
                if(set.contains(ch)) {
                    flag = false;
                    break;
                }
                else {
                    set.add(ch);
                }
            }
            if(flag) list.add(s);
        }
        return solve(list, 0, new HashSet<Character>());
    }
}