package bruteforce;

import java.util.Scanner;
/*
 * BOJ 3085 �������� https://www.acmicpc.net/problem/3085
 * N*N 2���� �迭���� ���ڰ� �ٸ� 4���� ���� ��ĭ�� �ٲ㺸�� �� ���� ���� ������ ���ӵ� �ִ� ���� ���
 * �� �ٲ�� �ִ밡 ���� ���� �� ���� ������ �� �غ����� �� ����, �ִ�ũ�� 50�ۿ� �ȵǴ� O(N^2)�̾ ���Ʈ������ �غ��� �ϴ�
 * �ٲٴ� ���� ������̹Ƿ� 0,0���� �����Ѵٰ� �������� �� ���� �Ʒ��� ������ ������ ĭ�� Ȯ���ϸ� ��üȮ���� �����ϴ�.
 * �ٲٰ� ���󺹱� �ϰ� ���ϰ� �߿��ϴ�. 
 * �ٲٰ��� ���� ��ġ�� ���� ������ �ۿ� ���� ������ �ణ�̶� ��������� ���� ���κи� Ȯ�����־���.
 * ����, �� ������ ���� ū ���� ã��, ���� Ž��, ����Ž��  �Լ� 4�� ���� �ذ��ߴ�.
 * colLine rowLine�Լ����� else ���� localMax�� �����ϴ� �ڵ带 �־����� �������� ó������ ���߾���. �������ε��� ó���� ����ϰ� �� ��!
 * �Ʒ� ���� �ҽ��� �ٲ� ������ ��� ���� Ȯ���ϴ� �ҽ��̴�.
 * 
 */
//�Է��� �̷� �����ϴ�... 
//char[][] a = new char[n][n];
//for (int i=0; i<n; i++) {
//	a[i] = sc.next().toCharArray();
//}
public class BOJ_3085 {
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int n = sc.nextInt();
		sc.nextLine();
		char[][] candies = new char[n][n];
		

		for(int i = 0; i < n; i++) {
			String input = sc.nextLine();
			for(int j = 0; j < n; j++) {
				candies[i][j] = input.charAt(j);
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				if(i+1 < n) {
					swap(candies, i, j, i+1, j);
					int temp = findMaxNum(rowLine(candies, i), rowLine(candies, i+1), colLine(candies, j));
					if(max < temp)
						max = temp;
					swap(candies, i, j, i+1, j);
				}
				if(j+1 < n) {
					swap(candies, i, j, i, j+1);
					int temp = findMaxNum(colLine(candies, j), colLine(candies, j+1), rowLine(candies, i));
					if(max < temp)
						max = temp;
					swap(candies, i, j, i, j+1);

				}
			}
		}
		System.out.println(max);

	}
	static void swap(char[][] arr, int x, int y, int nx, int ny) {
		char temp = arr[x][y];
		arr[x][y] = arr[nx][ny];
		arr[nx][ny] = temp;
	}
	//�ִ� ������ �� �࿡�� ã�� �Լ�
	static int rowLine(char[][] arr, int line) {
		int localMax = 1;
		int cur = 1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[line][i-1] == arr[line][i])
				cur++;
			else 
				cur = 1;

			if(localMax < cur)
				localMax = cur;
		}
		return localMax;
	}
	//�ִ� ������ �� ������ ã�� �Լ�
	static int colLine(char[][] arr, int line) {
		int localMax = 1;
		int cur = 1;
		for(int i = 1; i < arr[0].length; i++) {
			if(arr[i-1][line] == arr[i][line])
				cur++;
			else 
				cur = 1;

			if(localMax < cur)
				localMax = cur;
		}
		return localMax;
	}
	static int findMaxNum(int a, int b, int c) {
		int max = a;
		if(max < b)
			max = b;
		if(max < c)
			max = c;
		return max;
	}

}

//import java.util.*;
//public class Main {
//    static int check(char[][] a) {
//        int n = a.length;
//        int ans = 1;
//        for (int i=0; i<n; i++) {
//            int cnt = 1;
//            for (int j=1; j<n; j++) {
//                if (a[i][j] == a[i][j-1]) {
//                    cnt += 1;
//                } else {
//                    cnt = 1;
//                }
//                if (ans < cnt) ans = cnt;
//            }
//            cnt = 1;
//            for (int j=1; j<n; j++) {
//                if (a[j][i] == a[j-1][i]) {
//                    cnt += 1;
//                } else {
//                    cnt = 1;
//                }
//                if (ans < cnt) ans = cnt;
//            }
//        }
//        return ans;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        char[][] a = new char[n][n];
//        for (int i=0; i<n; i++) {
//            a[i] = sc.next().toCharArray();
//        }
//        int ans = 0;
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                if (j+1 < n) {
//                    char t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t;
//                    int temp = check(a);
//                    if (ans < temp) ans = temp;
//                    t = a[i][j]; a[i][j] = a[i][j+1]; a[i][j+1] = t;
//                }
//                if (i+1 < n) {
//                    char t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
//                    int temp = check(a);
//                    if (ans < temp) ans = temp;
//                    t = a[i][j]; a[i][j] = a[i+1][j]; a[i+1][j] = t;
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//}


