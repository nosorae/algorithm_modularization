package bruteforce;

/*
 * BOJ 10974 ������  https://www.acmicpc.net/problem/10973
 */
import java.util.*;
import java.io.*;

public class BOJ_10974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] permutation = new int[n];
		for(int i = 0; i < n; i++) {
			permutation[i] = i+1;
		}
		do {
			print_array(permutation);
		} while(next_permutation(permutation));
		
	}
	
	static void print_array(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
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



