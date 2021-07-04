package bruteforce;

/*
 * BOJ 10937 �������� https://www.acmicpc.net/problem/10973
 */
import java.util.*;
import java.io.*;

public class BOJ_10937 {
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] permutation = new int[n];
		for(int i = 0; i < n; i++) {
			permutation[i] = i+1;
		}
		if(prev_permutation(permutation))
			print_array(permutation);
		else
			System.out.println(-1);
		
	}
	static void print_array(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	static boolean prev_permutation(int[] perm) {
		int len = perm.length;
		int idx = len - 1;
		// ���������� ������ �ٷ� �����. ~�� �����ϴ� ù�����̶�� ������ ~�� �ٷ� ���� �ε����� ã���ִ� �۾�
		while(idx > 0 && perm[idx-1] <= perm[idx])
			idx--;
		if(idx == 0)
			return false;
		
		// lastIdx���� �ٷ� ���� ���Ҹ� lastIdx���ҿ� �ٲ��ش�.
		int lastIdx = idx - 1;
		idx = len - 1;
		while(perm[lastIdx] <= perm[idx])
			idx--;
		
		swap(perm, lastIdx, idx);
		reverse(perm, lastIdx+1, len-1);
		
		return true;
	}
	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	static void reverse(int[] arr, int left, int right) {
		while(left < right) {
			swap(arr, left, right);
			left++;
			right--;
		}
	}
}



