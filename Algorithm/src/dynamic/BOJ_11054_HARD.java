package dynamic;

/*
 * 2021.07.11
 * BOJ 11054 ���� �� ������� �κ� ���� https://www.acmicpc.net/problem/11054
 * � �� �������� ���������̴ٰ� �� �� �������� ���������Ǵ� �κ� ������ ������� �κ� �����̶��ϴµ� �ִ���̸� ã�� ����
 * d[i]�� 0���� i���� �������� ������� �� ���� �� �����ϴ� �κм����� �����ϰ�
 * d2[i]�� n-1���� i���� ��������  ������� �� ���� �� �����ϴ� �κм����� �����Ѵ�. 
 * �׸��� d[i]+d2[i] ( 0 <= i < n ) �߿��� �ִ븦 ���ϰ� �ű⿡ -1�ؼ� ���� ����.
 * ������ ��ȭ���� ������ Ǯ���� ����(���� �� ����, �����ϴ� �κм���)�� �����ϴ�.
 */   

import java.util.*;
import java.io.*;
public class BOJ_11054_HARD  {
	static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] up = new int[n];
		int[] down = new int[n];
		int[] val = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			val[i] = Integer.parseInt(st.nextToken());
			up[i] = down[i] = 1;
		}
		//0���� ���������� ���� �� �����ϴ� �κм���
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(val[j] < val[i] && up[i] < up[j]+1) {
					up[i] = up[j]+1;
				}
			}
		}
		//n-1���� �������� ���� �� �����ϴ� �κм��� 
		for(int i = n-1; i >= 0; i--) {
			for(int j = n-1; j > i; j--) {
				if(val[i] > val[j] && down[i] < down[j]+1) {
					down[i] = down[j]+1;
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(ans < up[i]+down[i]) 
				ans = up[i]+down[i];
		}
		bw.write((ans-1)+""); bw.flush();
	}
}


