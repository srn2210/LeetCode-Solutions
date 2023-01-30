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
    int solve(int[] arr, int n, int[][] dp, int target, int idx, int sum) {
        if(idx == n) return Math.abs(sum - (2 * target));
        if(dp[idx][target] != -1) return dp[idx][target];
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, solve(arr, n, dp, target + arr[idx], idx + 1, sum));
        ans = Math.min(ans, solve(arr, n, dp, target, idx + 1, sum));
        return dp[idx][target] = ans;
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
