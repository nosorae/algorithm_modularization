
/*
 * 2021.07.11
 * BOJ 13398 ������2 https://www.acmicpc.net/problem/13398
 * ������ �������� �߰��� �� �ϳ��� ������ ���� �ִ� ����.
 * �̰͵� ���� �� ������� �κм����� ���ϴ� �Ͱ� ����� ������� ���� ���� �� �ִ�.
 * ��·�� �ϳ��� �����غ����ϴµ� �� �õ��غ��⿣ �Է��� 10���̶� O(N^2)�� �Ұ����ϴ�. 
 * �׷��� �������� �������� ���Ѵ�. ���ʿ��� �����ϴ� �� �ϳ� �����ʿ��� �����ϴ� �� �ϳ�
 * �׷��� i(1<=i<=n-2)���� �ϳ��� ������, �Ȼ��� ������ ���ļ� ���߿��� �ִ븦 ���ϸ�ȴ�.
 */

import java.util.*;
import java.io.*;
public class Main  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] left = new int[n];
		int[] right = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			left[i] = Integer.parseInt(st.nextToken());
			right[i] = left[i];
		}
	}
	static int max(int a, int b) {
		return a > b ? a : b;
	}
}


