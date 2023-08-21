class Solution {
    public int repeatedStringMatch(String a, String b) {
        int[] pre = new int[b.length()];
        int lp = 0, rp = 1;
        while(rp < b.length()) {
            //System.out.println(rp + " -- " + lp);
            if(b.charAt(lp) == b.charAt(rp)) {
                pre[rp++] = ++lp;
            }
            else if(lp != 0) {
                lp = pre[lp-1];
            }
            else rp++;
        }
        //System.out.println(Arrays.toString(pre));
        int ceil = (int)Math.ceil((2.0 * b.length()) / a.length()) + 1;
        int bp = 0, i = 0;
        while(i<=(ceil * a.length())) {
            int curr = i % a.length();
            if(a.charAt(curr) == b.charAt(bp)) {
                bp++;
                i++;
                if(bp == b.length()) {
                    return i % a.length() == 0 ? i / a.length() : (i / a.length()) + 1;
                }
            }
            else if(bp != 0) bp = pre[bp-1];
            else i++;
        }
        return -1;
    }
}