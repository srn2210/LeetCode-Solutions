class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer>[] buckets = new ArrayList[32];
        for(int i=0; i<32; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        for(int val : arr) {
            buckets[Integer.bitCount(val)].add(val);
        }
        for(int i=0; i<32; i++) {
            Collections.sort(buckets[i]);
        }
        int i=0;
        for(int j=0; j<32; j++) {
            for(int val : buckets[j]) {
                arr[i++] = val;
            }
        }
        return arr;
    }
}