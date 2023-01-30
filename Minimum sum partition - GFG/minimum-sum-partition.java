//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int solve(int[] arr, int n, int[][] dp, int sum, int idx, int total) {
        if(idx == n) return Math.abs(total - (2 * sum));
        if(dp[idx][sum] != -1) return dp[idx][sum];
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, solve(arr, n, dp, sum + arr[idx], idx + 1, total));
        ans = Math.min(ans, solve(arr, n, dp, sum, idx + 1, total));
        return dp[idx][sum] = ans;
    }

	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0;
	    for(int i : arr) sum += i;
	    int[][] dp = new int[n][sum];
	    for(int[] i : dp) Arrays.fill(i, -1);
	    return solve(arr, n, dp, 0, 0, sum);
	} 
}
