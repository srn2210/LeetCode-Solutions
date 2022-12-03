class Solution {
    public String frequencySort(String s) {
        int[][] arr = new int[128][2];
        for(int i=0; i<128; i++) {
            arr[i][0] = i;
        }
        for(char ch : s.toCharArray()) {
            arr[ch - '0'][1] += 1;
        }
        Arrays.sort(arr, (a,b) -> b[1] - a[1]);
        StringBuilder res = new StringBuilder();
        for(int i=0; i<128; i++) {
            if(arr[i][1] == 0) break;
            char ch = (char)(arr[i][0] + '0');
            for(int j=0; j<arr[i][1]; j++) {
                res.append(ch);
            }
        }
        return res.toString();
    }
}