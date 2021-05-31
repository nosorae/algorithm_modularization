package simulation;

import java.util.*;
/*
 * ���� 1917�� ������ü ������
 * ������ ������ ã�ƾ��Ѵٴ� ������ ����� ��������
 * ������ �����ϰ� �������� �� �˷��ִ� ���������� ���� ������������.
 * ������ü ������ Ư¡ 
 * 1. ���ڷ� �װ��� �������� �־���Ѵ�.
 * 2. ���ڷ� �װ��ִ� ������ �������� ���� ���ʿ� �ϳ��� �־���Ѵ�.
 * 
 */

public class BOJ_1917_Unsolved {
	static boolean[] cubeNum = new boolean[7];
	static int[] dx = {-1, 0, 1, 0 };
	static int[] dy = {0, 1, 0, -1 };
	static boolean[][] checkIdx = new boolean[6][6];
	static int[][] cube = {
			{ 0, 0, 0, 0 },
			{ 2, 6, 4, 5 },
			{ 1, 5, 3, 6 },
			{ 4, 6, 2, 5 },
			{ 1, 6, 3, 5 },
			{ 1, 4, 3, 2 },
			{ 1, 2, 3, 4 },
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int loop = 0; loop < 3; loop++) {

			int[][] arr = new int[6][6];
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 6; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int x = 0;
			int y = 0;
			boolean isFound = false;
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 6; j++) {
					if(arr[i][j] == 1) {
					
						for(int k = 1 ; k <= 6; k++) {
							cubeNum = new boolean[7];
							checkIdx = new boolean[6][6];
							cubeSearch(arr, i, j, k);
							if(isAllT(cubeNum)) {
								isFound = true;
								break;
							}
						}

					}	
				}

			}

			if(isFound)
				System.out.println("yes");
			else {
				System.out.println("no");
			}

			
		}


	}

	static void cubeSearch(int[][] arr, int x, int y, int idx) {
		cubeNum[idx] = true;
		checkIdx[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < 6 && ny >= 0 && ny < 6 && arr[nx][ny] == 1 && !checkIdx[nx][ny]) {
				cubeSearch(arr, nx, ny, cube[idx][i]);
			}
		}
	}
	static boolean isAllT(boolean[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(!arr[i])
				return false;
		}
		return true;
	}
}




