class Solution {
    public List<List<Integer>> generate(int numRows) {
        var ans = new ArrayList<List<Integer>>();
        ans.add(List.of(1));
        for(int i=1; i<numRows; i++) {
            var list = new ArrayList<Integer>();
            for(int j=0; j<=i; j++) {
                int prevRow = j < ans.get(i-1).size() ? ans.get(i-1).get(j) : 0;
                int prevRowCol = (j-1) >= 0 ? ans.get(i-1).get(j-1) : 0;
                list.add(prevRow + prevRowCol);
            }
            ans.add(list);
        }
        return ans;
    }
}