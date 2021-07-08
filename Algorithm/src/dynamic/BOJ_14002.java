package dynamic;

/*
 * 2021.07.08
 * BOJ 14002 ���� �� �����ϴ� �κм���2  https://www.acmicpc.net/problem/14002
 * ���� �� �����ϴ� �κм���1�� �ٸ����� ��θ� ����ؾ��Ѵٴ� ���̴�. �׷��� ��� �ε����� dp���� ������ �� ���� �ε����� ����ؼ� 
 * ���� �ε��� ����� �ݴ�� ����� ����ϸ� ���������� ��θ� Ȯ���� �� �ִ�.
 * ��ȭ���� ���Ǹ� i ���� �� �߿��� �׸��� ���� �ڽ�(i)���� ���� �� �߿��� �� ���� �������� ���� �� ������ ������ �ִ� �� + 1 �� �����Ѵ�.
 * �׷� ��ȭ���� dp[i] = if(A[i] > A[i-j]) max(dp[j]) ( 1 <= i < n, 0 <= j < i )
 * �ʱ�ȭ�� dp�� ��� ���Ҵ� 1�� �ʱ�ȭ�ϸ� �ȴ�. ���� �ϳ��� ������ ���� �� �����ϴ� �κм����� �ش��ϱ� �����̴�. ���� �ּҰ��� 1�� ǥ���ϸ� �ȴ�.
 * �׸��� ���������� dp�� ���Ұ��߿� max�� ã���ָ� �ȴ�.
 * �ð����⵵�� O(N^2)�̴�.
 */


import java.util.*;
import java.io.*;
public class BOJ_14002  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {	
		
		int n = Integer.parseInt(br.readLine());
		int[] values = new int[n];
		int[] dp = new int[n];
		int[] prev = new int[n];
		// �Է� �� �ʱ�ȭ
		StringTokenizer st =  new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			prev[i] = -1;
		}
		
		// ���̳��� ���α׷���
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(values[j] < values[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
					prev[i] = j;
				}
					
			}
		}
		//���� ���� ���� 
		int max = 0;
		int maxIdx = 0;
		for(int i = 0; i < n; i++) {
			if(max < dp[i]) {
				max = dp[i];
				maxIdx = i;
			}
		}
		bw.write(max+"\n");
		// ��� ��� �Լ�
		traceBack(values, prev, maxIdx);
		bw.flush();
	}
	static void traceBack(int[] val, int[] prev, int start) throws IOException {
		int idx = start;
		Stack<Integer> stack = new Stack<>();
		while(prev[idx] != -1) {
			stack.add(val[idx]);
			idx = prev[idx];
		}
		stack.add(val[idx]);
		while(!stack.isEmpty()) {
			bw.write(stack.pop()+" ");
		}
	}
}