class Solution {
    public int getMaxLen(int[] nums) {
        
        int max = Integer.MIN_VALUE, count = 0, j = 0, pre = Integer.MAX_VALUE, suf = Integer.MIN_VALUE;
        boolean pos = true;
        ArrayList<ArrayList<Integer>> al = new ArrayList();
        al.add(new ArrayList());
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                j++;
                al.add(new ArrayList());
                continue;
            }
            al.get(j).add(nums[i]);
        }
        
        for(int i=0; i<al.size(); i++){
            for(int k=0; k<al.get(i).size(); k++){
                count++;
                if(al.get(i).get(k) < 0){
                    pos = !pos;
                    if(pre == Integer.MAX_VALUE){
                        pre = k;
                        pre++;
                    }
                    suf = Math.max(suf, k);
                }
            }
            suf = al.get(i).size() - suf;
            int min = Math.min(pre, suf);
            if(!pos) count = count - min;
            max = Math.max(max, count);
            pos = true;
            pre = Integer.MAX_VALUE;
            suf = Integer.MIN_VALUE;
            count = 0;
        }
        
        return max;
    }
}