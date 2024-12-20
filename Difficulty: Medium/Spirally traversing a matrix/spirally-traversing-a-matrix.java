//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] m) {
        int r = m.length;
        int c = m[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        int t = 0, b = r - 1, l = 0, ri = c - 1;

        while (t <= b && l <= ri) {
            for (int i = l; i <= ri; ++i) {
                res.add(m[t][i]);
            }
            t++;

            for (int i = t; i <= b; ++i) {
                res.add(m[i][ri]);
            }
            ri--;

            if (t <= b) {
                for (int i = ri; i >= l; --i) {
                    res.add(m[b][i]);
                }
                b--;
            }

            if (l <= ri) {
                for (int i = b; i >= t; --i) {
                    res.add(m[i][l]);
                }
                l++;
            }
        }

        return res;
    }
}
