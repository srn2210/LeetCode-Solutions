class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] arr = new int[startTime.length][3];
        for(int i=0; i<startTime.length; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        Arrays.sort(arr, (a,b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for(int[] i:arr) {
            int c = map.get(map.floorKey(i[0])) + i[2];
            int d = map.get(map.floorKey(i[1]));
            map.put(i[1], Math.max(c, d));
        }
        return map.get(arr[startTime.length-1][1]);
    }
}