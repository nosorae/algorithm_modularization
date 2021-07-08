package dynamic;

/*
 * 2021.07.08
 * BOJ 11726 2*n Ÿ�ϸ� https://www.acmicpc.net/problem/11726
 * 2*nũ���� ���簢���� 2*1 1*2 Ÿ�Ϸ� ä��� ����� ���� ���ϴ� ����
 * 2*Nũ���� ���簢���� 2*N-2���� 1*2�ΰ� �׾Ƶδ� ��� + 2*N-1���� 2*1 �ϳ� �δ� ������� ǥ���� �� �ִ�. 
 */
import java.util.*;
import java.io.*;
public class BOJ_11726 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		System.out.println(dp[n]);
	}
}
		
