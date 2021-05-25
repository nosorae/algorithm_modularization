
import java.util.*;

/*
 * ���� 14499�� �ֻ��� ������
 * 3���� �ֻ����� ��� �迭�� ǥ���ұ�?
 * �ֻ����� ������ ������ �迭������� �ذ��غ���
 */

public class Main {

	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		int[][] arr = new int[n][m];
		int[] horizontal = new int[3];
		int[] vertical = new int[4];
		
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//ù ��ġ ���� ó��
		if(arr[x][y] == 0) {
			arr[x][y] = vertical[3];
		} else {
			vertical[3] = arr[x][y];
			arr[x][y] = 0;
		}
		
		
		
		for(int i = 0; i < k; i++) {
			int order = sc.nextInt();
			
			//���ó��
			int nx = x + dx[order];
			int ny = y + dy[order];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= m) 
				continue;
			
			x = nx; y = ny;
			
			
			
			//�ֻ��� ������
			if(order == 1) { //��
				int temp = horizontal[2];
				horizontal[2] = horizontal[1];
				horizontal[1] = horizontal[0];
				horizontal[0] = vertical[3];
				vertical[3] = temp;
				vertical[1] = horizontal[1];
			} else if(order == 2) { //��
				int temp = horizontal[0];
				horizontal[0] = horizontal[1];
				horizontal[1] = horizontal[2];
				horizontal[2] = vertical[3];
				vertical[3] = temp;
				vertical[1] = horizontal[1];
			} else if (order == 3) { //��
				push_left(vertical);
				horizontal[1] = vertical[1];
			} else { //��
				push_right(vertical);
				horizontal[1] = vertical[1];
				
			}
			
			//������ �ֻ��� �ظ� ó��
			if(arr[x][y] == 0) {
				arr[x][y] = vertical[3];
			} else {
				vertical[3] = arr[x][y];
				arr[x][y] = 0;
			}
			
			//��� ���� ���
			System.out.println(vertical[1]);
		}
		
		
		
		
		
		
		
		
	}
	
	
	static void push_left(int[] arr) {
		int temp = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = temp; 
		
	}
	static void push_right(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i = arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
	}

}

/*
 * ���⿡ �������� �ʰ� ������ �ϰԵǾ���.
 * ������ �����Ϸ��� ��� ���� ������ ������ �ľ��ϰ� �������� Ÿ�� ���� �պ����Ѵ�.
 */








