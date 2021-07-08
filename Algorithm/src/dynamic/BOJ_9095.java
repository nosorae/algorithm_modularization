package dynamic;

/*
 * 2021.07.08
 * BOJ 9095 1,2,3���ϱ� https://www.acmicpc.net/problem/9095
 * N��° ���� N-1��°���� +1�Ѱ��, N-2��°���� +2�� ���, N-3��°���� +3�� ��찡 �ִ�.
 * �� ���������� n������ 11�̱� ������ ��Ÿ�� �������� ���� �̷��� �ߴ�. �׷��� ���ϸ� 1�Է��� �� ��Ÿ�� ������ ����.
 */
import java.util.*;
import java.io.*;
public class BOJ_9095 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(br.readLine());
		for(int l = 0; l < loop; l++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[12]; //�� ���������� n������ 11�̱� ������ ��Ÿ�� �������� ���� �̷��� �ߴ�.
			dp[0] = 1;
			dp[1] = 1; 
			dp[2] = 2; // �׷��� ���ϸ� 1�Է��� �� ��Ÿ�� ������ ����.
			for(int i = 3; i <= n; i++) {
				dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]);
			}
			System.out.println(dp[n]);
		}
		
	}
}
		
