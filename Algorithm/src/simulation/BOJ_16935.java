package simulation;

import java.util.*;
import java.io.*;

/*
 * ���� 16935�� �迭������3
 * �̵��� �̵����� �ε����� �������� �̵� ���� �ε����� ã���� ����.
 * �̵� ���� �ε����� ��Ģ���� ã�� ���ϸ� ����.
 */

public class BOJ_16935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < r; i++) {
			arr = arrayRotate(arr, Integer.parseInt(st.nextToken()));
		}

		//���
		printArray2(arr);


	}

	public static int[][] arrayRotate(int[][] arr, int order) {
		switch(order) {
		case 1: 
			reverse_upDown(arr);
			return arr;
		case 2:
			reverse_leftRight(arr);
			return arr;
		case 3:
			arr = rotate_right(arr);
			return arr;
		case 4: 
			arr = rotate_left(arr);
			return arr;
		case 5:
			arr = rotate_part_right(arr);
			return arr;
		default :
			arr = rotate_part_left(arr);
			return arr;


		}
	}
	public static void reverse_upDown(int[][] arr) {
		for(int i = 0; i < arr.length/2; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				swap(arr, i, j, arr.length-1-i, j);
			}
		}
	}
	public static void reverse_leftRight(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length/2; j++) {
				swap(arr, i, j, i, arr[i].length-1-j);
			}
		}
	}

	public static void swap(int[][] arr, int x, int y, int dx, int dy) {
		int temp = arr[x][y];
		arr[x][y] = arr[dx][dy];
		arr[dx][dy] = temp;
	}

	public static int[][] rotate_right(int[][] before) {
		int n = before.length;
		int m = before[0].length;

		int[][] after = new int[m][n];

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				after[i][j] = before[n-1-j][i];
			}
		}
		return after;
	}

	public static int[][] rotate_left(int[][] before) {
		int n = before.length;
		int m = before[0].length;

		int[][] after = new int[m][n];

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				after[i][j] = before[j][m-1-i];
			}
		}
		return after;
	}


	public static int[][] rotate_part_right(int[][] before) {
		int n = before.length;
		int m = before[0].length;
		int[][] after = new int[n][m];
		
		int dn = n/2;
		int dm = m/2;

		if(n%2 != 0) {
			for(int i = 0; i < m; i++) {
				after[n/2][i] = before[n/2][i];
			}
			dn++;
		}
		if(m%2 != 0) {
			for(int i = 0; i <n; i++) {
				after[i][m/2] = before[i][m/2];
			}
			dm++;
		}
		
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j <m/2; j++) {
				after[i][j] = before[i+dn][j];
				after[i][j+dm] = before[i][j];
				after[i+dn][j+dm] = before[i][j+dm];
				after[i+dn][j] = before[i+dn][j+dm];
			}
		}


		return after;

	}

	public static int[][] rotate_part_left(int[][] before) {
		int n = before.length;
		int m = before[0].length;
		int[][] after = new int[n][m];
		
		int dn = n/2;
		int dm = m/2;

		if(n%2 != 0) {
			for(int i = 0; i < m; i++) {
				after[n/2][i] = before[n/2][i];
			}
			dn++;
		}
		if(m%2 != 0) {
			for(int i = 0; i <n; i++) {
				after[i][m/2] = before[i][m/2];
			}
			dm++;
		}
		
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j <m/2; j++) {
				after[i][j] = before[i][j+dm];
				after[i][j+dm] = before[i+dn][j+dm];
				after[i+dn][j+dm] = before[i+dn][j];
				after[i+dn][j] = before[i][j];
			}
		}


		return after;
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
 * 1. �Լ��� Ŭ���� ���� �ø� ��
 * 2. ���ο� �迭 ���� �������� �Ѱ��ִ� ������� ����
 * 3. operation5,6���� Ȧ���� ��츦 �Ű澲�� �ʾƵ� �Ǵ°�?
 * 4. ������ �Է��� ����� nextInt������ �� �ذ���
 */


//import java.util.*;
//public class BOJ_16935 {
//    static int[][] operation1(int[][] a) {
//        int n = a.length;
//        int m = a[0].length;
//        int[][] ans = new int[n][m];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                ans[i][j] = a[n-i-1][j];
//            }
//        }
//        return ans;
//    }
//    static int[][] operation2(int[][] a) {
//        int n = a.length;
//        int m = a[0].length;
//        int[][] ans = new int[n][m];;
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                ans[i][j] = a[i][m-j-1];
//            }
//        }
//        return ans;
//    }
//    static int[][] operation3(int[][] a) {
//        int n = a.length;
//        int m = a[0].length;
//        int[][] ans = new int[m][n];;
//        for (int i=0; i<m; i++) {
//            for (int j=0; j<n; j++) {
//                ans[i][j] = a[n-j-1][i];
//            }
//        }
//        return ans;
//    }
//    static int[][] operation4(int[][] a) {
//        int n = a.length;
//        int m = a[0].length;
//        int[][] ans = new int[m][n];;
//        for (int i=0; i<m; i++) {
//            for (int j=0; j<n; j++) {
//                ans[i][j] = a[j][m-i-1];
//            }
//        }
//        return ans;
//    }
//    static int[][] operation5(int[][] a) {
//        int n = a.length;
//        int m = a[0].length;
//        int[][] ans = new int[n][m];;
//        for (int i=0; i<n/2; i++) {
//            for (int j=0; j<m/2; j++) {
//                ans[i][j+m/2] = a[i][j];
//                ans[i+n/2][j+m/2] = a[i][j+m/2];
//                ans[i+n/2][j] = a[i+n/2][j+m/2];
//                ans[i][j] = a[i+n/2][j];
//            }
//        }
//        return ans;
//    }
//    static int[][] operation6(int[][] a) {
//        int n = a.length;
//        int m = a[0].length;
//        int[][] ans = new int[n][m];;
//        for (int i=0; i<n/2; i++) {
//            for (int j=0; j<m/2; j++) {
//                ans[i+n/2][j] = a[i][j];
//                ans[i][j] = a[i][j+m/2];
//                ans[i][j+m/2] = a[i+n/2][j+m/2];
//                ans[i+n/2][j+m/2] = a[i+n/2][j];
//            }
//        }
//        return ans;
//    }
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
//        while (r-- > 0) {
//            int op = sc.nextInt();
//            if (op == 1) {
//                a = operation1(a);
//            } else if (op == 2) {
//                a = operation2(a);
//            } else if (op == 3) {
//                a = operation3(a);
//            } else if (op == 4) {
//                a = operation4(a);
//            } else if (op == 5) {
//                a = operation5(a);
//            } else if (op == 6) {
//                a = operation6(a);
//            }
//        }
//        for (int i=0; i<a.length; i++) {
//            for (int j=0; j<a[i].length; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}