class BrowserHistory {
    class DLinkedList {
        String val;
        DLinkedList next;
        DLinkedList prev;
        DLinkedList(String init, DLinkedList p) {
            this.val = init;
            this.next = null;
            this.prev = p;
        }
        String get() {
            return this.val;
        }
        void set(String url) {
            this.val = url;
        }
    }
    DLinkedList curr;
    public BrowserHistory(String homepage) {
        curr = new DLinkedList(homepage, null);
    }
    
    public void visit(String url) {
        curr.next = new DLinkedList(url, curr);
        curr = curr.next;
    }
    
    public String back(int steps) {
        for(int i=0; i<steps; i++) {
            if(curr.prev == null) break;
            curr = curr.prev;
        }
        return curr.get();
    }
    
    public String forward(int steps) {
        for(int i=0; i<steps; i++) {
            if(curr.next == null) break;
            curr = curr.next;
        }
        return curr.get();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */