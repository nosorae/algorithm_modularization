package simulation;






import java.util.*;
/*
 * ���� 14890 ���� 
 * ���������� ���Ǻм��� �߿��ϴ� 
 * ���� ���ǿ� �ش��ϴ� ��ȣ�� �ű�� �ش� ���ǿ� �ش��ϴ� �ڵ�κп� ��ȣ�ּ��� �ްڴ�.
 * 1. ���δ� ���� ���� ����,
 * 2. ���� ���� ���������ؾ���, 
 * 3. �̹� ���� ���� �� ���ų� ���ļ��� �ȵ�, 
 * 4. �׸��� ���ΰ� �迭�� ����� �ȵ� 
 * 
 * ����� �����ϸ� ���� ���� ���� ���� �ӿ��� ��� �κ��� ��ġ�� ���� �˱� ���⶧���̴�.
 * �� �Ʒ� ����ҽ� ����  2�� �˻� �ϴµ� �翷�� ���ϴ� �� �ƴ϶� �� ó���� ���ϸ� for�� �ȿ� ���� �������� ���θ� üũ�ϱ� ������  ��ó�� 1������ ����ó���� �� �ʿ䰡 ����.
 * 
 */

public class BOJ_14890_Hard {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int len = sc.nextInt();
		int[][] arr = new int[n][n];
		int[] road;
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//����
		for(int row = 0; row < n; row++) {
			road = arr[row];
			if(isRoad(road, len)) {
				ans++;
				//System.out.print(row+"��  ");
			}
				
		}
		
		//����
		for(int col = 0; col < n; col++) {
			road = new int[n];
			for(int row = 0; row < n; row++) {
				road[row] = arr[row][col];
			}
			if(isRoad(road, len)) {
				ans++;
				//System.out.print(col+"��  ");
			}
				
		}
		
		System.out.println(ans);
		
    }
	static boolean isRoad(int[] arr, int len) {
		
		boolean[] isSteep = new boolean[arr.length];
		
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] > arr[i+1]) { //1 ���δ� ���� ���� ���´�.
				
				
				if(arr[i] - arr[i+1] > 1) // �������� 1����
					return false;
				if(i + len > arr.length-1) //4 ���δ� 
					return false;
				
				//���� �Դٴ� ���� �迭 ������ ����� �ʴ´ٴ� ��
				for(int j = 1; j < len; j++) { //2, 3 �� ����˻�� �ߺ��˻� / 1�ΰ�� �̰��� ���� ���Ѵ�.
					if(arr[i+j] != arr[i+j+1] || isSteep[i+j] || isSteep[i+j+1])
						return false;
				}
				if(len == 1 && isSteep[i+1])
					return false;
				//���� �Դٴ� ���� ���θ� ���� �� �ִٴ� ��
				for(int j = 1; j <= len; j++) { //3 �ߺ��˻縦 ���� üũ
					isSteep[i+j] = true;
				}
				
			}
			else if(arr[i] < arr[i+1]) { //1 
				
				if(arr[i+1] - arr[i] > 1)
					return false;
				if(i-(len-1) < 0) //4  ���ʿ� ���� ���� ���� ���� �ε��� �����ؼ� ���⶧���� len-1
					return false;
				
				for(int j = 0; j < len-1; j++) { // 1�� ��� �̰��� ���� �ʾƼ� ���ΰ� �������� �˻縦 ���Ѵ�. 
					if(arr[i-j] != arr[i-j-1] || isSteep[i-j] || isSteep[i-j-1])
						return false;
				}
				if(len == 1 && isSteep[i])
					return false;
				
				for(int j = 0; j < len; j++) 
					isSteep[i-j] = true;
			}
		}
		
		
		
		return true;
	}
}

/*
 * 1���� �迭 ���� ���������� ����������Ѵٴ� ����� ������ ���ϴٰ� ������
 * Ʋ����츦 �� �����ϰ� �ƴϸ� �����̴ٶ�� �÷ο�
 * ���ʿ� ���� ���� ���� ���� �ε��� �����ؼ� ���⶧���� len-1
 */
