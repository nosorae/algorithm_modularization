package dynamic;
/*
 * 2021.07.08
 * BOJ 2193 ��ģ�� https://www.acmicpc.net/problem/2193
 * ���̰� �־��� ��, 0���� ���� ���ϰ� 1�� �����ؼ� ������ �ʴ� �������� ������ ���ϴ� ����
 * ��ȭ���� ���̰� i�϶� 0���� ������ ������ 1�� ������ ������ ���� �������ָ� �ȴ�. 
 */


import java.util.*;
import java.io.*;
public class BOJ_2193 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n+1][2];
		dp[1][1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = dp[i-1][0];
		}
		bw.write((dp[n][0]+dp[n][1])+"");
		bw.flush();
	}
}