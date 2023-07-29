class Solution {
    double solve(int a, int b, Map<Pair<Integer, Integer>, Double> map) {
        if(a == 0 && b > 0) return 1.0;
        if(a == 0 && b == 0) return 0.5;
        if(a > 0 && b == 0) return 0;
        if(map.containsKey(new Pair<>(a, b))) return map.get(new Pair<>(a,b));
        double prob = solve(Math.max(a-100, 0), b, map) + solve(Math.max(0,a-75), Math.max(0,b-25), map) + solve(Math.max(0,a-50), Math.max(0,b-50), map) + solve(Math.max(0,a-25), Math.max(0,b-75), map);
        map.put(new Pair<>(a,b), prob/4);
        return prob / 4;
    }
    public double soupServings(int n) {
        if(n >= 5000) return 1.0;
        var map = new HashMap<Pair<Integer, Integer>, Double>();
        return solve(n, n, map);
    }
}