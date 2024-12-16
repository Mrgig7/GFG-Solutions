//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int aggressiveCows(int[] s, int k) {
        Arrays.sort(s);
        int l = 1, h = s[s.length - 1] - s[0], r = 0;

        while (l <= h) {
            int m = (l + h) / 2;
            int c = 1, last = s[0];

            for (int i = 1; i < s.length; i++) {
                if (s[i] - last >= m) {
                    c++;
                    last = s[i];
                }
                if (c >= k) break;
            }

            if (c >= k) {
                r = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return r;
    }
}