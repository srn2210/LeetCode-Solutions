class Solution {
    int getMax(String str, int k, char c) {
        int left = 0, right = 0, max = 0;
        while(right < str.length()) {
            var ch = str.charAt(right);
            if(ch == c && k > 0) k--;
            else if(ch == c && k == 0) {
                while(left <= right && str.charAt(left) != c) {
                    left++;
                }
                if(left <= right) left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getMax(answerKey, k, 'T'), getMax(answerKey, k, 'F'));
    }
}