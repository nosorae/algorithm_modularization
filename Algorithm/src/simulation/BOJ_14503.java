package simulation;


import java.util.*;

//dfs�ε� Ǯ� ��!!!

/*
 * ���� 14503�� �κ�û�ұ�
 * N*Mũ�� �迭, r, c��ǥ 
 * û�� -> ������� ���� ���ʺ��� Ž���ϴ� û�� �� �� ���� ������  �̵� 
 * or Ž���ϴٰ� �� ���� �� û���ϰų� ���̸� ���� �״�� ����
 * �ٵ� �����Ϸ��� ���� �ڿ��� ���̶� ������ �۵� ����
 * �� ���� û���� �����δ� �̵� �Ұ� ���� 
 * �� 1 û���� 0 û���� 2
 * �� 0 , �� 1, �� 2, �� 3
 */

public class BOJ_14503 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 }; 
	static int ans = 0;
	static int n = 0;
	static int m = 0;
	static int[][] arr;
	static LinkedList<String> list = new LinkedList<String>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();
		
		arr = new int[n][m]; 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		while(true) {
			ans++;
			arr[x][y] = 2;
			
			if(arr[x+1][y] != 0 && arr[x-1][y] != 0 && arr[x][y-1] != 0 && arr[x][y+1] != 0) {
				if(arr[x+dx[(d+2)%4]][y+dy[(d+2)%4]] == 1)
					break;
				else { // ���� �״�� ����  ����� �̶� �����ϴ� ���� ���ڴ� 2��. ���� 2�� 2�� ����� ���̴�.
					x = x+dx[(d+2)%4];
					y = y+dy[(d+2)%4];
					ans--; // �̰� û���ϴ� �� �ƴ϶� �׳� �����̱� ������ �ߺ�ī��Ʈ�Ǹ� �ȵǱ� ������ 
					continue;
				}
			}
			
			
			
			//���� �Դٴ� ���� 0�� ������ �ϳ��� �ִٴ� ��
			
			for(int i = 0; i < 4; i++) {
				d = (d+3)%4; //���ʺ��� �ϳ��� Ȯ��
				if(arr[x+dx[d]][y+dy[d]] == 0) {
					x = x+dx[d];
					y = y+dy[d];
					break;
				}
			}
				
		}


		System.out.println(ans);





	}
	
}

/*
 * (i-1)%4�� �ϸ� 0 1 2 3�� ���� �� ������ �׷����ʴ�. i�� 0 1 2 3 �����̸� -1 0 1 2�� ���´�. 
 * �������� �ٲ��ֱ� ���� 4�� ���ϸ� (i+3)%4�� �ǰ� i�� 0 1 2 3������ ��  3 0 1 2�� ���´�.
 * �� ��ⷯ�� �����ϴµ� ������ ���´ٸ� ������ �ǿ����ڸ� �� �� ������ ����� ���� �ǵ��� ���� ���� �� �ִ�.
 * 
 * �׷��� ��ã�� �������ٰ� �� dfs�� ���� �� �ƴ� �� �ִٴ� ���� ������ �̷� ������ �������� dfs�� ���� ���̵��� Ȯ �ö��� ������
 * ���⼭�� �ڷ� ����(==�ڽ��� ȣ���� �θ�޼���� ���ư���)�κ��� ��ٷӱ� ������ dfs������ ������� �� ����. �㿡 �غ���..
 * 
 * ���� �ڵ尡 if else ũ�� ���μ� break, continue ������ �� �ڵ庸�� ���� ����. �ּ����� ������ �� ���� �� ����. �׹� ������ for�� �Ⱦ��� 
 */


//import java.util.*;
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] a = new int[n][m];
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        int dir = sc.nextInt();
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                a[i][j] = sc.nextInt();
//            }
//        }
//        int cnt = 0;
//        int[] dx = {-1,0,1,0};
//        int[] dy = {0,1,0,-1};
//        // a[x][y] == 0 (û������ ���� ����)
//        // a[x][y] == 1 (��)
//        // a[x][y] == 2 (û���� ����)
//        while (true) {
//            if (a[x][y] == 0) {
//                // 1. ���� ��ġ�� û���Ѵ�.
//                a[x][y] = 2;
//            }
//            // 2-3, 2-4. �� ���� ��� û�Ұ� �̹� �Ǿ��ְų� ���� ���
//            if (a[x+1][y] != 0 && a[x-1][y] != 0 && a[x][y-1] != 0 && a[x][y+1] != 0) {
//                if (a[x-dx[dir]][y-dy[dir]] == 1) {
//                    // 2-4. ���� ������ ���̶� ������ �� �� ���� ��쿡�� �۵��� �����.
//                    break;
//                } else {
//                    // 2-3. �ٶ󺸴� ������ ������ ä�� �� ĭ ������ �ϰ� 2������ ���ư���.
//                    x -= dx[dir];
//                    y -= dy[dir];
//                }
//            } else {
//                // 2-1. ���� ���⿡ ���� û������ ���� ������ �����Ѵٸ�, �� �������� ȸ���� ���� 
//                // 2-2. ���� ���⿡ û���� ������ ���ٸ�, �� �������� ȸ���ϰ� 2������ ���ư���. 
//                dir = (dir + 3) % 4;
//                if (a[x+dx[dir]][y+dy[dir]] == 0) {
//                    // 2-1. �� ĭ�� �����ϰ� 1������ �����Ѵ�.
//                    x += dx[dir];
//                    y += dy[dir];
//                }
//            }
//        }
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<m; j++) {
//                if (a[i][j] == 2) {
//                    cnt += 1;
//                }
//            }
//        }
//        System.out.println(cnt);
//    }
//}




