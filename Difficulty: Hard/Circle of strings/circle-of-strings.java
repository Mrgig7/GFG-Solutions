//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    private void dfs(int st, List<Integer>[] adj, boolean[] vist) {
        vist[st] = true;
        for (int it : adj[st]) {
            if (!vist[it]) {
                dfs(it, adj, vist);
            }
        }
    }
    
    private boolean isCir(int s, List<Integer>[] adj, boolean[] sel) {
        boolean[] vist = new boolean[26];
        dfs(s, adj, vist);
        
        for (int i = 0; i < 26; i++) {
            if (!vist[i] && sel[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public int isCircle(String arr[]) {
        boolean[] sel = new boolean[26];
        List<Integer>[] adj = new ArrayList[26];
        int[] ic = new int[26];
        int[] oc = new int[26];
        
        for (int i = 0; i < 26; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (String s : arr) {
            int u = s.charAt(0) - 'a';
            int v = s.charAt(s.length() - 1) - 'a';
            sel[u] = sel[v] = true;
            ic[v]++;
            oc[u]++;
            adj[u].add(v);
        }
        
        for (int i = 0; i < 26; i++) {
            if (ic[i] != oc[i]) {
                return 0; 
            }
        }
        
        int st = -1;
        for (int i = 0; i < 26; i++) {
            if (sel[i]) {
                st = i;
                break;
            }
        }
        
        return isCir(st, adj, sel) ? 1 : 0; 
    }
}