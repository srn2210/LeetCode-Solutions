class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int itr : nums) {
            if (!set.add(itr)) return true;
        }
        return false;
    }
}