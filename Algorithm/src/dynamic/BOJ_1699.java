package dynamic;


/*
 * 2021.07.08
 * BOJ 1699 �������� ��
 * � ������ �׺��� ���� ������ ���������� ������ ǥ���� �� �ִµ�, ���� �ּҰ��� ã�� ����.
 * d[i]�� i�� �������� �յ� �߿� �ּ����� ������ �����Ѵ�.
 * d[i] d[i-1^2], d[i-2^2], d[i-3^2] ... d[0] �߿� �ּ� ���� ���� +1�� ���� �ȴ�.
 * d[1] = 1�� �ʱ�ȭ�Ѵ�.
 * d[i]�ϳ��� ���ϴµ� �ʿ��� �ִ�ð��� ��Ʈ 10�� �뷫 300�� �ȴ�. ���� 10���� 300���ص� 3õ������ �Ҹ��ϴ�.
 */

import java.util.*;
import java.io.*;
public class BOJ_1699  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1]+1;
			for(int j = 2; j*j <= i; j++) {
				dp[i] = min(dp[i-j*j]+1, dp[i]);
			}
		}
		bw.write(dp[n]+""); bw.flush();
		
	}
	static int min(int a, int b) {
		return a < b ? a : b;
	}
}