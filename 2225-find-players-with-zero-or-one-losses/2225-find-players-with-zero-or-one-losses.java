class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> won = new HashSet<>();
        Set<Integer> loss = new HashSet<>();
        Set<Integer> more = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int[] arr : matches) {
            if(loss.contains(arr[1]) || more.contains(arr[1])) {
                loss.remove(arr[1]);
                more.add(arr[1]);
            }
            else{
                loss.add(arr[1]);
                if(won.contains(arr[1])) won.remove(arr[1]);
            }
            if(!loss.contains(arr[0]) && !more.contains(arr[0])) {
                won.add(arr[0]);
            }
        }
        res.add(new ArrayList<>(won));
        res.add(new ArrayList<>(loss));
        Collections.sort(res.get(0));
        Collections.sort(res.get(1));
        return res;
    }
}