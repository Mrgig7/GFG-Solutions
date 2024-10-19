//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java


class Solution {

    String roundToNearest(String str) {
       int n = str.length();
       int l = str.charAt(n-1)-'0';
       
       char[] di  = str.toCharArray();
       
       if(l<=5){
           di[n-1]='0';
       }
       else{
           di[n-1]='0';
           boolean car = true;
           
           for(int i = n-2; i>=0 ; i--){
               if(di[i] =='9')
                 di[i]= '0';
                 else{
                     di[i] = (char) (di[i] + 1);
                     car = false;
                     break;
                 }
           }
           if(car)
            return '1' + new String(di);
       }
       return new String(di);
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends