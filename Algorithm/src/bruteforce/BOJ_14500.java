package bruteforce;


/*
 * BOJ 14500 ��Ʈ�ι̳�
 * �Է� �迭�� ��� ������ �� �������� ���� ���ƺ��� ���ۿ� ����. �Է��� ũ��� �ִ� 50 ��, 2500*19�̹Ƿ� �ſ� �Ҹ��ϴ�
 * ������ ��� ���� ���ƺ������̴�. ������ ��� ��ǥ�� ����� �����ȴ�.
 * �׸��� ���� 5������ ���� ȸ�� ��Ī���Ѻ��� 2 + 1 + 8 + 4 + 4 = 19������ ���´�.
 * ���ذ��ǿ����� �Ʒ� ������ ����� �����ߴ�. �ٷ� �Ʒ��� 1���̰� �� �Ʒ��� 2���̴�.
 * 1. ��� ��ǥ�� ���� �Ź� ���� ���˻��ϰ� �õ��غ��� ���
 * 2. 1������ 4���� dfs/bfs�� ��ó�� dx, dy�� ����� ���
 * 3. ??? 
 * �ӵ��� 2���� (���� �Լ�ȣ�� �� 3���� Ȯ���ϴٰ� �ȵǸ� Ż���ϴϱ�) ��������, ������ϱ� ���� �ڵ尡 �� ��������.
 * 
 */
import java.util.*;
public class BOJ_14500 {
	static int[][][] nextPos = {
			{{0, 1}, {0, 2}, {0, 3}}, // ���� ���� ��
			{{1, 0}, {2, 0}, {3, 0}}, // ���� �� ��
			
			{{0, 1}, {1, 0}, {1, 1}}, // ���簢��
			
			{{1, 0}, {2, 0}, {2, 1}}, // �� ����
			{{1, 0}, {0, 1}, {0, 2}}, // �� 1ȸ ȸ��
			{{0, 1}, {1, 1}, {2, 1}}, // �� 2ȸ ȸ��
			{{0, 1}, {0, 2}, {-1, 2}}, // �� 3ȸ ȸ��
			
			{{0, 1}, {-1, 1}, {-2, 1}}, // �� ��Ī ����
			{{1, 0}, {1, 1}, {1, 2}}, // �� ��Ī 1ȸ ȸ��
			{{0, 1}, {1, 0}, {2, 0}}, // �� ��Ī 2ȸ ȸ��
			{{0, 1}, {0, 2}, {1, 2}}, // �� ��Ī 3ȸ ȸ��
			
			{{0, 1}, {1, 1}, {1, 2}}, // �� ����
			{{-1, 0}, {-1, 1}, {-2, 1}}, // �� 1ȸ ȸ��
			{{0, 1}, {-1, 1}, {-1, 2}}, // �� ��Ī ����
			{{1, 0}, {1, 1}, {2, 1}}, // �� ��Ī 1ȸ ȸ��
			
			{{0, 1}, {-1, 1}, {0, 2}}, // �� ���� 
			{{1, 0}, {2, 0}, {1, 1}}, // �� 1ȸ ȸ��
			{{0, 1}, {1, 1}, {0, 2}}, // �� 2ȸ ȸ��
			{{-1, 1}, {0, 1}, {1, 1}} // �� 3ȸ ȸ��
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < 19; k++) {
					int sum = arr[i][j];
					for(int t = 0; t < 3; t++) {
						int nx = i + nextPos[k][t][0];
						int ny = j + nextPos[k][t][1];
						if(!isIn(arr, nx, ny)) {
							sum = -4001;
							break;
						}
						sum += arr[nx][ny];
					}
					if(max < sum)
						max = sum;
				}
			}
		}
		
		System.out.println(max);
    }
	static boolean isIn(int[][] arr, int x, int y) {
		if(x >= 0 && x < arr.length && y >= 0 && y < arr[0].length)
			return true;
		else
			return false;
	}
}



//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//public class Main {
//	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		
//		
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//		
//		int[][] arr = new int[n+1][m+1];
//		for(int i = 1; i<=n;i++) {
//			StringTokenizer st2 = new StringTokenizer(br.readLine());
//			for(int j = 1; j<=m;j++) {
//				arr[i][j] = Integer.parseInt(st2.nextToken());
//			}
//		}
//		int ans = 0;
//		int sum = 0;
//		for(int i = 1; i <= n; i++) { // ����
//			for(int j = 1; j <= m; j++) { // ����
//				if(j+3 <= m) { // ���� ������
//					sum+= arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
//					ans = max(ans, sum);
//					sum = 0;
//				} 
//				if(i+3 <= n) { // ���� ������
//					sum += arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				//---------------------------------------------------------------
//				if(i+1 <= n && j+1 <= m) { // ���簢��
//					sum += arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				//--------------------------------------------------------------
//				if(i+2 <= n && j+1 <= m) { //��
//					sum += arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+1 <= n && j+2 <= m) { // �� ����
//					sum+= arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i][j+2];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+2 <= n && j+1 <= m) { //��
//					sum += arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i-1 >= 1 && j+2 <= m) { // �� ����
//					sum += arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i-1][j+2];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+2 <= n && j-1 >= 1) {
//					sum += arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j-1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+1 <= n && j+2 <= m) {
//					sum += arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+2 <= n && j+1 <= m) {
//					sum += arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+1 <= n && j+2 <= m) {
//					sum+= arr[i][j] + arr[i][j+1]+ arr[i][j+2] + arr[i+1][j+2];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				// --------------------- �� �� �� ������--------------------------------
//				if(i-1 >= 1 && j+2 <= m) {
//					sum += arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i-1][j+2];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+2 <=n && j+1 <= m) {
//					sum += arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i-2 >= 1 && j+1 <= m) {
//					sum += arr[i][j] + arr[i-1][j] + arr[i-1][j+1] + arr[i-2][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+1 <= n && j+2 <= m) {
//					sum += arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				//--------------------------�� �� �ä��Ǥ̽���---------------------------
//				if(i+1 <= n && j+2 <= m) {
//					sum += arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i-1 >= 1 && i+1 <= n && j+1 <= m) {
//					sum += arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i+1][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+1 <= n && j-1>=1 && j+1 <= m) {
//					sum += arr[i][j] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//				if(i+2 <= n && j+1 <= m) {
//					sum += arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j+1];
//					ans = max(ans, sum);
//					sum = 0;
//				}
//			}
//		}
//		
//		System.out.println(ans);
//		
//		br.close();
//		
//	}
//	public static int max(int a, int b) {
//		if(a > b)
//			return a;
//		else
//			return b;
//	}
//}






