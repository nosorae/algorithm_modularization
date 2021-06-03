


import java.util.*;
/*
 * ���� 16235 ���� ����ũ
 * �ε��� 1���� ����
 * �ʱ� ��� 5 ũ�� N
 * 1. ����� ���̸�ŭ ��� ���� -> ����1���� // �������� ����
 * 2. ������������/2 ��ū ��� ���� 
 * 3. ����5������� ������ 8��ĭ�� ����1���� ���� (���ó��)
 * 4. �Է¸�ŭ ��� ����
 * k���� ������ ����ִ� ���� ������ ans
 * 
 */

public class Main {

	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int ans = 0;



		PriorityQueue<Integer>[][] tree = new PriorityQueue[n+1][n+1];

		int[][] ground = new int[n+1][n+1];
		int[][] nourish = new int[n+1][n+1];

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				tree[i][j] = new PriorityQueue<Integer>();
				ground[i][j] = 5;
				nourish[i][j] = sc.nextInt();
			}
		}

		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int age = sc.nextInt();
			tree[x][y].add(age);
			ans++; // ���� �߰� �� ���ҿ� ������ �ʰ� ������ ����
		}

		/*
		 * 1. ��������� ���̸�ŭ ��� ���� -> ����1���� // �������� ����
		 * 2. ������������/2 ��ū ��� ���� 
		 * 1, 2�� ��� ó���ϰ� 3, 4�� ��� ó��
		 * 3. ����5������� ������ 8��ĭ�� ����1���� ���� (���ó��)
		 * 4. �Է¸�ŭ ��� ����
		 * k���� ������ ����ִ� ���� ������ ans
		 */

		for(int years = 1; years <= k; years++) {
			
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					PriorityQueue<Integer> temp = new PriorityQueue<Integer>();
					while(!tree[i][j].isEmpty()) {
						
						
						if(ground[i][j] - tree[i][j].peek() < 0) {

							while(!tree[i][j].isEmpty()) {
								
								//������ �� ���� ����/2 ��ŭ ��� ����
								ground[i][j] += (tree[i][j].poll()/2);
								ans--;
							}
							break;
						}
						else {
							ground[i][j] -= tree[i][j].peek();
							temp.add(tree[i][j].poll()+1);
						}
					}

					tree[i][j] = temp;
				}
			}

			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					PriorityQueue<Integer> temp = new PriorityQueue<Integer>();
					
					while(!tree[i][j].isEmpty()) {
						
						if(tree[i][j].peek()%5 == 0) { //���̰� 5�����
							for(int next = 0; next < 8; next++) { // ������ 8���⿡
								int nx = i+dx[next];
								int ny = j+dy[next];
								
								if(isIn(n, nx, ny)) {//���ó���ؼ� 
									tree[nx][ny].add(1); // ���� 1�� ������ �����ش�.
									ans++;
								}	
							}
						}
						
						int t = tree[i][j].poll();
						temp.add(t);
					}
					
					tree[i][j] = temp;
					
					
					ground[i][j] += nourish[i][j];  //�Է¸�ŭ ��� ����
				}
			}
		} //k for���� ��
		
		System.out.println(ans);



	}


	static boolean isIn(int n, int nx, int ny) {
		if(nx >=1 && nx <= n && ny >=1 && ny <= n) 
			return true;
		else
			return false;
	}
}

















