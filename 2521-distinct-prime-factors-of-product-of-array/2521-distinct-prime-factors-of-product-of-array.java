class Solution {
    /*static List<Integer> list = new ArrayList<>();
    boolean isPrime(int num) {
        if(num == 1) return false;
        int lim = (int)Math.sqrt(num);
        for(int i=2; i<=lim; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    void getPrime(int total) {
        for(int i=2; i<=total; i++) {
            if(isPrime(i)) list.add(i);
        }
    }*/
    public int distinctPrimeFactors(int[] nums) {
        /*int total = 1;
        for(int i : nums) total *= i;
        if(list.size() == 0) getPrime(1000);
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>(list);
        System.out.println(list);
        for(int i=0; i<nums.length; i++) {
            if(set2.contains(nums[i])) {
                set.add(nums[i]);
                continue;
            }
            int k = nums[i];
            while(k != 1) {
                for(int l:list) {
                    if(l > k) break;
                    if(k % l == 0) {
                        set.add(l);
                        k /= l;
                        break;
                    }
                }
            }
        }
        return set.size();*/
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
}