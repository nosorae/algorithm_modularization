package dynamic;

/*
 * 2021.07.08
 * BOJ 1912 ������ https://www.acmicpc.net/problem/1912
 * �迭�� ������ �־�����  �����ϴ� �Ѱ� �̻��� ������ ���߿��� �ִ� ���� ���ϴ� ����
 * �Է��� 10���̱⶧���� d[i]�ϳ��� ���ϴ� �ð� ���⵵�� O(1)�� �Ǿ���Ѵ�. �׷��� ��ü �ð����⵵�� O(N)�̴�.
 * �׸��� values�� ���Ұ��� ������ -1000���� �����ϹǷ� �ִ밪 ���� �� ������ ����ؾ��Ѵ�.
 * d[i]�� i��° ������ ������� �� �������� �ִ밪���� �����Ѵ�.
 * d[i]�� d[i-1]+val[i] �Ǵ�  val[i] �߿� ū ���̴�.
 * ��� d[i]�� val[i]�� �ʱ�ȭ�Ѵ�.
 */

import java.util.*;
import java.io.*;
public class BOJ_1912  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] values = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = values[0];
		for(int i = 1; i < n; i++) {
			dp[i] = max(dp[i-1]+values[i], values[i]);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			if(max < dp[i])
				max = dp[i];
		}
		bw.write(max+""); bw.flush();
		
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
}