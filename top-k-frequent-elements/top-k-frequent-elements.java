class Solution {
    Random rand;
    void swap(int[][] arr, int pivot, int hi) {
        int t1 = arr[pivot][0];
        int t2 = arr[pivot][1];
        arr[pivot][0] = arr[hi][0];
        arr[pivot][1] = arr[hi][1];
        arr[hi][0] = t1;
        arr[hi][1] = t2;
    }
    void solve(int[][] arr, int lo, int hi, int k) {
        if(lo >= hi) return;
        int pivot = rand.nextInt(hi-lo) + lo;
        swap(arr, pivot, hi);

        int left = lo, right = hi-1;
        //while(right > left && arr[right][1] > arr[hi][1]) right--;
        while(left <= right) {
            if(arr[left][1] < arr[hi][1]) {
                left++;
            }
            else {
                swap(arr, right, left);
                right--;
            }
        }
        swap(arr, hi, left);

        if(left == k) return;
        else if(left < k) {
            solve(arr, left+1, hi, k);
        }
        else solve(arr, lo, hi-1, k);

    }
    public int[] topKFrequent(int[] nums, int k) {
        rand = new Random();
        var map = new HashMap<Integer, Integer>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int[][] arr = new int[map.size()][2];
        int idx = 0;
        for(var entry : map.entrySet()) {
            arr[idx][0] = entry.getKey();
            arr[idx][1] = entry.getValue();
            idx++;
        }
        solve(arr, 0, arr.length-1, arr.length-k);
        int[] ans = new int[k];
        int j= 0;
        //for(int[] a : arr) System.out.println(Arrays.toString(a));
        for(int i=arr.length-k; i<arr.length; i++) ans[j++] = arr[i][0];
        return ans;
    }
}