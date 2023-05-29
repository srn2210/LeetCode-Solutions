class MyLinkedList {
    class Node {
        int val;
        Node prev;
        Node next;
        Node() {
            val = 0;
            prev = null;
            next = null;
        }
        Node(int val) {
            this.val = val;
            prev = null;
            next = null;
        }
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
            prev = null;
        }
    }
    Node head, tail;
    int size;
    public MyLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    Node getNode(int index) {
        if(index >= size) return null;
        else {
            Node temp = head;
            int count = -1;
            while(count++ < index) {
                temp = temp.next;
            }
            return temp;
        }
    }

    public int get(int index) {
        Node n = getNode(index);
        if(n == null) return -1;
        else return n.val;
    }
    
    void add(int val, Node f, Node s) {
        Node node = new Node(val);
        f.next = node;
        node.prev = f;
        node.next = s;
        s.prev = node;
        this.size++;
    }

    public void addAtHead(int val) {
        add(val, head, head.next);
    }
    
    public void addAtTail(int val) {
        add(val, tail.prev, tail);
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        else if(index == size) addAtTail(val);
        else {
            Node node = getNode(index);
            add(val, node.prev, node);
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) return;
        Node node = getNode(index);
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;
        node.next = null;
        node.prev = null;
        this.size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */