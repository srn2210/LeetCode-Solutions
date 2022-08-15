class Solution {
    List<String> qstr;
    boolean isValid(String s, List<String> arr) {
        if(arr.size() == 0) {
            return true;
        }
        int row = arr.size()-1;
        int col = s.indexOf("Q");
        
        if(arr.contains(s)) return false;
        
        int i=row;
        int j=col-1;
        int k=col+1;
        while(i>=0) {
            if(j >= 0) {
                if(arr.get(i).equals(qstr.get(j))) return false;
            }
            if(k < qstr.size()) {
                if(arr.get(i).equals(qstr.get(k))) {
                    return false;
                }
            }
            i--;
            j--;
            k++;
        }
        return true;
    }
    boolean solve(List<List<String>> res, List<String> curr, int n) {
        if(curr.size() == n) {            
            res.add(new ArrayList(curr));
        }
        else {
            for(String s:qstr) {
                if(isValid(s, curr)) {
                    curr.add(s);
                    solve(res, curr, n);
                    curr.remove(s);
                }
            }
            return false;
        }
        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList();
        StringBuilder st = new StringBuilder();
        qstr = new ArrayList();
        for(int i=0; i<n; i++) {
            st = new StringBuilder();
            for(int j=0; j<n; j++) {
                if(i == j) st.append("Q");
                else st.append(".");
            }
            qstr.add(st.toString());
        }
        solve(res, new ArrayList(), n);
        return res;
    }
}