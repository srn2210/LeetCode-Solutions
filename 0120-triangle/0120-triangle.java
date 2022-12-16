class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        for(int i=1; i<m; i++) {
            List<Integer> list = triangle.get(i);
            List<Integer> plist = triangle.get(i-1);
            for(int j=0; j<list.size(); j++) {
                int val = list.get(j);
                int a = Integer.MAX_VALUE;
                if(j < plist.size()) a = plist.get(j);
                int b = Integer.MAX_VALUE;
                if(j > 0) b = plist.get(j-1);
                triangle.get(i).set(j, Math.min(a,b) + val);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i : triangle.get(m-1))
            ans = Math.min(ans, i);
        return ans;
    }
}