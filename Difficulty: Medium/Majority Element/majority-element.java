//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     static int majorityElement(int[] arr) {
        int n = arr.length;
        int ma_idx = 0, cnt = 1;

        for (int i = 1; i < n; i++) {
            if (arr[ma_idx] == arr[i])
                cnt++;
            else
                cnt--;

            if (cnt == 0) {
                ma_idx = i;
                cnt = 1;
            }
        }
        return helper(arr, arr[ma_idx]) ? arr[ma_idx] : -1; 
    }

    static boolean helper(int[] a, int cand) {
        int i, cnt = 0;

        for (i = 0; i < a.length; i++) {
            if (a[i] == cand)
                cnt++;
        }

        return cnt > a.length / 2;
    }
}