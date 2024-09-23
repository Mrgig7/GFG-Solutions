//{ Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method */

class Solution
{
static boolean isKPartitionPossibleRec(int arr[], int subsetSum[], boolean taken[],int subset, int K, int N, int curIdx, int limitIdx){
	if (subsetSum[curIdx] == subset){
	       if (curIdx == K - 2) return true;
		return isKPartitionPossibleRec(arr, subsetSum, taken, subset,
											K, N, curIdx + 1, N - 1);
	}

	for (int i = limitIdx; i >= 0; i--)
	{
		if (taken[i])
			continue;
		int tmp = subsetSum[curIdx] + arr[i];
		if (tmp <= subset){
			taken[i] = true;
			subsetSum[curIdx] += arr[i];
			boolean nxt = isKPartitionPossibleRec(arr, subsetSum, taken,
											subset, K, N, curIdx, i - 1);

			taken[i] = false;
			subsetSum[curIdx] -= arr[i];
			if (nxt)
				return true;
		}
	}
	return false;
}

static boolean isKPartitionPossible(int arr[], int N, int K){
	if (K == 1)
		return true;

	if (N < K)
		return false;

	int sum = 0;
	for (int i = 0; i < N; i++)
		sum += arr[i];
	if (sum % K != 0)
		return false;

	int subset = sum / K;
	int []subsetSum = new int[K];
	boolean []taken = new boolean[N];

	// Initialize sum of each subset from 0
	for (int i = 0; i < K; i++)
		subsetSum[i] = 0;

	for (int i = 0; i < N; i++)
		taken[i] = false;
		
	subsetSum[0] = arr[N - 1];
	taken[N - 1] = true;
	return isKPartitionPossibleRec(arr, subsetSum, taken,
									subset, K, N, 0, N - 1);
}
}