//import java.util.*;
//
///*
// * ���� 14890�� ����
// * ���䳪���� ���� �ڵ� �ϳ��� �Լ����� �Ϸ��� ������ �����غ��δ�.
// */
//
//public class BOJ_14890_Unsolved {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		final int n = sc.nextInt();
//		final int l = sc.nextInt();
//		int[][] arr = new int[n][n];
//		boolean[][] steep = new boolean[n][n];
//		int ans = 0;
//
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				arr[i][j] = sc.nextInt();
//			}
//		}
//
//		//����
//		for(int i = 0; i < n; i++) {
//			boolean[][] save = new boolean[n][n]; // �� �� ���� �ӽ÷� ���θ� üũ ���� �ȴٸ� steep�迭�� �̵�
//			for(int j = 0; j < n; j++) {
//
//				if(j == n-1) {// ������ �Դٸ� �װ��� �� ���� ����� ���� üũ ����
//					for(int x = 0; x < n; x++) {
//						if(save[i][x])
//							steep[i][x] = true;
//					}
//					ans++;
////					System.out.println(i+1+"��");
//					break;
//				}
//
//
//				int prev = arr[i][j];
//				int next = arr[i][j+1];
//
//				if(prev == next) {
//					continue;
//				}
//
//				else if(prev > next && prev-next == 1) { // ���� ���� ���� ���̶�� L��ŭ ���ӵǾ��ִ��� üũ
//
//					if(j > n-1-l)
//						break;
//
//					if(l== 1 && !save[i][j+1] && !steep[i][j+1]) {
//						save[i][j+1] = true;
//						continue;
//					}
//					else { // �̹� ���ΰ� �ִٸ� Ż�����Ѿ��Ѵ�.
//						if(l==1)
//							break;
//					}
//
//
//
//					boolean isSteep = true;
//					for(int k = j+1; k <= j+l-1; k++) {
//						if(arr[i][k] != arr[i][k+1] || steep[i][k] || steep[i][k+1]
//								|| save[i][k] || save[i][k]) {
//							isSteep = false;
//							break;
//						}
//						save[i][k] = true;
//					}
//					save[i][j+l] = true;
//					if(!isSteep) 
//						break;
//
//
//				}
//				else if (prev < next && next-prev == 1) { // ���� ���� �� ���� ���̶�� ���� ���� L��ŭ ���ӵǾ��ִ��� üũ
//
//					if(j < l-1) 
//						break;
//
//					if(l == 1 && !save[i][j] && !steep[i][j]) {
//						save[i][j] = true;
//						continue;
//					} 
//					else {
//						if(l==1)
//							break;
//					}
//
//
//					boolean isSteep = true;
//					for(int k = j; k > j-l+1; k--) {
//						if(arr[i][k] != arr[i][k-1] || steep[i][k] || steep[i][k-1]
//								|| save[i][k] || save[i][k-1]) {
//							isSteep = false;
//							break;
//						}
//						save[i][k] = true;
//					}
//					save[i][j-l+1] = true;
//					if(!isSteep)
//						break;
//
//				}
//				else 
//					break;
//
//
//			}
//		}
//
//
//
//
//
//		steep = new boolean[n][n];
//		//����
//		for(int i = 0; i < n; i++) {
//			boolean[][] save = new boolean[n][n];
//			for(int j = 0; j < n; j++) {
//
//
//				if(j == n-1) { // ������ �Դٸ� ����� ���� ����
//					for(int x = 0; x < n; x++) {
//						if(save[x][i])
//							steep[x][i] = true;
//					}
//					ans++;
////					System.out.println(i+1+"��");
//					break;
//				}
//
//
//
//				int prev = arr[j][i];
//				int next = arr[j+1][i];
//				if(prev == next) {
//					continue;
//				}
//				else if(prev > next && prev-next == 1) { // ���� ���� ���� ���̶�� L��ŭ ���ӵǾ��ִ��� üũ
//
//					if(j > n-1-l)
//						break;
//
//					if(l == 1 && !save[j+1][i] && !steep[j+1][i]) {
//						save[j+1][i] = true;
//						continue;
//					} 
//					else {
//						if(l == 1)
//							break;
//					}
//
//					boolean isSteep = true;
//					for(int k = j+1; k <= j+l-1; k++) {
//						if(arr[k][i] != arr[k+1][i] || steep[k][i] || steep[k+1][i]
//								|| save[k][i] || save[k+1][i]) {
//							isSteep = false;
//							break;
//						}
//						save[k][i] = true;
//					}
//					save[j+l][i] = true;
//					if(!isSteep) 
//						break;
//
//				}
//				else if (prev < next && next-prev == 1) { // ���� ���� �� ���� ���̶�� ���� ���� L��ŭ ���ӵǾ��ִ��� üũ
//
//					if(j < l-1) 						
//						break;
//
//					if(l == 1 && !save[j][i] && !steep[j][i]) {
//						save[j][i] = true;
//						continue;
//					}
//					else {
//						if(l == 1)
//							break;
//					}
//
//					boolean isSteep = true;
//					for(int k = j; k > j-l+1; k--) {
//						if(arr[k][i] != arr[k-1][i] || steep[k][i] || steep[k-1][i]
//								|| save[k][i] || save[k-1][i]) {
//							isSteep = false;
//							break;
//						}
//						save[k][i] = true;
//					}
//					save[j-l+1][i] = true;
//					if(!isSteep)
//						break;
//
//				}
//
//
//			}
//		}
//		
//		
//
//
//		System.out.println(ans);
//
//	}
//
//}

