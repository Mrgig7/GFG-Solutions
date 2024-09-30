//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the curr node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the curr node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the curr node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root1 = buildTree(s);

            s = br.readLine();
            Node root2 = buildTree(s);

            Solution T = new Solution();
            List<Integer> ans = T.merge(root1, root2);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();

            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java


// class Node {
//     int data;
//     Node left, right;

//     public Node(int d) {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
public void helper(Node r, Node[] h) {
    if (r == null) {
        return;
    }

    helper(r.right, h);
    
    r.right = h[0];

    if (h[0] != null) {
        h[0].left = r;
    }

    h[0] = r;

    helper(r.left, h);
}

public Node merger(Node a, Node b) {
    Node d = new Node(0);
    Node t = d;
    
    while (true) {
        if (a == null) {
            t.right = b;
            break;
        }

        if (b == null) {
            t.right = a;
            break;
        }

        if (a.data <= b.data) {
            t.right = a;
            a.left = t;
            a = a.right;
        } else {
            t.right = b;
            b.left = t;
            b = b.right;
        }

        t = t.right;
    }

    Node res = d.right;
    res.left = null; 
    return res;
}

public List<Integer> lister(Node n) {
    List<Integer> list = new ArrayList<>();
    
    while (n != null) {
        list.add(n.data);
        n = n.right;
    }
    
    return list;
}

public List<Integer> merge(Node r1, Node r2) {
    Node[] h1 = {null};
    Node[] h2 = {null};

    helper(r1, h1);
    helper(r2, h2);
    Node mergedHead = merger(h1[0], h2[0]);
    return lister(mergedHead);
}
}