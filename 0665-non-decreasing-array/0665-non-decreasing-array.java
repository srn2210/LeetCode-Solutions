class Solution {
    /*boolean solve(int[] nums, int idx, int count) {
        if(idx == nums.length-1) return count <= 1;
        boolean ans = false;
        if(nums[idx] <= nums[idx+1]) ans = ans || solve(nums, idx+1, count);
        else {
            ans = ans || solve(nums, idx+1, )
        }
    }*/
    public boolean checkPossibility(int[] nums) {
        /*var st = new Stack<Integer>();
        int count = 0;
        for(int i : nums) {
            if(!st.isEmpty() && st.peek() > i) count++;
            else st.push(i);
        }
        System.out.println(st);
        return count <= 1;*/
        /*int left = 0;
        int right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(check(mid))
        }*/
        var list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<>());
        list.get(0).add(nums[0]);
        for(int i=1; i<nums.length; i++) {
            var lastList = list.get(list.size()-1);
            var lastElement = lastList.get(lastList.size()-1);
            if(nums[i] >= lastElement) lastList.add(nums[i]);
            else {
                var t = new ArrayList<Integer>();
                t.add(nums[i]);
                list.add(t);
            }
        }
        //System.out.println(list);
        //System.out.println(" ---- ");
        if(list.size() <= 1) return true;
        if(list.size() > 2) return false;
        if(list.get(0).size() == 1 || list.get(1).size() == 1) return true;
        if(list.get(0).get(list.get(0).size()-1) <= list.get(1).get(1) || list.get(0).get(list.get(0).size()-2) <= list.get(1).get(0)) return true;
        return false;
    }
}