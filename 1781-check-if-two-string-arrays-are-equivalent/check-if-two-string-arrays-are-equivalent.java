class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str = new StringBuilder();
        StringBuilder str1 = new StringBuilder();
        for(var word : word1) {
            str.append(word);
        }
        for(var word : word2) {
            str1.append(word);
        }
        return str1.toString().equals(str.toString());
    }
}