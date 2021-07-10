package dynamic;

/*
 * 2021.07.08
 * BOJ 15988 1,2,3���ϱ� 3 https://www.acmicpc.net/problem/15988
 * N��° ���� N-1��°���� +1�Ѱ��, N-2��°���� +2�� ���, N-3��°���� +3�� ��찡 �ִ�.
 * �� ���������� n������ 100000�̱� ������ ��Ÿ�� �������� ���� �迭�� ũ�⸦ 100001�� ��Ҵ�. �׷��� ���ϸ� 1�Է��� �� ��Ÿ�� ������ ����.
 * 1,2,3���ϱ� 1�� �ٸ� ���� �Է��� ũ�Ⱑ �е������� ũ�ٴ� ���̴�. 
 * �׷��� �ٲ��ִ� �� �迭�� ũ��� Ÿ���� int�� �ƴ� long���� �ϰ� ������ ���굵 �ִ´ٴ� ���̴�.
 */
import java.util.*;
import java.io.*;
public class BOJ_15988 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {	
		
		int loop = Integer.parseInt(br.readLine());
		long[] dp = new long[1000001]; //�� ���������� n������ 11�̱� ������ ��Ÿ�� �������� ���� �̷��� �ߴ�.
		dp[0] = 1;
		dp[1] = 1; 
		dp[2] = 2; // �׷��� ���ϸ� 1�Է��� �� ��Ÿ�� ������ ����.
		for(int i = 3; i <= 1000000; i++) {
			dp[i] = (dp[i-1]%1000000009 + dp[i-2]%1000000009 + dp[i-3]%1000000009)%1000000009;
		}
		for(int l = 0; l < loop; l++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp[n]+"\n");
		}
		bw.flush();
		
	}
}
		
