//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends

class Solve {
    int[] findTwoElement(int arr[]) {
        int n = arr.length;
        int xor1 = 0; 
        int sbit;
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            xor1 ^= arr[i];
            xor1 ^= (i + 1);  
        }

        sbit = xor1 & ~(xor1 - 1);

        for (int i = 0; i < n; i++) {
            if ((arr[i] & sbit) != 0) { x ^= arr[i]; }  
            else                            { y ^= arr[i]; }

            if (((i+1) & sbit) != 0)  { x ^= (i + 1); }
            else                            { y ^= (i + 1); }
        }

        boolean[] vis = new boolean[n + 1];
        int rep = -1;
        for (int num : arr) {
            if (vis[num]) {
                rep = num;
            }
            vis[num] = true;
        }

        
        int mis;
        if (!vis[x]) {
            mis = x;
        } else {
            mis = y;
        }

        return new int[] {rep, mis};
    }


}