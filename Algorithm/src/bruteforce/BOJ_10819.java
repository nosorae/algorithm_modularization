package bruteforce;


/*
 * BOJ 10819 ���̸� �ִ�� https://www.acmicpc.net/problem/10819
 * ���������� ���ϴ� ���� �ݺ��ϸ� ���ҵ��� ��� ������ Ȯ���� �� �ִٴ� ���� Ȱ���Ѵ�.
 * ������ ���غ��� ����� ù�������� next�� ��� �θ��� ����� ���� ���ϴ�.
 * �ٵ� ���� ���ĵ� ���ϰ� ���� ������ �ҷ���. ������ �ȵǾ��ִٸ� ù������ �ƴ� �߰����� ������ ��ȸ�ؼ� ������ �ȴ�.
 */
import java.util.*;
import java.io.*;

public class BOJ_10819 {
	static int[] input;
	public static void main(String[] args) {
	
				
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		input = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input);
		
		int max = 0;
		do {
			int cur = get_custom_sum(input);
			if(max < cur)
				max = cur;
		} while(next_permutation(input));
		
		System.out.println(max);
	}
	static int get_custom_sum(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			sum += abs(arr[i], arr[i+1]);
		}
		return sum;
	}
	static int abs(int a, int b) {
		return a > b ? a-b : b-a;
	}
	// ���������� ���� ������ ���Ѵ�.
	static boolean next_permutation(int[] prev) {
		//�ڿ������� ���������� ������ �ϳ��� �ٿ�����.
		int idx = prev.length - 1;
		while(idx > 0 && prev[idx - 1] >= prev[idx]) 
			idx--;
		
		//��� ���� ���������̶�� ������ �����̴�.
		if(idx == 0)
			return false;
		// lastIdx������ ���ʿ��� �������� �� ���ķδ� ���������̴�. �� 0~lastIdx ���ķδ� ������ ����
		int lastIdx = idx - 1;
		// lastIdx���ķδ� ���������̱� ������ ������ ���� �ϳ��� �����ٰ� lastIdx���Һ��� ū ���� ã���� 
		// lastIdx�� �� ���� ���Ҹ� ã�� �� �ִ�.
		idx = prev.length - 1;
		while(prev[lastIdx] >= prev[idx]) idx--;
		
		// lastIdx���ҿ� lastIdx�� �� ���� ���Ҹ� �ٲ��ش�.
		swap(prev, lastIdx, idx);
		// �� ����� ���ο� lastIdx���ҷ� �����ϴ� ������ �����̴�.
		// �̸� ���ο� lastIdx���ҷ� �����ϴ� ù ������ �ٲ�����Ѵ�.
		reverse(prev, lastIdx + 1, prev.length - 1);
		
		return true;
	}
	static void swap(int[] prev, int a, int b) {
		int temp = prev[a];
		prev[a] = prev[b];
		prev[b] = temp;
	}
	// ������ �迭���� left~right ���ҵ��� �����´�.
	static void reverse(int[] prev, int left, int right) {
		while(left < right) {
			swap(prev, left, right);
			left++;
			right--;
		}
	}
}



