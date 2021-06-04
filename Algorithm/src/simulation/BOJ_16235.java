package simulation;

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
 * ������ ���� ó���� ���� �ð��ʰ��� ������ �����������ܿ� �Ѳ����� ó���ϴ� ����Ǿ���.
 * ������ ���� ó���� ��  temp �켱����ť�� ���� ��� ���Ҹ� �Űܴ�� ���������� �ð��ʰ��� ���� �� ����.  
 * ����ҽ������� ������ ����ؼ� � ������ �������� ����� ���̰� Ǯ���Ͽ���. ������ N*logN �� �Ͱ� �켱���� ť�� �ְ� ���� ���� logN�� ���� �����ϸ� 
 * �ð����� ���� ���� �𸣰ڴ� .
 */

public class BOJ_16235 {

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
		 * 3. ����5������� ������ 8��ĭ�� ����1���� ���� (���ó��)
		 * 4. �Է¸�ŭ ��� ����
		 * k���� ������ ����ִ� ���� ������ ans
		 */

		for(int years = 1; years <= k; years++) {
			
			int[][] fall = new int[n+1][n+1];
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
							
							if((tree[i][j].peek()+1)%5 == 0) { //���̰� 5����� ( ��Ƴ��� ���� ����+1 �ϴ� �� �����̱� ������ +1���־���.)
								for(int next = 0; next < 8; next++) { // ������ 8���⿡
									int nx = i+dx[next];
									int ny = j+dy[next];
									
									if(isIn(n, nx, ny)) {//���ó���ؼ� 
										fall[nx][ny]++; // ���� 1�� ������ �ɾ��ش�.
										ans++;
									}	
								}
							}
							
							ground[i][j] -= tree[i][j].peek();
							temp.add(tree[i][j].poll()+1);
						}
						
					}
					
					tree[i][j] = temp;
					ground[i][j] += nourish[i][j];  //�Է¸�ŭ ��� ����
					
				}
			}

			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(fall[i][j] > 0) {
						for(int t = 0; t < fall[i][j]; t++) {
							tree[i][j].add(1);
						}
					}
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



/*
 * �Ʒ� ����ҽ������� 
 * ArrayList<Integer>[][] ������ �迭�� �� ĭ�� ArrayList�� sort�ؼ� ���� ���̺��� ����� �Կ���.
 */


//import java.util.*;
//public class Main {
//    static final int[] dx = {-1,-1,-1,0,0,1,1,1};
//    static final int[] dy = {-1,0,1,-1,1,-1,0,1};
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int l = sc.nextInt();
//        int[][] a = new int[n][n];
//        int[][] d = new int[n][n];
//        ArrayList<Integer>[][] tree = new ArrayList[n][n];
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                a[i][j] = sc.nextInt();
//                d[i][j] = 5; // ���� ó���� ����� ��� ĭ�� 5��ŭ ����ִ�.
//                tree[i][j] = new ArrayList<>();
//            }
//        }
//        while (m-- > 0) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            int age = sc.nextInt();
//            tree[x-1][y-1].add(age);
//        }
//        while (l-- > 0) {
//            int[][] p = new int[n][n];
//            for (int i=0; i<n; i++) {
//                for (int j=0; j<n; j++) {
//                    ArrayList<Integer> temp = new ArrayList<>();
//                    Collections.sort(tree[i][j]);
//                    int dead = 0;
//                    for (int x : tree[i][j]) {
//                        if (x <= d[i][j]) {
//                            d[i][j] -= x; // ������ �ڽ��� ���̸�ŭ ����� �԰�, ���̰� 1 �����Ѵ�.
//                            temp.add(x+1);
//                            if ((x+1) % 5 == 0) { // �����ϴ� ������ ���̰� 5�� ����̾�� �ϸ�,
//                                for (int k=0; k<8; k++) {
//                                    int nx = i+dx[k];
//                                    int ny = j+dy[k];
//                                    if (0 <= nx && nx < n && 0 <= ny && ny < n) { // ���� ���� ����� ĭ���� ������ ������ �ʴ´�.
//                                        p[nx][ny] += 1; // ������ 8���� ĭ�� ���̰� 1�� ������ �����.
//                                    }
//                            }
//                            }
//                        } else { // ����, ���� ����� ������ �ڽ��� ���̸�ŭ ����� ���� �� ���� ������ ����� ���� ���ϰ� ��� �״´�.
//                            dead += x/2; // ������ ���� �������� ���̸� 2�� ���� ���� ������ �ִ� ĭ�� ������� �߰��ȴ�.
//                        }
//                    }
//                    tree[i][j] = temp;
//                    d[i][j] += dead;
//                    d[i][j] += a[i][j]; // �� ĭ�� �߰��Ǵ� ����� ���� A[r][c]�̰�, �Է����� �־�����.
//                }
//            }
//            for (int i=0; i<n; i++) {
//                for (int j=0; j<n; j++) {
//                    for (int k=0; k<p[i][j]; k++) {
//                        tree[i][j].add(1); // ������ 8���� ĭ�� ���̰� 1�� ������ �����.
//                    }
//                }
//            }
//        }
//        int ans = 0;
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n; j++) {
//                ans += (int)tree[i][j].size();
//            }
//        }
//        System.out.println(ans);
//    }
//}















