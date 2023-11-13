class Solution {
    public String sortVowels(String s) {
        var pq = new PriorityQueue<Character>();
        StringBuilder str = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') pq.add(ch);
        }
        for(char ch : s.toCharArray()) {
            if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') str.append(pq.poll());
            else str.append(ch);
        }
        return str.toString();
    }
}