//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.longestIncreasingSubsequence(N, arr);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        int[] lis = new int[n];
        int[] prev = new int[n];
        for(int i = 0; i < n; i++) {
            lis[i] = 1;
            prev[i] = -1;
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    prev[i] = j;
                }
            }
        }
        
        int mi = 0;
        for(int i = 1; i < n; i++) {
            if(lis[i] > lis[mi]) {
                mi = i;
            }
        }
        
        return printLIS(prev, mi, arr);
    }

    private ArrayList<Integer> printLIS(int[] prev, int index, int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        for(; index >= 0; index = prev[index]) {
            result.add(0, arr[index]); 
        }
        return result;
    }
}
