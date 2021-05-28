package simulation;

import java.util.*;
/*
 * ���� 16967�� �迭 �����ϱ�
 * �ε����� �� ã���ָ� ���� ����
 */

public class BOJ_16967 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int[][] arrA = new int[h][w];
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[][] arrB = new int[h+x][w+y];
		
		//�Է�
		for(int i = 0; i < arrB.length; i++) {
			for(int j = 0; j < arrB[i].length; j++) {
				arrB[i][j] = sc.nextInt();
			}
		}
		
		//����
		for(int i = 0; i < arrA.length; i++) {
			for(int j  = 0; j <arrA[i].length; j++) {
				arrA[i][j] = arrB[i][j];
			}
		}
		
		//��ġ�� �κ� ���ֱ�
		for(int i = x; i < arrA.length; i++) {
			for(int j = y; j < arrA[i].length; j++) {
				arrA[i][j] = arrB[i][j] - arrA[i-x][j-y];
			}
		}
		
		//���
		for(int i = 0; i < arrA.length; i++) {
			for(int j = 0; j < arrA[i].length; j++) {
				System.out.print(arrA[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}

/*
 * �� Ǯ�̺��� �޸𸮸� ���Խ��. 
 * ���� �迭�� ũ���� for�� �� �� index�� ���� ��Ƽ� ����ȿ������ �ø��� ���̵� ä������
 */

//import java.util.*;
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int h = sc.nextInt();
//        int w = sc.nextInt();
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        int[][] a = new int[h+x][w+y];
//        for (int i=0; i<h+x; i++) {
//            for (int j=0; j<w+y; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        for (int i=0; i<h; i++) {
//            for (int j=0; j<w; j++) {
//                a[i+x][j+y] -= a[i][j];
//            }
//        }
//        for (int i=0; i<h; i++) {
//            for (int j=0; j<w; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}




