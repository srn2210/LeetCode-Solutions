class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length-1, mid = 0;
        while(lo < hi) {
            mid = (hi + lo) / 2;
            if(letters[mid] > target) hi = mid;
            else lo = mid + 1;
        }
        return letters[lo] > target ? letters[lo] : letters[0];
    }
}