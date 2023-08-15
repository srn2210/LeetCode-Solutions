class Solution {
    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        int xor = 0;
        for(int i=0; i<pref.length; i++) {
            arr[i] = pref[i] ^ xor;
            xor = xor ^ arr[i];
        }
        return arr;
    }
}