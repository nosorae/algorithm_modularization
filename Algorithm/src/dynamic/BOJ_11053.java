package dynamic;

/*
 * 2021.07.08
 * BOJ 11053 ���� �� �����ϴ� �κм��� https://www.acmicpc.net/problem/11053
 * ��ȭ���� ���Ǹ� i ���� �� �߿��� �׸��� ���� �ڽ�(i)���� ���� �� �߿��� �� ���� �������� ���� �� ������ ������ �ִ� �� + 1 �� �����Ѵ�.
 * �׷� ��ȭ���� dp[i] = if(A[i] > A[i-j]) max(dp[j]) ( 1 <= i < n, 0 <= j < i )
 * �ʱ�ȭ�� dp�� ��� ���Ҵ� 1�� �ʱ�ȭ�ϸ� �ȴ�. ���� �ϳ��� ������ ���� �� �����ϴ� �κм����� �ش��ϱ� �����̴�. ���� �ּҰ��� 1�� ǥ���ϸ� �ȴ�.
 * �׸��� ���������� dp�� ���Ұ��߿� max�� ã���ָ� �ȴ�.
 * �ð����⵵�� O(N^2)�̴�.
 */

import java.util.*;
import java.io.*;
public class BOJ_11053 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] values = new int[n];
		int[] dp = new int[n];
		StringTokenizer st =  new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++) dp[i] = 1;
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(values[j] < values[i] && dp[j] + 1 > dp[i])
					dp[i] = dp[j] + 1;
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