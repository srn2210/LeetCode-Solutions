class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        for(int i=0; i<32; i++) {
            int mask = 1 << i;
            if(((a | b) & mask) == 0 && (c & mask) != 0) count++;
            if((a & mask) != 0 && (c & mask) == 0) count++;
            if((b & mask) != 0 && (c & mask) == 0) count++;
        }
        return count;
    }
}