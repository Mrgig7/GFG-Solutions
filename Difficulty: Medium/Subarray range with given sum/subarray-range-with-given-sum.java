//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    static int subArraySum(int arr[], int tar) {
        int n = arr.length;
        int sum = 0;
        int cnt = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (mp.containsKey(sum - tar)) {
                cnt += mp.get(sum - tar);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int tar = Integer.parseInt(br.readLine());
            Solution obj = new Solution();
            int res = obj.subArraySum(arr, tar);

            System.out.println(res);
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends