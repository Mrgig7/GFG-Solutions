//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int[] a) {
        int n = a.length;
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = 1;
        }
        int p = 1;
        for (int i = 0; i < n; i++) {
            r[i] *= p;
            p *= a[i];
        }
        int s = 1;
        for (int i = n - 1; i >= 0; i--) {
            r[i] *= s;
            s *= a[i];
        }

        return r;
    }
}