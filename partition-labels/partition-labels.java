class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch-'a'] = i;
        }
        //System.out.println(Arrays.toString(arr));
        int left = 0, right = 0;
        var ans = new ArrayList<Integer>();
        while(left < s.length() && right < s.length()) {
            while(left <= right) {
                right = Math.max(arr[s.charAt(left)-'a'], right);
                left++;
            }
            right++;
            ans.add(right);
        }
        for(int i=ans.size()-1; i>0; i--) ans.set(i, ans.get(i)-ans.get(i-1));
        //System.out.println(ans);
        return ans;
    }
}