class Solution {
    void storeWord(int start, int end, int len, List<String> ans, int width, String[] words) {
        int spaces = width - len;
        int numSpaces = end - start;
        int spcQ = 1;
        if(numSpaces != 0) spcQ = spaces / numSpaces;
        int extra = 0;
        if(numSpaces != 0) extra = spaces % numSpaces;
        StringBuilder res = new StringBuilder();
        for(int i=start; i<=end; i++) {
            res.append(words[i]);
            if(extra > 0) {
                for(int j=0; j<spcQ+1; j++) {
                    if(spaces > 0) {
                        res.append(' ');
                        spaces--;
                    }
                }
                extra--;
            }
            else {
                for(int j=0; j<spcQ; j++) {
                    if(spaces > 0) {
                        res.append(' ');
                        spaces--;
                    }
                }
            }
        }
        if(spaces > 0) for(int i=0; i<spaces; i++) res.append(' ');
        ans.add(res.toString());
    }
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int start = 0, end = 0, currLen = 0;
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            int numWords = currLen + word.length() + i - start;
            if(numWords > maxWidth) {
                storeWord(start, end, currLen, ans, maxWidth, words);
                start = i;
                end = i;
                currLen = word.length();
            }
            else {
                end = i;
                currLen += word.length();
            }
        }
        storeWord(start, end, currLen, ans, currLen+end-start, words);
        String s = ans.get(ans.size()-1);
        int size = s.length();
        for(int i=0; i<maxWidth-size; i++) s = s + " ";
        ans.set(ans.size()-1, s);
        return ans;
    }
}