/*
 * �̹� ���� ��簡 ��ġ�� �ȵȴٴ� ������ �����ϰ� Ǯ���ٰ� ������ �����ߴ�.
 * ���θ� ���� �� Ȯ���� �� �Ŀ� true false�� �ٲ�����ϴµ�, Ȯ�� ���� �ٲ��༭ �ٲ��ش����� ���ΰ� Ȯ������ ������ �ٸ� ���θ� �� ���� ������ �߱��ߴ�.
 * ������ else�� ���ų� ũ�� 1���� �۰� 1���̰� �ƴ϶�� break���ִ� �� �����ؼ� �����ߴ�. 
 * ���������� ���ٸ� �����ؼ� �ϳ��ϳ� ������ üũ����Ʈ�� ����!!!
 * 
 */


//import java.util.*;
//public class Main {
//    static boolean go(int[] a, int l) {
//        // �� �� �˻�
//        int n = a.length;
//        boolean[] c = new boolean[n];
//        for (int i=1; i<n; i++) {
//            if (a[i-1] != a[i]) {
//                // ������ ĭ�� ���̰� �ٸ���, ���θ� ���ƾ� �Ѵ�.
//                int diff = a[i]-a[i-1];
//                if (diff < 0) diff = -diff;
//                if (diff != 1) {
//                    // ���� ĭ�� ���� ĭ�� ���� ���̴� 1�̾�� �Ѵ�.
//                    return false;
//                }
//                if (a[i-1] < a[i]) {
//                    for (int j=1; j<=l; j++) {
//                        if (i-j < 0) {
//                            // ���θ� ���ٰ� ������ ����� ���
//                            return false;
//                        }
//                        if (a[i-1] != a[i-j]) {
//                            // ���� ������ ĭ�� ���̰� ��� ���� �ʰų�, L���� ���ӵ��� ���� ���
//
//                            return false;
//                        }
//                        if (c[i-j]) {
//                            // ���θ� ���� ���� �� ���θ� ���� ���
//                            return false;
//                        }
//                        c[i-j] = true;
//                    }
//                } else {
//                    // a[i-1] > a[i]
//                    for (int j=0; j<l; j++) {
//                        if (i+j >= n) {
//                            // ���θ� ���ٰ� ������ ����� ���
//                            return false;
//                        }
//                        if (a[i] != a[i+j]) {
//                            // ���� ������ ĭ�� ���̰� ��� ���� �ʰų�, L���� ���ӵ��� ���� ���
//
//                            return false;
//                        }
//                        if (c[i+j]) {
//                            // ���θ� ���� ���� �� ���θ� ���� ���
//                            return false;
//                        }
//                        c[i+j] = true;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int l = sc.nextInt();
//        int[][] a = new int[n][n];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        int ans = 0;
//        for (int i=0; i<n; i++) {
//            // �� �˻�
//            int[] d = new int[n];
//            for (int j=0; j<n; j++) {
//                d[j] = a[i][j];
//            }
//            if (go(d, l)) ans += 1;
//        }
//        for (int j=0; j<n; j++) {
//            // �� �˻�
//            int[] d = new int[n];
//            for (int i=0; i<n; i++) {
//                d[i] = a[i][j];
//            }
//            if (go(d, l)) ans += 1;
//        }
//        System.out.println(ans);
//    }
//}










