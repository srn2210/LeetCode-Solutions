//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Minimum
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
              GfG gfg = new GfG();
            int Q = sc.nextInt();
            
            
            int st[] = gfg.constructST(arr, n);
            int l,r;
            for(int i = 0; i < Q; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                l = Math.min(a,b);
                r = Math.max(a,b);
                
                System.out.print(gfg.RMQ(st, n, l, r) + " ");
                
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/* The functions which 
builds the segment tree */
class GfG
{
    static int st[];
    
    public static int[] constructST(int arr[], int n)
    {
        // Add your code here
        st = new int[4 * n];
        buildTree(arr, 0, 0, n-1);
        return st;
    }
    
    static int buildTree(int[] arr, int index, int lo, int hi) {
        if(lo == hi) return st[index] = arr[lo];
        int mid = lo + (hi - lo) / 2;
        int left = buildTree(arr, 2 * index + 1, lo, mid);
        int right = buildTree(arr, 2 * index + 2, mid + 1, hi);
        return st[index] = Math.min(left, right);
    }
    
    /* The functions returns the
      min element in the range
      from l and r */
    
    static int query(int[] st, int l, int r, int lo, int hi, int index) {
        if(r < lo || l > hi) return Integer.MAX_VALUE;
        if(l <= lo && r >= hi) return st[index];
        int mid = lo + (hi - lo) / 2;
        int left = query(st, l, r, lo, mid, 2 * index + 1);
        int right = query(st, l, r, mid + 1, hi, 2 * index + 2);
        return Math.min(left, right);
    }
    
    public static int RMQ(int st[], int n, int l, int r)
    {
       // Add your code here
       return query(st, l, r, 0, n-1, 0);
    }
    
    
}