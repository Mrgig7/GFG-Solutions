//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends




class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
         KnightPos[0]--;
        KnightPos[1]--;
        TargetPos[0]--;
        TargetPos[1]--;

        boolean visited[][] = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{KnightPos[0], KnightPos[1], 0});
        visited[KnightPos[0]][KnightPos[1]] = true;
        int[][] directions = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == TargetPos[0] && current[1] == TargetPos[1]) {
                return current[2];
            }
            for (int[] dir : directions) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new int[]{x, y, current[2] + 1});
                }
            }
        }
        return -1;
    }
}