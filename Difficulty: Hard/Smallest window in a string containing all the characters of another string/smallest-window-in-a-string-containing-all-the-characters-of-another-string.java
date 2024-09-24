//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution {
    public static String smallestWindow(String s, String p) {
        int n = s.length();
        int m = p.length();
        
        if (n < m) {
            return "-1";
        }
        
        int[] freqP = new int[26];
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }

        int[] freqS = new int[26];
        
        int requiredChars = m;
        int minLen = Integer.MAX_VALUE;
        int minStart = -1;

        int start = 0;

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            freqS[currentChar - 'a']++;

            if (freqP[currentChar - 'a'] > 0 && freqS[currentChar - 'a'] <= freqP[currentChar - 'a']) {
                requiredChars--;
            }

            while (requiredChars == 0) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                char charAtStart = s.charAt(start);
                if (freqP[charAtStart - 'a'] > 0 && freqS[charAtStart - 'a'] == freqP[charAtStart - 'a']) {
                    requiredChars++;
                }
                freqS[charAtStart - 'a']--; 
                start++;
            }
        }

        return minStart == -1 ? "-1" : s.substring(minStart, minStart + minLen);
    }
}