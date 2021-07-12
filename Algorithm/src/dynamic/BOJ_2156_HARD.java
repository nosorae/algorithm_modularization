package dynamic;

/*
 * 2021.07.10
 * BOJ 2156 �����ֽý� https://www.acmicpc.net/problem/2156
 * ���� ������ �����ð� ������ �������ܿ� ������ ���� ���� �ƴ� ������ �־����� �� ���� ���� �ִ밪�� ���ϴ� ����
 * d[i][j]�� i��° �����ܱ��� ������� �� j��° ���ӱ��� ���� ������ ���� �ִ밪���� �����Ѵ�. 
 * d[i][0] = d[i-1][j] (0 <= j <= 2) �߿� �ִ��̴�.
 * d[i][1] = d[i-1][0] + size[i];
 * d[i][2] = d[i-1][1] + size[i]; 
 * 
 */

import java.util.*;
import java.io.*;
public class BOJ_2156_HARD  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[10001][3];
		int[] size = new int[10001];
		for(int i = 1; i <= n; i++) {
			size[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1][1] = size[1];
		dp[2][0] = dp[1][1];
		dp[2][1] = size[2];
		dp[2][2] = dp[1][1] + size[2];
		for(int i = 3; i <= n; i++) {
			dp[i][0] = max(dp[i-1][0], dp[i-1][1]);
			dp[i][0] = max(dp[i][0], dp[i-1][2]);
			dp[i][1] = dp[i-1][0] + size[i];
			dp[i][2] = dp[i-1][1] + size[i];
		}
//		for(int i = 1; i <= n; i++) {
//			bw.write(dp[i][0]+" "+dp[i][1]+" "+dp[i][2]+"\n");
//		}
		int ans = max(dp[n][0], dp[n][1]);
		ans = max(ans, dp[n][2]);
	
		bw.write(ans+"");
		bw.flush();
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
}


