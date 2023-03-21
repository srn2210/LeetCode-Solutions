class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        boolean l = false, r = false;
        for(int i=0; i<len && n > 0; i++) {
            l = i == 0 ? flowerbed[i] == 0 : flowerbed[i-1] == 0;
            r = i == len-1 ? flowerbed[len-1] == 0 : flowerbed[i+1] == 0;
            if(flowerbed[i] != 1 && l && r) {
                i++;
                n--;
            }
        }
        return n == 0;
    }
}