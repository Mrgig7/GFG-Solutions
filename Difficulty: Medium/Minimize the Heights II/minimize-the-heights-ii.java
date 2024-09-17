//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) {
            return 0; // Only one tower, no difference
        }
        
        // Sort the array
        Arrays.sort(arr);
        
        // Initialize the minimum difference as the difference between the highest and lowest elements
        int initialDiff = arr[n-1] - arr[0];
        int minDiff = initialDiff;

        // Consider all cases to compute the possible minimal difference
        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0) continue; // Skip if subtracting k results in negative value
            
            int newMin = Math.min(arr[0] + k, arr[i] - k);
            int newMax = Math.max(arr[n-1] - k, arr[i-1] + k);
            minDiff = Math.min(minDiff, newMax - newMin);
        }
        
        return minDiff;
    }
}