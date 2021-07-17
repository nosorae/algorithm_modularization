package dfs_bfs;
/*
 * 2021.07.11
 * BOJ 1261 �˰��� https://www.acmicpc.net/problem/1261
 * �̰͵� ����ġ�� 0�� 1�� bfs�� �� �� �ִ�. ������ �ٽ��� �ν����ϴ� �� �����̱� �����̴�.
 * �̵��Ϸ��� ���� ���� ���� 1, �ƴ� ���� 0�� ���� �ȴ�.
 * ������ �ȹٷ� ���� n�� ����ũ��(������) m�� ����ũ��(�����)��� �����ִ�. �ݴ���ؼ� �����ߴ�..
 * �ΰ�¥���� ������ ���� ���� ���� �ݴ���ؾ��Ѵ�. �̷� �Ǽ��� �����ϱ� ���ؼ��� xť yť ���� ���ų�
 * ������ ���� ���� ������ �ٲ�����Ѵ�. a b�� ���ʴ�� ������ �־ ������ b, a������ ���´�.
 */
import java.util.*;
import java.io.*;
public class BOJ_1261_Hard  {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0}; //��������
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[m+1][n+1];
		for(int i = 1; i <= m; i++) {
			String input = br.readLine();
			for(int j = 1; j <= n; j++) {
				map[i][j] = input.charAt(j-1) - '0';
			}
		}

		bw.write(bfs(map, m, n)+""); bw.flush();

	}
	static int bfs(int[][] map, int n, int m) {
		int[][] dist = new int[n+1][m+1];
		boolean[][] check = new boolean[n+1][m+1];
		
		Deque<Integer> q = new LinkedList<Integer>();
		dist[1][1] = 1;
		q.addFirst(1); q.addFirst(1);

		
		while(!q.isEmpty()) {
			int curX = q.removeFirst();
			int curY = q.removeFirst();

			for(int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if(isIn(n, m, nx, ny) && !check[nx][ny]) {
					if(map[nx][ny] == 1) {
						dist[nx][ny] = dist[curX][curY]+1;
						q.addLast(nx); q.addLast(ny);
					}
					else {
						dist[nx][ny] = dist[curX][curY];
						//�� �κ��� �����ؾ��Ѵ�. ������ �ִ� ���� ���� �ݴ�� �ؾ� �� �� �����°� ���´�.
						q.addFirst(ny); q.addFirst(nx);
					}
					check[nx][ny] = true;

				}
			}
		}
		return dist[n][m]-1;
	}
	static boolean isIn(int n, int m, int nx, int ny) {
		if(nx >= 1 && nx <= n && ny >= 1 && ny <= m) return true;
		else return false;
	}
}




