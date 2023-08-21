class Solution {
    boolean safe(int cand, String s1, String s2) {
        StringBuilder res = new StringBuilder();
        for(int i=0; i<cand; i++) {
            res.append(s1);
        }
        return res.toString().contains(s2);
    }
    public int repeatedStringMatch(String a, String b) {
        int ceil = (int)Math.ceil((2d * b.length()) / a.length()) + 2;
        int left = 0, right = ceil;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(safe(mid, a, b)) right = mid;
            else left = mid + 1;
        }
        return left == ceil ? -1 : left;
    }
}