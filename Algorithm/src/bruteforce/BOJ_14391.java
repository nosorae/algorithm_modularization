package bruteforce;

/*
 * 2021.07.08
 * BOJ 14391 �ϴ� ���ڸ��� ���ϴ� �ͺ��� �����ڸ��� ����� �� ũ�Ը��� �� ������ �ݷʴ� 0�� �� ��� �����.
 * �׷��� ������ 1<= N, M <= 4�� ������ ���Ʈ������ �ذ��Ϸ��� �Ѵ�.
 * ��Ʈ����ũ�� ��� ����� ���� �� �غ��µ� ��Ʈ����ũ�� 1�����̹Ƿ�  
 * 1���� �迭�� �ε����� 2���� �迭ȭ�ؼ� ������ Ǯ���ش�.
 * �� ���̽����� �ϼ��� ���������� ���� ���� �Ľ��� �ʿ��ϴ�.
 * ������ ���� check�迭�� ���� �Լ��� �Ѱ��ְ�
 * ������ ���� �Լ� �ȸ���� i*m+j�� 2���� �ε����� 1����ȭ �ؼ� ��Ʈ����ũ�� ���ߴ�.
 */
import java.util.*;
import java.io.*;
public class BOJ_14391 {
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] paper = new int[n][m];
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			for(int j = 0; j < m; j++) {
				paper[i][j] = input.charAt(j) - '0';
			}
		}
		
		int max = 0;
		
		for(int i = 0; i < 1<<(n*m); i++) {
			boolean[][] check = new boolean[n][m]; // true�� �ش� ĭ�� ���δ�
			for(int j = 0; j < n*m; j++) {
				if((i & (1 << j)) != 0) {
					check[j/m][j%m] = true;
				}
			}
			int localAnswer = sumAllValue(paper, check);
			if(max < localAnswer) {
				max = localAnswer;
			}
			
				
		}
		
		System.out.println(max);
		
		
	}
	static int sumAllValue(int[][] paper, boolean[][] check) {
		int result = 0;
		//����
		for(int i = 0; i < n; i++) {
			int cur = 0;
			for(int j = 0; j < m; j++) {
				if(check[i][j]) {
					cur *= 10;
					cur += paper[i][j];
				}
				else {
					result += cur;
					cur = 0;
				}
			}
			result += cur;
		}
		//���� 
		for(int i = 0; i < m; i++) {
			int cur = 0;
			for(int j = 0; j < n; j++) {
				if(!check[j][i]) {
					cur *= 10;
					cur += paper[j][i];
				}
				else {
					result += cur;
					cur =0;
				}
			}
			result += cur;
		}
		return result;
	}

}



//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//public class Main {
//	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//		int[][] arr = new int[n][m];
//		for(int i = 0; i < n; i++) {
//			String str = br.readLine();
//			for(int j = 0; j < m; j++) {
//				arr[i][j] = str.charAt(j)-'0';
//			}
//		}
//		int max = 0;
//		int sum = 0;
//		for(int s = 0; s < (1<<n*m); s++) {
//			sum = 0;
//			//����
//			for(int i = 0; i < n; i++) { // i�� ��
//				int temp = 0;
//				for(int j = 0; j < m; j++) { // j�� ��
//					int idx = i*m+j;
//					if((s & (1<<idx)) == 0){
//						temp = temp*10 + arr[i][j];
//					}	
//					else {
//						sum += temp;
//						temp = 0;
//					}
//				}
//				sum += temp; // ������ m-1���� 0�� �߸� �ٹٲ޿��� �� �� �� ��������ϴϱ� 
//			}
//			//System.out.println("before : " + sum);
//			//����
//			for(int i = 0; i < m; i++) { // i�� ��
//				int temp = 0;
//				for(int j = 0; j < n; j++) { // j�� ��
//					int idx = i+j*m;
//					if((s & (1<<idx)) != 0){
//						temp = temp*10 + arr[j][i];
//					}	
//					else {
//						sum += temp;
//						temp = 0;
//					}
//				}
//				sum += temp; // ������ m-1���� 0�� �߸� �ٹٲ޿��� �� �� �� ��������ϴϱ� 
//				
//			}
//			//System.out.println("after : " + sum);
//			//�ִ밪 ����
//			if(max < sum) {
//				max = sum;
//			}
//		}
//		
//		System.out.println(max);
//	}
//
//}

