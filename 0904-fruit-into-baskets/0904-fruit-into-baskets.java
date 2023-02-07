class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        for(int left=0, right=0; right<fruits.length; right++) {
            if(map.containsKey(fruits[right])) {
                map.put(fruits[right], map.get(fruits[right]) + 1);
            }
            else if(!map.containsKey(fruits[right]) && map.size() < 2) {
                map.put(fruits[right], 1);
            }
            else if(!map.containsKey(fruits[right]) && map.size() == 2) {
                while(left < right) {
                    map.put(fruits[left], map.get(fruits[left])-1);
                    if(map.get(fruits[left]) == 0) {
                        map.remove(fruits[left]);
                        left++;
                        break;
                    }
                    left++;
                }
                map.put(fruits[right], 1);
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}