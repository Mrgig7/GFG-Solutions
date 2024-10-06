//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    void DFS(char[][] g, int r, int c) {
        int R = g.length, C = g[0].length;
        if (r < 0 || c < 0 || r >= R || c >= C || g[r][c] != '1') return;

        g[r][c] = '0';
        int[] rN = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] cN = {0, 0, 1, -1, 1, -1, -1, 1};

        for (int i = 0; i < 8; ++i) {
            DFS(g, r + rN[i], c + cN[i]);
        }
    }

    public int numIslands(char[][] g) {
        int R = g.length, C = g[0].length, cnt = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (g[r][c] == '1') {
                    cnt++;
                    DFS(g, r, c);
                }
            }
        }
        return cnt;
    }
}
