class Solution {
    class UF {
        int[] arr;
        int[] sz;
        UF(int n) {
            arr = new int[n];
            sz = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = i;
                sz[i] = 1;
            }
        }
        int find(int p) {
            if(arr[p] == p) return p;
            else return arr[p] = find(arr[p]);
        }
        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
        void union(int p, int q) {
            int x = find(p);
            int y = find(q);
            if(isConnected(x, y)) return;
            else {
                if(sz[x] > sz[y]) {
                    sz[x] += sz[y];
                    arr[y] = x;
                }
                else {
                    arr[x] = y;
                    sz[y] += sz[x];
                }
            }
        }
    }
    public boolean canTraverseAllPairs(int[] nums) {
        if(nums.length == 1) return true;
        for(int num : nums) if(num == 1) return false;
        UF uf = new UF(100001);
        for(int num : nums) {
            int sqrt = (int)Math.sqrt(num);
            for(int j=2; j<=sqrt; j++) {
                if(num % j == 0) {
                    uf.union(num, num/j);
                    uf.union(num, j);
                }
            }
        }
        int par = uf.find(nums[0]);
        for(int i=1; i<nums.length; i++) {
            if(uf.find(nums[i]) != par) return false;
        }
        return true;
    }
}