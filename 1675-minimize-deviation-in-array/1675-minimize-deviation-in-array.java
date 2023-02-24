class Solution {
    static final int[] q = new int[1600000];

    public int minimumDeviation(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                nums[i] *= 2;
            }
        }
        Arrays.sort(nums);
        int qstart = 0;
        int qend = 0;
        int best = nums[n - 1] - nums[0];
        int numptr = n - 2;
        q[qend++] = nums[n - 1];
        int min = nums[0];
        while (true) {
            final int pick = numptr >= 0 && nums[numptr] > q[qstart] ? nums[numptr--] : q[qstart++];
            best = Math.min(best, pick - min);
            if (pick % 2 == 1) return best;
            min = Math.min(min, q[qend++] = pick / 2);
        }
    }
}