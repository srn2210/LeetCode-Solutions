class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> ans = new ArrayList();
        
        Arrays.sort(people, (a,b) -> b[0] == a[0] ? a[1] - b[1] : b[0] - a[0] );
        
        for(int[] i: people){
            ans.add(i[1], i);
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}