class Solution {
    public int minPartitions(String n) {
        int  a = 0;
        for(int i=0; i<n.length(); i++){
            a = Math.max(n.charAt(i) - '0', a);
            if( a == 9 ) return 9;
        }
        
        return a;
    }
}