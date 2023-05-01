class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0.0;
        for(var sal : salary) {
            sum += sal;
            min = Math.min(min, sal);
            max = Math.max(max, sal);
        }
        return (sum - min - max)/(salary.length-2);
    }
}