class Solution {
    boolean solve(int n, int[] left, int[] right, int idx, Set<Integer> set) {
        if(!set.add(idx)) return false;
        if(left[idx] != -1 && !solve(n, left, right, left[idx], set)) return false;
        if(right[idx] != -1 && !solve(n, left, right, right[idx], set)) return false;
        return true;
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        var set = new HashSet<Integer>();
        var root = new HashSet<Integer>();
        for(int i=0; i<n; i++) root.add(i);
        for(int i=0; i<n; i++) {
            root.remove(leftChild[i]);
            root.remove(rightChild[i]);
        }
        if(root.size() != 1) return false;
        return solve(n, leftChild, rightChild, root.iterator().next(), set) && set.size() == n;
    }
}