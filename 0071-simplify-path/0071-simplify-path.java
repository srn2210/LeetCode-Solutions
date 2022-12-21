class Solution {
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        String[] parts = path.split("/");
        res.append('/');
        for(String s : parts) {
            if(s.length() == 0) continue;
            else if(s.equals("..")) {
                if(res.length() > 1) res.deleteCharAt(res.length()-1);
                while(res.charAt(res.length()-1) != '/') {
                    res.deleteCharAt(res.length()-1);
                }
                continue;
            }
            else if(s.equals(".")) continue;
            res.append(s);
            res.append('/');
        }
        if(res.length() > 1) res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}