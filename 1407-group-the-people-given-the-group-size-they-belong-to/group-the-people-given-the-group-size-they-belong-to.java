class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int[][] group = new int[groupSizes.length][2];
        for(int i=0; i<groupSizes.length; i++) {
            group[i][0] = i;
            group[i][1] = groupSizes[i];
        }
        Arrays.sort(group, (a,b) -> Integer.compare(a[1], b[1]));
        var ans = new ArrayList<List<Integer>>();
        for(int i=0; i<group.length;) {
            int size = group[i][1];
            var list = new ArrayList<Integer>();
            for(int j=i; j<i+size; j++) {
                list.add(group[j][0]);
            }
            ans.add(list);
            i = i + size;
        }
        return ans;
    }
}