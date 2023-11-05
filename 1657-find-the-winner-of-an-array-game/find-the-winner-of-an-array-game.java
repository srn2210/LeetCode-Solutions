class Solution {
    public int getWinner(int[] arr, int k) {
        Deque<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<arr.length; i++) {
            q.add(i);
        }
        if(k > arr.length) {
            int max = -1;
            for(int val : arr) {
                max = Math.max(max, val);
            }
            return max;
        }
        int con = 0;
        int num = -1;
        while(con < k) {
            int first = q.pollFirst();
            if(arr[first] > arr[q.peekFirst()]) {
                q.addLast(q.pollFirst());
                q.addFirst(first);
                if(num == first) {
                    con++;
                }
                else {
                    num = first;
                    con = 1;
                }
            }
            else {
                q.addLast(first);
                if(num == q.peek()) {
                    con++;
                }
                else {
                    num = q.peek();
                    con = 1;
                }
            }
        }
        return arr[num];
    }
}