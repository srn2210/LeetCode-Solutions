class Solution {
    public boolean wordPattern(String pattern, String s) {
        if(pattern.length() == 1) return true;
        
        String arr[] = s.split(" ");
        
        if(arr.length != pattern.length()) return false;
        
        HashMap<Character, String> hm = new HashMap();
        
        for(int i=0; i<pattern.length(); i++){
            if( hm.containsValue(arr[i]) && !(hm.containsKey(pattern.charAt(i))) ) return false;
            hm.put(pattern.charAt(i), arr[i]);
        }
        
        StringBuilder res = new StringBuilder();
        
        for(int i=0; i<pattern.length(); i++){
            if(i == pattern.length()-1) {
                res.append(hm.get(pattern.charAt(i)));
                continue;
            }
            res.append(hm.get(pattern.charAt(i)));
            res.append(" ");
        }
        
        String ans = res.toString();
        
        if(ans.equals(s)) return true;
        
        return false;
    }
}