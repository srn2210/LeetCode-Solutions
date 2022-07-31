class MyQueue {
    
    Stack<Integer> main = new Stack();
    Stack<Integer> temp = new Stack();

    public MyQueue() {
        Stack<Integer> main = new Stack();
        Stack<Integer> temp = new Stack();
    }
    
    public void push(int x) {
        while(main.size() != 0) {
            temp.push(main.pop());
        }
        temp.push(x);
        
        while(temp.size() != 0) {
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
        return main.size() == 0;
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