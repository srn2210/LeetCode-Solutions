class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        HashMap<Character, Character> hm = new HashMap();
        List<String> list = new ArrayList();
        boolean flag = true;
        
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words[i].length(); j++) {
                if(hm.containsKey(pattern.charAt(j))) {
                    if(hm.get(pattern.charAt(j)) != words[i].charAt(j)) {
                        flag = false;
                    }
                }
                else if(hm.containsValue(words[i].charAt(j))) {
                        flag = false;
                }
                else {
                    hm.put(pattern.charAt(j), words[i].charAt(j));
                }
            }
            if(flag == true) list.add(words[i]);
            flag = true;
            hm.clear();
        }
        
        return list;
    }
}