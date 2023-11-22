class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int size = 0;
        for(var list : nums) {
            size += list.size();
        }
        int[] ans = new int[size];
        int ptr = 0;
        var pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0]+a[1], b[0]+b[1]) == 0 ? Integer.compare(b[0], a[0]) : Integer.compare(a[0]+a[1], b[0]+b[1]));
        for(int i=0; i<nums.size(); i++) {
            for(int j=0; j<nums.get(i).size(); j++) {
                pq.add(new int[]{i, j});
            }
        }
        while(!pq.isEmpty()) {
            ans[ptr++] = nums.get(pq.peek()[0]).get(pq.poll()[1]);
        }
        return ans;
    }
}