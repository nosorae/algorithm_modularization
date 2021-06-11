package dfs_bfs;

import java.io.*;
import java.util.*;

/*
 * ���� 13023 ABCDE
 * 1. ������ 0�̳� 1�̳� ���� �� ����
 * 2. ����Լ��� return �� ���޸����̸� �Ű���!
 * 3. dfs���� ��� ��ο� ���� ����� ���� ���غ����� ���� ������ ������ �ٽ� false�ʱ�ȭ ������Ѵ�.
 * 	    �ֳ��ϸ� �θ� �������忡���� �̹� for���� �������� �ٽ� �湮�� �� ��� ������ �ٸ� �ڽ��������� �湮�Ϸ��� false�����ϱ� �����̴�.
 * 	    ��� true�� �س����� �ٸ� �ڽ��������� �� �� ��θ� ã�� �� �ִµ� ���� ���ؼ� �� �� ��ε� ã�� ���ϴ� ������ �߻��Ѵ�.
 * 3_2. 2�� 3��ó�� �� ��  ���� �������� �� �� ���� ���� �ٽ� false�� �ٱ�����Ѵ�. �� �׷��� �θ��尡 false�Ǿ �θ��忡 �ִ� �ٸ� ��尡 �θ��� �� �湮�� 
 * 4. ������ ���� ����뿡 �� ����Ʈ�� ������ ���� Ʋ���� �ð����� ��������
 * 
 */

class BOJ_13023 {
	static LinkedList<Integer>[] graph;
	static boolean[] check;
	static int n; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
			//System.out.println();
			if(dfs(i, 1)) {
				bw.write(1+"");
				bw.flush();
				return;
			}

		}




		bw.write(0+"");
		bw.flush();


	}
	static boolean dfs(int cur, int depth) {
		check[cur] = true;

		//System.out.println("���� "+cur+"�̰� ���̴� "+depth);
		if(depth >= 5)
			return true;

		for(int next : graph[cur]) {
			if(!check[next]) {
				if(dfs(next, depth+1))
					return true;
				else 
					check[next] = false;
			}

		}
		return false;
	}
}