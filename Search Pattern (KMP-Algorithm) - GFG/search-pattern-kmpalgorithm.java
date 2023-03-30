//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        int m = pat.length();
        int n = txt.length();
        int[] pi = new int[m];
        int j = 0;
        for(int i=1; i<m; i++) {
            if(pat.charAt(i) == pat.charAt(j)) {
                pi[i] = j+1;
                j++;
            }
            else j=0;
        }
        j = -1;
        var ans = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
            while(j != -1 && txt.charAt(i) != pat.charAt(j+1)) j = pi[j]-1;
            if(pat.charAt(j+1) == txt.charAt(i)) j++;
            if(j == m-1) {
                ans.add(i-m+2);
                j = pi[j]-1;
            }
        }
        return ans;
    }
}