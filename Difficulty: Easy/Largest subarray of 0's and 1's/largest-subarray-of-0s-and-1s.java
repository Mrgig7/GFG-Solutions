//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxLen(int[] a) {
        HashMap<Integer, Integer> m = new HashMap<>();

        int pSum = 0;
        int r = 0;

        for (int i = 0; i < a.length; i++) {
            pSum += (a[i] == 0) ? -1 : 1;

            if (pSum == 0)
                r = i + 1;

            if (m.containsKey(pSum))
                r = Math.max(r, i - m.get(pSum));
            else
                m.put(pSum, i);
        }

        return r;
    }
}
