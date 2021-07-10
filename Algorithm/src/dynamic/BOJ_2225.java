package dynamic;

/*
 * 2021.07.08
 * BOJ 2225 �պ��� https://www.acmicpc.net/problem/2225
 * 0���� N������ �� K���� ���ؼ� ���� N�� �Ǵ� ����� ���� ���ϴ� ����
 * d[i][j]�� 0���� i���� �� �߿� j���� ���ؼ� �� ���� i�� �Ǵ� ����� ���� �����Ѵ�.
 * d[i][j]�� d[i-u][j-1] (0 <= u <= i) �� ���̴�.
 * d[0][i] (0 <= i <= K)�� 1�� �����Ѵ�.
 * �� ������ �信 ������ ������ �϶�� �� ���� ���� ���� Ŀ�� �� ������ long�� ���ش�.
 */

import java.util.*;
import java.io.*;
public class BOJ_2225  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[][] dp = new long[n+1][k+1];
		for(int i = 1; i <= k; i++) {
			dp[0][i] = 1; 
		}
		for(int i = 1; i <= n; i++) {
			dp[i][1] = 1;
		}
		for(int i = 2; i <= k; i++) { // �� 
			for(int j = 1; j <= n; j++) { // ��
				for(int u = 0; u <= j; u++) { // �� ���� 0~j�� ��� dp������ �� 
					dp[j][i] += dp[u][i-1]%1000000000;
				}
				dp[j][i] %= 1000000000;
			}
		}
		bw.write(dp[n][k]+""); bw.flush();
	}
	
}