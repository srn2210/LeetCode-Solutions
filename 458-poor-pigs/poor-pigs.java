class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        //System.out.println(Math.log(buckets) / Math.log((minutesToTest/minutesToDie) + 1));
        return (int)Math.ceil(Math.log10(buckets) / Math.log10((minutesToTest/minutesToDie) + 1));
    }
}