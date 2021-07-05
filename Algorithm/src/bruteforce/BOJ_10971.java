package bruteforce;
/*
 * BOJ 10971 ���ǿ� ��ȸ2
 * �� �湮�Ѵ�. + ������ ���� �ּҰ��� �߻��Ѵ�.
 * �ΰ��� ���� �ٰŷ� ��� ������ Ȱ���ؼ� �� �غ��� ���� ���غ��ٴ� ���ε��̴�. �翬�� ��ͷε� ���� �� �ִ�.
 * �� ȿ�������� �ϱ����ؼ�  �� �� ���ڸ� ������Ű�� ������ ���� �ִ�. 
 * ���� ��� 1 2 3 4 5/ 5 1 2 3 4/ 4 5 1 2 3/ 3 4 5 1 2/ 2 3 4 5 1
 * �� 5���� �� ���������� ��� ������ ����� �����ϱ� �׳� �ϳ��� �ϸ�ǰ� �� ������� �� ���ڸ� ������Ű�� �������� ���� ��ȸ�ϴ� ����� �ִ�.
 */
import java.util.*;
import java.io.*;

public class BOJ_10971 {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dist = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				dist[i][j] = sc.nextInt();
			}
		}
		int[] permutation = new int[n];
		for(int i = 0; i < n; i++) {
			permutation[i] = i;
		}
		
		int min = Integer.MAX_VALUE;
		do {
			int cur = get_dist_sum(dist, permutation);
			if(min > cur)
				min = cur;
		} while(next_permutation(permutation));
		
		System.out.println(min);
		
	}
	static int get_dist_sum(int[][] dist, int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			if(dist[arr[i]][arr[i+1]] == 0)
				return Integer.MAX_VALUE;
			sum += dist[arr[i]][arr[i+1]];
		}
		if(dist[arr[arr.length-1]][arr[0]] == 0)
			return Integer.MAX_VALUE;
		sum += dist[arr[arr.length-1]][arr[0]];
		return sum;
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



