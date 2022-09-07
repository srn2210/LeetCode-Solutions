class MinStack {
    class Node {
        int val;
        int min;
        Node next;
        Node(int val, int min, Node node) {
            this.val = val;
            this.min = min;
            this.next = node;
        }
    }
    Node curr;
    public MinStack() {
    }
    
    public void push(int val) {
        if(curr == null) 
            curr = new Node(val, val, null);
        else {
            Node node = new Node(val, Math.min(curr.min, val), curr);
            curr = node;
        }
    }
    
    public void pop() {
        curr = curr.next;
    }
    
    public int top() {
        return curr.val;
    }
    
    public int getMin() {
        return curr.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */