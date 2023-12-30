class Solution {
    public boolean makeEqual(String[] words) {
        int[] arr = new int[26];
        int len = words.length;
        for(var word : words) {
            for(char ch : word.toCharArray()) {
                arr[ch-'a']++;
            }
        }
        for(int i=0; i<26; i++) {
            if(arr[i] % len != 0) return false;
        }
        return true;
    }
}