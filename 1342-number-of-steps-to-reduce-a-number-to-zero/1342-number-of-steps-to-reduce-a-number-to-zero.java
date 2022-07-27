class Solution {
    
    public int numberOfSteps(int num) {
        if(num==0)
            return 0;
     int totalSetBit =0;
     int msbPosition =0;
    
	
        while(num!=0) {
             msbPosition = num;
             num=num&(num-1);
             totalSetBit++;
         }
        	
        int pos=0;
         while(msbPosition>0) {
                msbPosition>>=1;
                pos++;
        }
         msbPosition=pos; 
        return totalSetBit+msbPosition-1;
    }
}