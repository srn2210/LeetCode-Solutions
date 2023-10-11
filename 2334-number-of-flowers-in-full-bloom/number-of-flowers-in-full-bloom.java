class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[][] arr = new int[people.length][2];
        for(int i=0; i<arr.length; i++) {
            arr[i] = new int[]{people[i], i};
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        var q = new PriorityQueue<Integer>();
        int flower = 0;
        int[][] ans = new int[people.length][2];
        int ptr = 0;
        Arrays.sort(flowers, (a,b) -> Integer.compare(a[0], b[0]) == 0 ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        //for(int i=0; i<flowers.length; i++) System.out.println(Arrays.toString(flowers[i]));
        for(int i=0; i<arr.length; i++) {
            
            while(ptr < flowers.length && flowers[ptr][0] <= arr[i][0]) q.add(flowers[ptr++][1]);
            while(!q.isEmpty() && q.peek() < arr[i][0]) q.poll();
            //System.out.println(q);
            ans[i][0] = q.size();
            ans[i][1] = arr[i][1];
        }
        Arrays.sort(ans, (a,b) -> Integer.compare(a[1], b[1]));
        int[] res = new int[people.length];
        for(int i=0; i<people.length; i++) res[i] = ans[i][0];
        return res;
    }
}