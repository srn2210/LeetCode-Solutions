class BrowserHistory {
    List<String> history;
    int curr;
    int end;
    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
        end = curr;
    }
    
    public void visit(String url) {
        if(curr + 1 == history.size()) history.add(url);
        else history.set(curr + 1, url);
        curr++;
        end = curr;
    }
    
    public String back(int steps) {
        curr = steps > curr ? 0 : curr - steps;
        return history.get(curr);
    }
    
    public String forward(int steps) {
        curr = curr + steps >= end ? end : curr + steps;
        return history.get(curr);
    }
}