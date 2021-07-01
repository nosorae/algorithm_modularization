
/*
 * BOJ 1248 �����
 * ��ǥ�� �����̰� �� ���ڰ� �������� ���ߴ� ���̴�. �迭 �Է¿� ���� ���� ���� ���� �𸣴� �� �غ��߰ڴ�.
 * �׸��� �ĺ��� -10~10���� 21���ε�  21^10�� �ʹ� ����. 
 * �׷��� �� �غ��� ��Ʈ��ŷ�� ����Ѵ�.
 * �ϴ� arr[i][i]�� ���� ��ȣ������ �� �� �ִ�. 10^10���� �پ���. 10,000,000,000..
 * arr[i][i]�� ���� ����� 1~10 ������ -10~-1 �׸��� 0�̸� 0���� �ְ� ���� ���ڸ� �õ��ϸ�ȴ�. 
 */
import java.util.*;
import java.io.*;

public class Main {
	static char[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		int[] ans = new int[n];
		String input = br.readLine();
		int idx = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				arr[i][j] = input.charAt(idx++);
			}
		}
		findAnswer(ans, 0);
		
	}
	static boolean findAnswer(int[] ans, int idx) {
		if(idx > 1 && !check(ans, idx)) 
			return false;
		
		if(idx == ans.length) {
			for(int i = 0; i < idx; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return true;
		}
		
		
		if(arr[idx][idx] == '0') {
			ans[idx] = 0;
			return findAnswer(ans, idx+1);
		}
		else {
			boolean flag = false;
			for(int i = 1; i <= 10; i++) {
				if(arr[idx][idx] == '-') {
					ans[idx] = -i;
					flag = findAnswer(ans, idx+1);
				}
				else {
					ans[idx] = i;
					flag = findAnswer(ans, idx+1);
				}
				if(flag)
					return true;
			}
		}
		return false;
	}
	
	static boolean check(int[] ans, int idx) {
		for(int i = 0; i < idx; i++) {
			int sum = 0;
			for(int j = i; j < idx; j++) {
				sum += ans[j];
				if(arr[i][j] == '+' && sum <= 0)
					return false;
				else if(arr[i][j] == '-' && sum >= 0)
					return false;
				else if(arr[i][j] == '0' && sum != 0)
					return false;
			}
		}
		return true;
	}
}



