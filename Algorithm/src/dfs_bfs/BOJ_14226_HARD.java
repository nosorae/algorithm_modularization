package dfs_bfs;



/*
 * 2021.07.11
 * BOJ 14226 �̸�Ƽ�� https://www.acmicpc.net/problem/14226
 * ������ ȭ��Ƽ�ܰ� Ŭ��Ƽ���� �������� �����Ѵ�.
 * �׷��� ���� �Ÿ� ������ �������迭�� �Ѵ�.
 * �׷��� �� ������ �迭�� �ε����� ����� ������ ȭ��Ƽ�ܰ� Ŭ��Ƽ���� ǥ���Ѵ�.
 */
import java.util.*;
import java.io.*;
public class BOJ_14226_HARD  {
	static final int Max = 2000;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		bw.write(bfs(n)+""); bw.flush();
	}
	static int bfs(int goal) {
		int answer = 0;
		int[][] dist = new int[Max][Max];
		Queue<Integer> q = new LinkedList<Integer>();
		
		dist[1][0] = 1;
		q.add(1); q.add(0);
		while(!q.isEmpty()) {
			int display = q.poll();
			int clip = q.poll();
			
			if(display == goal) {
				answer = dist[display][clip];
				break;
			}

			//����
			if(dist[display][display] == 0) {
				dist[display][display] = dist[display][clip] + 1;
				q.add(display); q.add(display);
			}
			
			//�ٿ��ֱ�
			if(display+clip < Max && dist[display+clip][clip] == 0) {
				dist[display+clip][clip] = dist[display][clip] + 1;
				q.add(display+clip); q.add(clip);
			}
			
			//����
			if(display-1 >= 0 && dist[display-1][clip] == 0) {
				dist[display-1][clip] = dist[display][clip] + 1;
				q.add(display-1); q.add(clip);
			}
			
		}
		return answer-1;
	}
}





