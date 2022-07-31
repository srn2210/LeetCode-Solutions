class MyQueue {
    
    Stack<Integer> main = new Stack();
    Stack<Integer> temp = new Stack();

    public MyQueue() {
        Stack<Integer> main = new Stack();
        Stack<Integer> temp = new Stack();
    }
    
    public void push(int x) {
        while(!main.isEmpty()) {
            temp.push(main.pop());
        }
        temp.push(x);
        
        while(!temp.isEmpty()) {
            main.push(temp.pop());
        }
        
    }
    
    public int pop() {
        return main.pop();
    }
    
    public int peek() {
        return main.peek();
    }
    
    public boolean empty() {
        return main.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */