class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int left = 0;
        int right = 0;
        var q = new LinkedList<Integer>();
        for(int i : pushed) q.add(i);
        var st = new Stack<Integer>();
        while(right < n) {
            while(!q.isEmpty() && q.peek() != popped[right]) st.push(q.poll());
            if(!q.isEmpty() && q.peek() == popped[right]) st.push(q.poll());
            if(right < n && q.isEmpty() && st.peek() != popped[right]) return false;
            while(right < n && !st.isEmpty() && st.peek() == popped[right]) {
                st.pop();
                right++;
                //st.pop();
            }
        }
        return true;
    }
}