class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i=0; i<nums2.length; i++) {
            if(stack.isEmpty()) {
                stack.push(nums2[i]);
            }
            else if(nums2[i] < stack.peek()) {
                stack.push(nums2[i]);
            }
            else {
                while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                    map.put(stack.pop(), nums2[i]);
                }
                stack.push(nums2[i]);
            }
        }
        
        int[] ans = new int[nums1.length];
        
        for(int i=0; i<ans.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return ans;
    }
}