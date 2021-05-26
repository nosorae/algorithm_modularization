package simulation;


import java.util.*;

/*
 * ���� 15662�� ��Ϲ��� 
 * ���� ���� �������� ������ �����ľ��� �ſ� �߿��ϴٴ� ���� ���ݰ� ���� Ǯ�� ���� ���� �̴� ���� ����
 * 8�� ��ϰ��� ��Ϲ����� T��  (��ϸ��� N�� or S��)
 * ��Ϲ����� ȸ�������� ��ĭ�̰� �ð� �ݽð� �ΰ����� �ִ�.
 * ȸ����Ű�� ���� ��� ��Ϲ����� ����, ȸ����ų ��Ϲ����� ������ �����ؾ���
 * �´��� ���� �ٸ��ٸ� �ݴ�� ȸ�� ��Ű��, �´��� ���� ���ٸ�  ȸ�� x ���������� ȸ�� x
 * 
 * ��Ϲ����� ������ �迭�� ǥ���ϰ�, ȸ���� ��ĭ �б� ��ĭ ����� ǥ��, ȸ����Ű�� ���� ��� ������ �̸� ���س��ƾ��Կ� ����
 */

public class BOJ_15662 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] arr = new int[t][8];
		
		
		sc.nextLine();
		for(int i = 0; i < t; i++) {
			String input = sc.nextLine();
			for(int j = 0; j < 8; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		int k = sc.nextInt();
	
		
		
		for(int i = 0; i < k; i++) {
			
			int num = sc.nextInt()-1;
			int direc = sc.nextInt(); // 1 �ð� 0 ��ȸ�� -1 �ݽð�
			int[] order = new int[t];
			order[num] = direc;
			
			
			//ȸ���ϱ� ����  ��Ϲ����� ���������� ������
			for(int j = num; j > 0; j--) {
				if(arr[j][6] == arr[j-1][2]) {
					break;
				}
				else {
					order[j-1] = -order[j];
				}
			}
			for(int j = num; j < t-1; j++) {
				if(arr[j][2] == arr[j+1][6])
					break;
				else 
					order[j+1] = -order[j];
			}
			
			for(int j = 0; j < t; j++) {
				if(order[j] == 1) 
					push_right(arr[j]);
				else if(order[j] == -1)
					push_left(arr[j]);
			}
		}
		
		int ans = 0;
		for(int i = 0; i < t; i++) {
			if(arr[i][0] == 1)
				ans++;
		}
		
		System.out.println(ans);
		
		
		
		
	}
	static int reverseNum(int n) {
		return n==1 ? -1 : (n==-1 ? 1 : 0);
	}
	
	//1���� �迭 �������� �� ĭ ����
	static void push_left(int[] arr) {
		int temp = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = temp; 
		
	}
	//1���� �迭 �������� �� ĭ �б�
	static void push_right(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i = arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
	}

}

/*
 * a[i] = sc.next().toCharArray(); (a�� 2�����迭�ε� ������ �Է¹޴� ������ ������)
 * 
 */


//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        char[][] a = new char[n][8];
//        for (int i=0; i<n; i++) {
//            a[i] = sc.next().toCharArray();
//        }
//        int k = sc.nextInt();
//        while (k-- > 0) {
//            int no = sc.nextInt()-1;
//            int dir = sc.nextInt();
//            // ������ ��ϴ� ���ÿ� ȸ���ؾ� �ϱ� ������
//            // ����, �� ��ϰ� � �������� ȸ���ؾ� �ϴ��� ������
//            int[] d = new int[n];
//            d[no] = dir;
//            // ���� ��ϸ� ���������� ���ϰ�
//            for (int i=no-1; i>=0; i--) {
//                if (a[i][2] != a[i+1][6]) {
//                    d[i] = -d[i+1];
//                } else {
//                    // �� ��ϰ� ȸ������ ������
//                    // �� ����� ���ʿ� �ִ� ��ϵ� ȸ������ �ʴ´�.
//                    break;
//                }
//            }
//            // ������ ��ϸ� ���������� ���ϰ�
//            for (int i=no+1; i<n; i++) {
//                if (a[i-1][2] != a[i][6]) {
//                    d[i] = -d[i-1];
//                } else {
//                    // �� ��ϰ� ȸ������ ������
//                    // �� ����� �����ʿ� �ִ� ��ϵ� ȸ������ �ʴ´�.
//                    break;
//                }
//            }
//            for (int i=0; i<n; i++) {
//                if (d[i] == 0) continue;
//                if (d[i] == 1) {
//                    // �ð� ���� ȸ��
//                    char temp = a[i][7];
//                    for (int j=7; j>=1; j--) {
//                        a[i][j] = a[i][j-1];
//                    }
//                    a[i][0] = temp;
//                } else if (d[i] == -1) {
//                    // �ݽð� ���� ȸ��
//                    char temp = a[i][0];
//                    for (int j=0; j<7; j++) {
//                        a[i][j] = a[i][j+1];
//                    }
//                    a[i][7] = temp;
//                }
//            }
//        }
//        int ans = 0;
//        for (int i=0; i<n; i++) {
//            if (a[i][0] == '1') {
//                ans += 1;
//            }
//        }
//        System.out.println(ans);
//    }
//
//}
//






