package dynamic;


/*
 * 2021.07.10
 * BOJ 1932 �����ﰢ�� https://www.acmicpc.net/problem/1932
 * d[i][j]�� i����� ������� �� �������� j���� ���ڸ� ����� ���� �ִ밪���� �����Ѵ�.
 * d[i][j]�� max(d[i-1][j-1], dp[i-1][j]) + val[i][j] �̴�.
 * �������� �䳾 ���� max(d[n][i]) ( 1<= i <= n)�� ������ ���� �ȴ�. 
 */

import java.util.*;
import java.io.*;
public class BOJ_1932  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		//�Է�
		int n = Integer.parseInt(br.readLine());
		int[][] value = new int[n+1][n+2];
		int[][] dp = new int[n+1][n+2];
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new  StringTokenizer(br.readLine());
			for(int j = 1; j <= i; j++) {
				value[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//�ʱ�ȭ�� ��ȭ�� ����
		dp[1][1] = value[1][1];
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + value[i][j];
			}
		}
		
		//�䳻�� �κ� 
		int ans = dp[n][1];
		for(int i = 2; i <= n; i++) {
			ans = max(ans, dp[n][i]);
		}
		bw.write(ans+""); bw.flush();	
				
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
}


