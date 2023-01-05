class Solution {
    void sieve(int[] spf) {
        for(int i=2; i<spf.length; i++) {
            spf[i] = i;
        }
        for(int i=2; i*i<spf.length; i++) {
            if(spf[i] == i) {
                for(int j=i*i; j<spf.length; j+=i) {
                    if(spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] spf = new int[1001];
        sieve(spf);
        for(int i:nums) {
            int k = i;
            while(k != 1) {
                set.add(spf[k]);
                k = k / spf[k];
            }
        }
        return set.size();
    }
}