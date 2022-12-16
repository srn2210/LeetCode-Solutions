class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //if(triangle.size())
        for(int i=1; i<triangle.size(); i++) {
            for(int j=0; j<triangle.get(i).size(); j++) {
                int val = triangle.get(i).get(j);
                int a = Integer.MAX_VALUE;
                if(j < triangle.get(i-1).size()) a = triangle.get(i-1).get(j);
                int b = Integer.MAX_VALUE;
                if(j > 0) b = triangle.get(i-1).get(j-1);
                triangle.get(i).set(j, Math.min(a,b) + val);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<triangle.get(triangle.size()-1).size(); i++)
            ans = Math.min(ans, triangle.get(triangle.size()-1).get(i));
        return ans;
    }
}