package dfs_bfs;

/*
 * 2021.07.11
 * BOJ 13549 ���ٲ���3 https://www.acmicpc.net/problem/13549
 * ������ ��ǥ�󿡼� �������� �������� ���� �� +1 -1 *2 ������ ���길 �̿��ؼ� �������� �����ϴ� �Ÿ��̴�.
 * ������ ���������� 0�� ������ �Ͻ������� ��Ÿ��������, 
 * ���������� �Ÿ��� 1�� �ʱ�ȭ�ߴ�.(�̷��� �湮���θ� dist������ üũ�ؼ� �ߺ� �湮�� ������ �� �ִ�.) 
 * ��� ������ ���� �Ÿ����� -1�ؼ� ���� �����Ѵ�.
 * ���� ���ٲ����� �ٸ� ���� *2�� �ɸ��� �ð��� 0�ʶ�� ���̴�. �װ͸� �����ϸ� ���� ���� �� �ִ�.
 * �׷��� ť�� �ִ� �Լ� oneCycle�� ���� bfs�Լ��� ���� ���� �κ� �ΰ����� �����ϸ� �ȴ�.
 * bfs/dfs�� �׻� �ѹ� �湮�ߴ� ���� �������� �ʴ� ��ġ�� �ʿ��ϴ�. 
 * start�� end�� ���� �� ����ó���� ������Ѵ�.
 * 
 */
import java.util.*;
import java.io.*;
public class BOJ_13549  {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bw.write(bfs(n, k, 200000)+""); bw.flush();
	}
	static int bfs(int start, int end, int len) {
		int[] dist = new int[len+1];
		Deque<Integer> q = new LinkedList<Integer>();
		
		if(start == end) 
			return 0;
		
		dist[start] = 1;
		q.add(start);
		while(!q.isEmpty()) {
			int cur = q.removeFirst();
			//ã�ڸ��� �ٷ� �����ؼ� �����̶� ������ ���� �������ߴ�.
			if(cur+1 == end || cur-1 == end || cur*2 == end) {
				if(cur*2 == end) 
					return dist[cur]-1;
				else
					return dist[cur];
			}
			oneCycle(dist, q, cur, cur*2, len);
			oneCycle(dist, q, cur, cur+1, len);
			oneCycle(dist, q, cur, cur-1, len);
		}
		//��ã�� ����ε� ���⼭�� 1������ �����̱� ������ �̰��� ������ ���� ����.
		return 0; 
	}
	
	static void oneCycle(int[] dist, Deque<Integer> q, int cur, int next, int len) {
		if(next >= 0 && next <= len && dist[next] == 0) {
			if(cur*2 == next) {
				dist[next] = dist[cur];
				q.addFirst(next);
			}
			else {
				dist[next] = dist[cur]+1;
				q.addLast(next);
			}
		}
	}
}




