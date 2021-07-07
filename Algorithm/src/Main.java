
/*
 * BOJ �ϴ� ���ڸ��� ���ϴ� �ͺ��� �����ڸ��� ����� �� ũ�Ը��� �� ������ �ݷʴ� 0�� �� ��� �����.
 * �׷��� ������ 1<= N, M <= 4�� ������ ���Ʈ������ �ذ��Ϸ��� �Ѵ�.
 * ��Ʈ����ũ�� ��� ����� ���� �� �غ��µ� ��Ʈ����ũ�� 1�����̹Ƿ�  
 * 1���� �迭�� �ε����� 2���� �迭ȭ�ؼ� ������ Ǯ���ش�.
 * �� ���̽����� �ϼ��� ���������� ���� ���� �Ľ��� �ʿ��ϴ�.
 */
import java.util.*;
import java.io.*;

public class Main {
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
					check[j/n][j%n] = true;
				}
			}
			int localAnswer = sumAllValue(paper, check);
			if(max < localAnswer)
				max = localAnswer;
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
				if(check[j][i]) {
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

