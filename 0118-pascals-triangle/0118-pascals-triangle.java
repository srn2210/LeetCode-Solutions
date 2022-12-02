class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        if(numRows == 1) return res;
        res.add(List.of(1,1));
        if(numRows == 2) return res;
        for(int i=2; i<numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1; j<res.get(i-1).size(); j++) {
                temp.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}