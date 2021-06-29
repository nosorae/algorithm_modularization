package bruteforce;

/*
 * BOJ 14501 ���
 * �ɸ��� �ð� �迭, �׿� ���� ���̹迭�� �Է¹ް�
 * N+1�Ͽ� ���� �� �ִ� ������ �ִ밪�� ���ϴ� ����
 * �Է��� ���� ���� �𸣴ϱ� ���غ����ϴµ�, �� ��͸��� ���� �ϰ� ���ϰ� ���� ���̴�.
 * �׷��Ƿ� �ð����⵵��  2^15�̴�. 
 * ���ڿ� �� �����ϴ� ������ ��¥�� ��Ÿ���� day�� ���� ���ϱ� ���� ������ �� sum�̴�.
 */
import java.util.*;
import java.io.*;
public class BOJ_14501 {
	static int max;
	public static void main(String[] args) throws Exception {
		max = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] days = new int[n+1];
		int[] pays = new int[n+1];
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(st.nextToken());
			pays[i] = Integer.parseInt(st.nextToken());
		}
		pickAllCombination(days, pays, n, 1, 0);
		System.out.println(max);
	}
	static void pickAllCombination(int[] days, int[] pays, int n, int day, int sum) {
		if(day == n+1) {
			if(max < sum) 
				max = sum;
			return;
		}
		if(day > n+1)
			return;
		// ������ ���
		pickAllCombination(days, pays, n, day+days[day], sum + pays[day]);
		// ���� ���� ���
		pickAllCombination(days, pays, n, day+1, sum);
		
	}
}



