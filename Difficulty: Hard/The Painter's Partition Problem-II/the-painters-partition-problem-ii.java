//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
          static int getMax(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    static long getSum(int arr[], int n) {
        long total = 0;
        for (int i = 0; i < n; i++)
            total += arr[i];
        return total;
    }

    static int numberOfPainters(int arr[], int n, long maxLen) {
        long total = 0, numPainters = 1;

        for (int i = 0; i < n; i++) {
            if (total + arr[i] > maxLen) {
                total = arr[i];
                numPainters++;
            } else {
                total += arr[i];
            }
        }

        return (int) numPainters;
    }

    static long minTime(int arr[], int n, int k) {
        long lo = getMax(arr, n);
        long hi = getSum(arr, n);

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            int requiredPainters = numberOfPainters(arr, n, mid);
            if (requiredPainters <= k)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }

 }



