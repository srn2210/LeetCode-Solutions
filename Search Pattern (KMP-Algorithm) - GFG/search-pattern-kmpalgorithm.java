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
        int j = 0, i = 1;
        while(i < m) {
            if(pat.charAt(i) == pat.charAt(j)) {
                pi[i++] = ++j;
            }
            else {
                if(j == 0) i++;
                else j = pi[j-1];
            }
        }
        var ans = new ArrayList<Integer>();
        j = 0; i = 0;
        while(j < n) {
            if(txt.charAt(j) == pat.charAt(i)) {
                i++;
                j++;
                if(i == m) {
                    ans.add(j-m+1);
                    i = pi[i-1];
                }
            }
            else {
                if(i == 0) j++;
                else i = pi[i-1];
            }
        }
        return ans;
    }
}