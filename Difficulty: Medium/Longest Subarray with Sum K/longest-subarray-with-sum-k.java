//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int longestSubarray(int[] a, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int r = 0;
        int pSum = 0;

        for (int i = 0; i < a.length; ++i) {
            pSum += a[i];

            if (pSum == k) 
                r = i + 1;

            else if (m.containsKey(pSum - k)) 
                r = Math.max(r, i - m.get(pSum - k));

            if (!m.containsKey(pSum))
                m.put(pSum, i);
        }

        return r;
    }
}
