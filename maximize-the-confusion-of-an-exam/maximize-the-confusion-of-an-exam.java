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
    boolean safe(int cand, String str, int k) {
        return Math.max(getMax(str, k, 'T'), getMax(str, k, 'F')) >= cand;

    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        /*int n = answerKey.length(), left = 1, right = n;
        while(left < right) {
            int mid = (left + (right - left) / 2) + 1;
            if(safe(mid, answerKey, k)) left = mid;
            else right = mid - 1;
        }
        return left;*/
        return Math.max(getMax(answerKey, k, 'T'), getMax(answerKey, k, 'F'));
    }
}