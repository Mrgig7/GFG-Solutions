//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends




class Solution{
    public int cutRod(int price[], int n) {
        int[] r = new int[n+1];
        Arrays.fill(r, Integer.MIN_VALUE);
        r[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                r[i] = Math.max(r[i], price[j-1] + r[i-j]);
        }
        return r[n];
    }
}