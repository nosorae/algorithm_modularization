package dynamic;

/*
 * 2021.07.09
 * BOJ 11057 �������� https://www.acmicpc.net/problem/11057
 * �־��� N���̸�ŭ�� ���������� ����� ������ ���ϴ� ����
 * d[i][j]�� j�� ������ i������ �������� ������ �����Ѵ�.
 * d[i][j]�� d[i-1][k] (0<=k<=j)�� ���̴�.
 * �ð����⵵�� ��ǻ� O(N)�̴�?(for���ΰ��� N^2�� ũ�Ⱑ 9�� ������ �� �ִ�.) �Է��� ũ�Ⱑ �ִ� 
 */

import java.util.*;
import java.io.*;
public class BOJ_11057  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][10];
		for(int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= 9; j++) {
				for(int k = 0; k <= j; k++) {
					dp[i][j] += dp[i-1][k]%10007;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i <= 9; i++) {
			ans += dp[n][i];
		}
		bw.write((ans%10007)+""); bw.flush();
	}

}


