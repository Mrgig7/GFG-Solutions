//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    public int longestConsecutive(int[] arr) {
        Set<Integer> st = new HashSet<>();
        int res = 0;
        for (int v : arr) st.add(v);
        for (int v : arr) {
            if (st.contains(v) && !st.contains(v - 1)) {
                int cur = v, cnt = 0;
                while (st.contains(cur)) {
                    st.remove(cur);
                    cur++;
                    cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}