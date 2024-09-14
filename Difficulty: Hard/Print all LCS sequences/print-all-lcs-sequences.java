//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends
class Solution {
    static int MAX = 100;
    static int lcslen = 0;
    static int[][] dp = new int[MAX][MAX];

    static int lcs(String str1, String str2, int len1, int len2, int i, int j) {
        int ret = dp[i][j];
        if (i == len1 || j == len2)
            return ret = 0;
        if (ret != -1)
            return ret;
        ret = 0;
        if (str1.charAt(i) == str2.charAt(j))
            ret = 1 + lcs(str1, str2, len1, len2, i + 1, j + 1);
        else
            ret = Math.max(lcs(str1, str2, len1, len2, i + 1, j), lcs(str1, str2, len1, len2, i, j + 1));
        
        return dp[i][j] = ret;
    }

    static void printAll(String str1, String str2,int lenS,int lenT,char[] data, int indxS, int indxT, int currLCS, List<String> result) {

        if (currLCS == lcslen) {
            String seq = new String(data, 0, currLCS);
            result.add(seq);
            return;
        }
 
        if (indxS == lenS || indxT == lenT)
            return;
        
        for (char ch ='a'; ch <='z'; ch++) {
        boolean done = false;
            for (int i = indxS; i < lenS; i++) {
                if (ch == str1.charAt(i)) {
                    for (int j = indxT; j < lenT; j++) {
                        if (ch == str2.charAt(j) && dp[i][j] == lcslen - currLCS) {
                            data[currLCS] = ch;
                            printAll(str1,str2,lenS,lenT,data,i + 1,j + 1,currLCS + 1,result);
                            done = true;
                            break;
                        }
                    }
                }
                if (done)
                    break;
            }
        }
    }

    public List<String> all_longest_common_subsequences(String s, String t) {
        List<String> result = new ArrayList<>();
        int lenS = s.length();
        int lenT = t.length();
        for(int i=0;i<MAX;i++){
            for(int j=0;j<MAX;j++){
                dp[i][j]=-1;
            }
        }
        lcslen=lcs(s,t,lenS,lenT ,0 ,0);
        char[]data=new char[MAX];
        printAll(s,t,lenS,lenT,data ,0 ,0 ,0,result);
        return result;
    }
}