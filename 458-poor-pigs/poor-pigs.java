class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int)Math.ceil(Math.log10(buckets) / Math.log10((minutesToTest/minutesToDie) + 1));
    }
}