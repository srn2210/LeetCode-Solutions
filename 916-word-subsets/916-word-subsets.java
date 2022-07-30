class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<int []> list1 = new ArrayList();
        int[] list2 = new int[26];
        List<String> ans = new ArrayList();
        
        for(int i=0; i<words1.length; i++) {
            ans.add(words1[i]);
            int[] temp = new int[26];
            for(int j=0; j<words1[i].length(); j++) {
                temp[words1[i].charAt(j) - 'a'] += 1;
            }
            list1.add(temp);
        }
        
        
        for(int i=0; i<words2.length; i++) {
            int[] temp = new int[26];
            for(int j=0; j<words2[i].length(); j++) {
                temp[words2[i].charAt(j) - 'a'] += 1;
            }
            for(int j=0; j<26; j++) {
                list2[j] = Math.max(list2[j], temp[j]);
            }
        }
        
        
        int[] remove = new int[list1.size()];
        
        for(int i=0; i<list1.size(); i++) {
            boolean flag = true;
            for(int j=0; j<26; j++) {
                if(list2[j] > list1.get(i)[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag == false) remove[i] = 1;
        }
        
        
        for(int i=remove.length-1; i>=0; i--) {
            if(remove[i] == 1) {
                ans.remove((int) i);
            }
        }
        
        return ans;
    }
}