class Solution {
    public int compress(char[] chars) {
        int left = 0;
        int right = 1;
        char prev = chars[0];
        int cnt = 1;
        while(right < chars.length) {
            if(chars[right] != prev) {
                chars[left++] = prev;
                prev = chars[right];
                if(cnt == 1) {
                    cnt = 0;
                    continue;
                }
                else {
                    var t = String.valueOf(cnt);
                    for(char ch : t.toCharArray()) chars[left++] = ch;
                }
                cnt = 1;
            }
            else {
                cnt++;
            }
            right++;
        }
        chars[left++] = prev;
        if(cnt == 1) return left;
        else {
            var t = String.valueOf(cnt);
            for(char ch : t.toCharArray()) chars[left++] = ch;
        }
        return left;
    }
}