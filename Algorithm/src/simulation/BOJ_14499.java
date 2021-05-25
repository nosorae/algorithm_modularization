package simulation;

import java.util.*;

/*
 * ���� 14499�� �ֻ��� ������
 * 3���� �ֻ����� ��� �迭�� ǥ���ұ�? ������ �迭 �ϳ��� ǥ���غ���
 * �ֻ����� ������ ������ �迭������� �ذ��غ���
 */

public class BOJ_14499 {

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
 * �� ���ó������ ||�� �ؾ��ϴ� �� &&�� �ؼ� �ð� ��ƸԾ���.
 * ���� �ֻ��� �������� ����ؼ� ������ �迭 �� ���� ����ߴµ�, ������ �迭 �� ���� ����ؼ� �� �����ϰ� ������ �� �ִٴ� ���� ���޾Ҵ�.
 * �װ��� ��� ���� �ε���ȭ�ؼ� �ε����� �����̴� �͸� �ڵ�� �ű�� �Ǵ� ���̴�. �Լ�ȭ�� ���� ���� �� ����. 
 * ������ �����Ϸ��� ��� ���� ������ ������ �ľ��ϰ� �������� Ÿ�� ���� �պ����Ѵ�.
 */

//import java.util.*;
//public class Main {
//    static int[] dx = {0,0,-1,1};
//    static int[] dy = {1,-1,0,0};
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        int l = sc.nextInt();
//        int[][] a = new int[n][m];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        int[] dice = new int[7];
//        while (l-- > 0) {
//            int k = sc.nextInt() - 1;
//            int nx = x+dx[k];
//            int ny = y+dy[k];
//            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
//                // �ٱ����� �̵���Ű���� �ϴ� ��쿡�� �ش� ����� �����ؾ� ��, ��µ� �ϸ� �ȵ�
//                continue;
//            }
//            if (k == 0) { // right
//                int temp = dice[1];
//                dice[1] = dice[4];
//                dice[4] = dice[6];
//                dice[6] = dice[3];
//                dice[3] = temp;
//            } else if (k == 1) { // left
//                int temp = dice[1];
//                dice[1] = dice[3];
//                dice[3] = dice[6];
//                dice[6] = dice[4];
//                dice[4] = temp;
//            } else if (k == 2) { // up
//                int temp = dice[1];
//                dice[1] = dice[5];
//                dice[5] = dice[6];
//                dice[6] = dice[2];
//                dice[2] = temp;
//            } else { // down
//                int temp = dice[1];
//                dice[1] = dice[2];
//                dice[2] = dice[6];
//                dice[6] = dice[5];
//                dice[5] = temp;
//            }
//            x = nx;
//            y = ny;
//            if (a[x][y] == 0) {
//                // �ֻ����� ������ ��, �̵��� ĭ�� �� �ִ� ���� 0�̸�, �ֻ����� �ٴڸ鿡 �� �ִ� ���� ĭ�� �����
//                a[x][y] = dice[6];
//            } else {
//                // 0�� �ƴ� ��쿡�� ĭ�� �� �ִ� ���� �ֻ����� �ٴڸ����� ����Ǹ�,
//                dice[6] = a[x][y];
//                // ĭ�� �� �ִ� ���� 0�� �����
//                a[x][y] = 0;
//            }
//            System.out.println(dice[1]);
//        }
//    }
//}







