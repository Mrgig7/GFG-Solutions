//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
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

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        if (arr.length <= 1)
            return 0;
        if (arr[0] >= arr.length-1)
            return 1;
        if (arr[0] == 0)
            return -1;
        int ma = arr[0];
        int st = arr[0];
        int pa = 1;
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1)
                return pa;
            if (arr[i] >= (arr.length-1) - i)
                return pa + 1;
            ma = Math.max(ma, i + arr[i]);
            st--;
            if (st == 0) {
                pa++;
                if (i >= ma)
                    return -1;
                st = ma - i;
            }
        }
 
        return -1;
    }
}