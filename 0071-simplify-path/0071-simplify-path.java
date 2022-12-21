class Solution {
    public String simplifyPath(String path) {
        //Stack<String> st = new Stack
        StringBuilder res = new StringBuilder();
        String[] parts = path.split("/");
        res.append('/');
        for(String s : parts) {
            if(s.length() == 0) continue;
            if(s.equals("..")) {
                if(res.length() > 1) res.deleteCharAt(res.length()-1);
                while(res.charAt(res.length()-1) != '/') {
                    res.deleteCharAt(res.length()-1);
                }
                continue;
            }
            if(s.equals(".")) continue;
            res.append(s);
            res.append('/');
        }
        if(res.length() > 1) res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}