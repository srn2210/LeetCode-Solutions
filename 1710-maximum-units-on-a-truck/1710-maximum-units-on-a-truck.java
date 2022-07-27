class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int max = 0;
        
        for(int[] i: boxTypes){
            if(truckSize >= i[0]){
                max += i[0] * i[1];
                truckSize -= i[0];
            }
            else if(truckSize < i[0]){
                max += truckSize * i[1];
                truckSize = 0;
            }
            else if(truckSize == 0) break;
        }
        
        return max;        
        
    }
}