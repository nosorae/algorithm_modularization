package simulation;

import java.util.*;

//����ҽ��ڵ嵵 �м��غ� ��!

/*
 * ���� 2290�� LCD Test
 * s�� �־��� �׷��� ���� s+2  ���� 2*s+3 ���̷� ���ڸ� �׸�����ϴµ� ���� ����� ����
 * s�� ��ȭ�� ���� ����� ��� ���ϴ��� �����ؾ��Ѵ�.
 * �׸��� ���ڸ� ǥ���ϴ� ��Ҹ� �ε���ȭ�ؼ� �迭�� ǥ���ϰ� �ึ�� ���ڸ� ������ ����Ѵ�.
 */

public class BOJ_2290 {

	static int[][] arr = {
			{1, 1, 1, 0, 1, 1, 1}, //0
			{0, 0, 1, 0, 0, 1, 0}, //1 
			{1, 0, 1, 1, 1, 0, 1}, //2
			{1, 0, 1, 1, 0, 1, 1}, //3
			{0, 1, 1, 1, 0, 1, 0}, //4
			{1, 1, 0, 1, 0, 1, 1}, //5 
			{1, 1, 0, 1, 1, 1, 1}, //6
			{1, 0, 1, 0, 0, 1, 0}, //7
			{1, 1, 1, 1, 1, 1, 1}, //8
			{1, 1, 1, 1, 0, 1, 1}  //9
	};
	static int s;
	static String num;
	static int len;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		s = sc.nextInt();
		num = sc.next();
		len = num.length();
		
		//����1
		printHorizontal(arr, 0);
		//����1
		printVertical(arr, 1); 
		//����2
		printHorizontal(arr, 3);
		//����2 
		printVertical(arr, 4);
		//����3
		printHorizontal(arr, 6);
		


	}

	static void printBar(int isPrint, char c) {
		if(isPrint == 1)
			System.out.print(c);
		else
			System.out.print(" ");
	}
	
	static void printHorizontal(int[][] arr, int idx) {
		for(int i = 0; i < len; i++) {
			System.out.print(" ");

			for(int j = 0; j < s; j++) {
				printBar(arr[num.charAt(i)-'0'][idx], '-');
			}
			System.out.print("  "); // ������ �߰����� �ι� ����
		}
		System.out.println();
	}
	static void printVertical(int[][] arr, int idx) {
		for(int k = 0; k < s; k++) {
			for(int i = 0; i < len; i++) {
				printBar(arr[num.charAt(i)-'0'][idx], '|');
				for(int j = 0; j < s; j++)
					System.out.print(" ");
				printBar(arr[num.charAt(i)-'0'][idx+1], '|');
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
}

/*
 * character�� ���ڷ� ���� �� -'0' ���ִ� �� ������! 
 */

//import java.util.*;
//public class Main {
//    static final int[][] c = {
//        {1,1,1,0,1,1,1},
//        {0,0,1,0,0,1,0},
//        {1,0,1,1,1,0,1},
//        {1,0,1,1,0,1,1},
//        {0,1,1,1,0,1,0},
//        {1,1,0,1,0,1,1},
//        {1,1,0,1,1,1,1},
//        {1,0,1,0,0,1,0},
//        {1,1,1,1,1,1,1},
//        {1,1,1,1,0,1,1}
//    };
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int s = sc.nextInt();
//        String n = sc.next();
//        int m = n.length();
//        for (int i=0; i<5; i++) {
//            if (i == 0 || i == 2 || i == 4) {
//                for (int j=0; j<m; j++) {
//                    int now = n.charAt(j)-'0';
//                    if (j != 0) {
//                        System.out.print(" ");
//                    }
//                    System.out.print(" ");
//                    if ((i == 0 && c[now][0] == 1) || (i == 2 && c[now][3] == 1) || (i == 4 && c[now][6] == 1)) {
//                        for (int k=0; k<s; k++) {
//                            System.out.print("-");
//                        }
//                    } else {
//                        for (int k=0; k<s; k++) {
//                            System.out.print(" ");
//                        }
//                    }
//                    System.out.print(" ");
//                }
//                System.out.println();
//            } else {
//                for (int l=0; l<s; l++) {
//                    for (int j=0; j<m; j++) {
//                        int now = n.charAt(j) - '0';
//                        if (j != 0) {
//                            System.out.print(" ");
//                        }
//                        if ((i == 1 && c[now][1] == 1) || (i == 3 && c[now][4] == 1)) {
//                            System.out.print("|");
//                        } else {
//                            System.out.print(" ");
//                        }
//                        for (int k=0; k<s; k++) {
//                            System.out.print(" ");
//                        }
//                        if ((i == 1 && c[now][2] == 1) || (i == 3 && c[now][5] == 1)) {
//                            System.out.print("|");
//                        } else {
//                            System.out.print(" ");
//                        }
//                    }
//                    System.out.println();
//                }
//            }
//        }
//
//    }
//}




