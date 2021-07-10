
/*
 * 2021.07.10
 * BOJ 11055 ���� ū ���� �κ� ���� https://www.acmicpc.net/problem/11055
 * d[i]�� �ε��� i���� ������� �� ���� ���� ū ���� �κ� ������ �����Ѵ�.
 * d[i]�� d[j] (0 <= j < i)�߿�  val[j] < val[i] �߿� d[j]�� �ִ��� d[j] + val[i]�̴�.Ŀ��
 */   

import java.util.*;
import java.io.*;
public class Main  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] value = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			value[i] = Integer.parseInt(st.nextToken());
			dp[i] = value[i];
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(value[j] < value[i] && dp[i] < dp[j]+value[i]) {
					dp[i] = dp[j]+value[i];
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			ans = max(ans, dp[i]);
		}
		bw.write(ans+""); bw.flush();
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
}


