class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(letters[mid] <= target) left = mid + 1;
            else right = mid;
        }
        if(left == letters.length) return letters[0];
        return letters[left];
    }
}