package dynamic;

/*
 * 2021.07.11
 * BOJ 13398 ������2 https://www.acmicpc.net/problem/13398
 * ������ �������� �߰��� �� �ϳ��� ������ ���� �ִ� ����.
 * �̰͵� ���� �� ������� �κм����� ���ϴ� �Ͱ� ����� ������� ���� ���� �� �ִ�.
 * ��·�� �ϳ��� �����غ����ϴµ� �� �õ��غ��⿣ �Է��� 10���̶� O(N^2)�� �Ұ����ϴ�. 
 * �׷��� �������� �������� ���Ѵ�. ���ʿ��� �����ϴ� �� �ϳ� �����ʿ��� �����ϴ� �� �ϳ�
 * �׷��� i(1<=i<=n-2)���� �ϳ��� ������, �Ȼ��� ������ ���ļ� ���߿��� �ִ븦 ���ϸ�ȴ�.
 * left[i]�� ���ʿ��� ������ �������� 0~i���� ������� ��, �ִ� �������̶�� �����Ѵ�.
 * left[i]�� left[i-1]+val[i]�� val[i]�� ������ �� ū ���� ������ ���̴�.
 * right[i]�� �����ʿ��� ���ʹ������� n-1~i���� ������� ��, �ִ� �������̶�� �����Ѵ�.
 * right[i]�� right[i+1]+val[i]�� val[i]�� ������ �� ū ���� ������ ���̴�.
 */

import java.util.*;
import java.io.*;
public class BOJ_13398  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] left = new int[n];
		int[] right = new int[n];
		int[] val = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			val[i] = Integer.parseInt(st.nextToken());
		}
		
		left[0] = val[0];
		for(int i = 1; i < n; i++) {
			left[i] = max(val[i], left[i-1]+val[i]);
		}
		
		right[n-1] = val[n-1];
		for(int i = n-2; i >= 0; i--) {
			right[i] = max(val[i], right[i+1]+val[i]);
		}
		
		//�ִ밪 ���� �� ������ ������ ���� �ϳ��� ���Ұ��� �ּҰ� -1000�̰�, �װ� �ִ� 10�����̴�  -1������ �ʱ�ȭ
		int ans = -100000000;
		// �������� �ʴ� ���
		for(int i = 0; i < n; i++) {
			//left�� right�� ���⸸ �ٸ������ҵ��� �ִ밪�� ����.
			ans = max(ans, left[i]);
		}
		
		// �����ϳ� �����ϴ� ���
		for(int i = 1; i < n-1; i++) {
			ans = max(ans, left[i-1]+right[i+1]);
		}
		
		bw.write(ans+""); bw.flush();
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
}


