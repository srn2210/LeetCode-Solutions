class BrowserHistory {
    Stack<String> history;
    Stack<String> forward;
    public BrowserHistory(String homepage) {
        history = new Stack<>();
        history.push(homepage);
        forward = new Stack<>();
        //curr = 0;
        //end = 0;
    }
    
    public void visit(String url) {
        history.push(url);
        forward = new Stack<>();
    }
    
    public String back(int steps) {
        for(int i=0; i<steps; i++) {
            if(history.size() == 1) break;
            forward.push(history.pop());
        }
        return history.peek();
    }
    
    public String forward(int steps) {
        for(int i=0; i<steps; i++) {
            if(forward.isEmpty()) break;
            history.push(forward.pop());
        }
        return history.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */