class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int ptr = 0, n = s.length();
        int ans = 0;
        int arr[] = new int[26], arr2[] = new int[26];
        while(ptr < n) {
            if(s.charAt(ptr) != goal.charAt(ptr)) ans++;
            arr[s.charAt(ptr)-'a']++;
            arr2[goal.charAt(ptr)-'a']++;
            ptr++;
        }
        if(ans == 0) {
            for(int i : arr) if(i >= 2) return true;
        }
        for(int i=0; i<26; i++) if(arr[i] != arr2[i]) return false;
        return ans == 2;
    }
}