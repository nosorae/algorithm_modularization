package dynamic;


/*
 * 2021.07.08
 * BOJ 14501 ��� https://www.acmicpc.net/problem/14501
 * ����Ϻ��� ���̿� ���Ⱓ�� �־��� �� n+1�� ������ �������� �ִ븦 ���ϴ� ����
 * d[i]�� i�ϱ��� ������� �� �������� �ִ�� �����Ѵ�.
 * d[i]�� p[i]+i�� n+1���� �۰ų� ����, ���� d[k] (0 <= k < i)�� �߿� ����� �������鼭 ������ ������ ���� ���� ū ��¥�� �����Ѵ�.
 * ������ ���Ʈ�����ε� Ǯ������ ���� (�����ϰ� ���ϰ�� ����Լ��� �Ķ���͸� �����ϸ� ����ؼ� �ذ�)
 */

import java.util.*;
import java.io.*;
public class BOJ_14501  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n];
		int[] pay = new int[n];
		int[] dp = new int[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		if(time[0] <= n)
			dp[0] = pay[0];
		for(int i = 1; i < n; i++) {
			if(i + time[i] > n)
				continue;
			dp[i] = pay[i];
			for(int j = 0; j < i; j++) {
				if(j+time[j] <= i && dp[i] < pay[i] + dp[j])
					dp[i] = pay[i] + dp[j];
			}
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			if(max < dp[i])
				max = dp[i];
		}
		bw.write(max+""); bw.flush();
	}
	
}