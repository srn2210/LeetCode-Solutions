class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] list2 = new int[26];
        List<String> ans = new ArrayList();
        
        for(int i=0; i<words2.length; i++) {
            int[] temp = new int[26];
            for(int j=0; j<words2[i].length(); j++) {
                temp[words2[i].charAt(j) - 'a'] += 1;
            }
            for(int j=0; j<26; j++) {
                list2[j] = Math.max(list2[j], temp[j]);
            }
        }
        
        for(int i=0; i<words1.length; i++) {
            
            int[] temp = new int[26];
            for(int j=0; j<words1[i].length(); j++) {
                temp[words1[i].charAt(j) - 'a'] += 1;
            }
            
            boolean flag = true;
            for(int j=0; j<26; j++) {
                if(list2[j] > temp[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag == false) continue;
            ans.add(words1[i]);
            
        }
        
        return ans;
    }
}