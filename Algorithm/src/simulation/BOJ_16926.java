package simulation;


import java.util.*;

/*
 * ���� 16926�� �迭������1
 * ����� ������ ���� ������ �����ؼ� Ǯ���ϴ� ���̵�� 
 * �� 2�����迭�� �׵θ��� �̵������� 1�����迭�� ���� �̵������� ��ȯ�ؼ� �ذ�
 */

public class BOJ_16926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		int[][] arr = new int[n][m];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		border(arr, r);

		printArray2(arr);

	}

	static void border(int[][] arr, int r) {
		int n = arr.length;
		int m = arr[0].length;
		int groupNum = min(n, m)/2;

		//�ʱ�ȭ
		LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
		for(int i = 0; i < groupNum; i++) {
			list.add(new LinkedList<Integer>());
		}

		//1���� �迭ȭ
		for(int k = 0; k < groupNum; k++) {
			for(int i = k; i < m-1-k; i++) {
				list.get(k).add(arr[k][i]);
			}
			for(int i = k; i < n-1-k; i++) {
				list.get(k).add(arr[i][m-1-k]);
			}
			for(int i = m-1-k; i > k; i--) {
				list.get(k).add(arr[n-1-k][i]);
			}
			for(int i = n-1-k; i > k; i--) {
				list.get(k).add(arr[i][k]);
			}
		}

		//�̵� ���� �����ϸ鼭, �ٽ� 2���� �迭ȭ

		for(int k = 0; k < groupNum; k++) {
			int idx = r%list.get(k).size();
			//�� idx�� ���ο� �������̰�, 0~���������� ������ ���ڵ��� ���ʴ�� ���� �ڷ� �־��ش�.
			for(int i = 0; i < idx; i++) {
				list.get(k).add(list.get(k).remove(0));
			}



			for(int i = k; i < m-1-k; i++) {
				arr[k][i] = list.get(k).remove(0);
			}
			for(int i = k; i < n-1-k; i++) {
				arr[i][m-1-k] = list.get(k).remove(0);

			}
			for(int i = m-1-k; i > k; i--) {
				arr[n-1-k][i] = list.get(k).remove(0);

			}
			for(int i = n-1-k; i > k; i--) {
				arr[i][k] = list.get(k).remove(0);
			}
		}

	}





	static int min(int a, int b) {
		return (a < b) ? a : b;
	}

	public static void printArray2(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}

/*
 * 1. �ٽ� 2���� �迭ȭ �ϴ� �������� for�� �ȿ� �Ź� %�������ִ� �� �����
 */


//
//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int r = sc.nextInt();
//        int[][] a = new int[n][m];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
//        int groupn = Math.min(n,m)/2;
//        for (int k=0; k<groupn; k++) {
//            ArrayList<Integer> group = new ArrayList<>();
//            for (int j=k; j<m-k; j++) {
//                group.add(a[k][j]);
//            }
//            for (int i=k+1; i<n-k-1; i++) {
//                group.add(a[i][m-k-1]);
//            }
//            for (int j=m-k-1; j>k; j--) {
//                group.add(a[n-k-1][j]);
//            }
//            for (int i=n-k-1; i>k; i--) {
//                group.add(a[i][k]);
//            }
//            groups.add(group);
//        }
//        for (int k=0; k<groupn; k++) {
//            ArrayList<Integer> group = groups.get(k);
//            int len = group.size();
//            int index = r % len;
//            for (int j=k; j<m-k; j++, index = (index+1) % len) {
//                a[k][j] = group.get(index);
//            }
//            for (int i=k+1; i<n-k-1; i++, index = (index+1) % len) {
//                a[i][m-k-1] = group.get(index);
//            }
//            for (int j=m-k-1; j>k; j--, index = (index+1) % len) {
//                a[n-k-1][j] = group.get(index);
//            }
//            for (int i=n-k-1; i>k; i--, index = (index+1) % len) {
//                a[i][k] = group.get(index);
//            }
//        }
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//    }
//}
//
//
//
//
//
//
//

