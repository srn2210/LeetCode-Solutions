class Solution {
    public boolean winnerOfGame(String colors) {
        int countA = 0, countB = 0;
        int left = 0, right = 0;
        while(right < colors.length()) {
            char rCH = colors.charAt(right);
            char lCH = colors.charAt(left);
            if(lCH == rCH) {
                if(right - left + 1 >= 3) {
                    switch(rCH) {
                        case 'A':
                            countA++;
                            break;
                        case 'B':
                            countB++;
                            break;
                    }
                }
                right++;
            }
            else {
                left = right;
            }
        }
        return countA > countB;
    }
}