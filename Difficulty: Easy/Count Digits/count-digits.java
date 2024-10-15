//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.evenlyDivides(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    static int evenlyDivides(int n){
        //The old solution worked in O(log n );
        String s = String.valueOf(n);
        int a = 0;
        for(char c : s.toCharArray()){
            int b = c -'0';
            if(b==0) continue;
            if(n%b==0) a++;
        }
        
        return a;
    }
}