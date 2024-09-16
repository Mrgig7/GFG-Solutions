//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String s){
        int n = s.length();
        int ma = 0;
        int[] mem = new int[n];
        Arrays.fill(mem, -1);
        for (int i = 0; i < n; i++) {
            ma = Math.max(ma, helper(i, s, mem));
        }

        return ma; 
    }

    public static int helper(int i, String s, int[] mem) {
        if (i <= 0) {
            return 0;
        }

        if (mem[i] != -1) {
            return mem[i];
        }

        if (s.charAt(i) == '(') {
            mem[i] = 0;
        } else if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
            mem[i] = helper(i - 2, s, mem) + 2;
        } else if (s.charAt(i) == ')' && s.charAt(i - 1) == ')') {

            int len = helper(i - 1, s, mem);
            if (i - 1 - len >= 0 && s.charAt(i - 1 - len) == '(') {

                mem[i] = len + 2 + helper(i - len - 2, s, mem);
            } else {
                mem[i] = 0;
            }
        }

        return mem[i]; 
    
    }
}