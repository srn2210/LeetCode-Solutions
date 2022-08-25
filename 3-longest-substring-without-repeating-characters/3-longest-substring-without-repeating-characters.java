class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0;
        HashSet<Character> set = new HashSet();
        while(i < s.length()) {
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                max = Math.max(max, i-j+1);
                i++;
            }
            else {
                set.remove(s.charAt(j));
                j++;
            }
        }
        return max;
    }
}