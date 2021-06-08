import java.io.*;
import java.util.*;

/*
 * ���� 13023 ABCDE
 * ������ 0�̳� 1�̳� ���� �� ����
 * dfs �⺻�� �� ������ �ǵ� for������ return�� ������� �� ���� �ʴ´�.(����Ʈ ������ϴٰ� �߰�)
 */

class Main {
	static LinkedList<Integer>[] graph;
	static boolean[] check;
	static int n; 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		//�׷��� �ʱ�ȭ
		graph = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			graph[i] = new LinkedList<Integer>();
		}

		//���� �Է�
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x].add(y);
			graph[y].add(x);
		}

		//��� ������ ���� dfs
		for(int i = 0;  i < n; i++) {
			check = new boolean[n];
			dfs(i, 1);

		}


		bw.write(0+"");
		bw.flush();

	}
	static void dfs(int cur, int depth) {
		check[cur] = true;
		
		if(depth >= 5) {
			System.out.println(1);
			System.exit(0);
		}
			


		for(int next : graph[cur]) {
			if(!check[next]) {
				dfs(next, depth+1);
			}

		}
		
	}
}