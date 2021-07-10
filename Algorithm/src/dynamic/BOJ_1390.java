package dynamic;
/*
 * 2021.07.09
 * BOJ 1390 ������ https://www.acmicpc.net/problem/1309
 * N�� �־����� �� 2*N���� ĭ���� �̷���� ���簢���� ���ڵ��� ���μ��η� �������� �ʰ� ��ġ�ϴ� ����� ���� ���ϴ� ����
 * d[i][j]�� 2*i ���簢���� ���ڸ� ���μ��η� �������� �ʰ� ��ġ�ϴµ� ������ i��°���� j������� ���� ����Ǽ��� �����Ѵ�.
 * ���⼭ j�� 0�Ǵ� 1�Ǵ� 2�̰� ���� x x, o x, x o �̷��� ���ڸ� ��ġ�ϴ� ����̴�. �׷� ��ȭ���� ������ ����.
 * dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
 * dp[i][1] = dp[i-1][0] + dp[i-1][2]
 * dp[i][2] = dp[i-1][0] + dp[i-1][1]
 * dp[1][0], dp[1][1], dp[1][2] ������ 1�� �ʱ�ȭ�Ѵ�.
 * ���־��̴� ������ �ϵ��ڵ��������� static final������ �����ϴ� ������ ������ (�Ʒ� �� �����ڵ� ����)
 */
import java.util.*;
import java.io.*;
public class BOJ_1390  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][3];
		dp[1][0] = dp[1][1] = dp[1][2] = 1;

		for(int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901;
		}
		
		bw.write((dp[n][0]+dp[n][1]+dp[n][2])%9901 + "");
		bw.flush();
	}

}



//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int num = Integer.parseInt(br.readLine());
//		int[][] answer = new int[num+1][3];
//		int mod = 9901;
//		
//		answer[1][0] = 1;
//		answer[1][1] = 1;
//		answer[1][2] = 1;
//		for(int i = 2; i <=num; i++) {
//			answer[i][0] = (answer[i-1][0]+answer[i-1][1]+answer[i-1][2])%mod;
//			answer[i][1] = (answer[i-1][0]+answer[i-1][1])%mod;
//			answer[i][2] = (answer[i-1][0]+answer[i-1][2])%mod;
//			
//		}
//		
//		System.out.println((answer[num][0]+answer[num][1]+answer[num][2])%mod);
//		
//		
//		
//	}
//
//}


