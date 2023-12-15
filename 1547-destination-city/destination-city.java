class Solution {
    public String destCity(List<List<String>> paths) {
        var set = new HashSet<String>();
        for(var path : paths) {
            set.add(path.get(0));
            set.add(path.get(1));
        }
        for(var path : paths) {
            set.remove(path.get(0));
        }
        return set.iterator().next();
    }
}