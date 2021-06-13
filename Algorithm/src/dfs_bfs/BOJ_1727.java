package dfs_bfs;


import java.io.*;
import java.util.*;


/*
 * ����
 * 1. dfs bfs �⺻�� �ذ� Ǫ�ϱ� ������ �� �ߴ�.
 * 	   ���� ���̳ĸ�, dfs bfs�� �⺻�� ��� ������ �湮�غ��� ���� �⺻�ε� ����
 * 	 return dfs �̷��� �ҷ��� false�� ���� ���̻� Ž�� ���ص� �Ǵ� �� �±��ѵ�, true�� �͵� �� �̻� �ٸ� ������ Ȯ������ �ʾƼ� ������ ���Դ�. 
 */
class BOJ_1727 {

	static BufferedReader br;
	static int loop; // ��ü ����Ƚ��
	static int vNum; // ���� ����
	static int eNum; // ���� ����
	static LinkedList<Integer>[] graph; // �׷��� 
	static int[] check; // ���� �湮 ���� 

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		loop = Integer.parseInt(br.readLine());

		for(int loopCnt = 0; loopCnt < loop; loopCnt++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());

			//���� ��, ���� �� �Է�
			int vNum = Integer.parseInt(st.nextToken());
			int eNum = Integer.parseInt(st.nextToken());

			//�׷��� �ʱ�ȭ, �� ���� �迭 �ʱ�ȭ
			graph = new LinkedList[vNum+1];
			check = new int[vNum+1];
			for(int i = 1; i <= vNum; i++) {
				graph[i] = new LinkedList<Integer>();
				check[i] = -1;
			}
			
			for(int i = 1; i <= eNum; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x].add(y);
				graph[y].add(x);
			}


			boolean isYes = true;
			for(int i = 1; i <= vNum; i++) {
				if(check[i] == -1 && !dfs(i, 0)) {
					//System.out.println("false ���� "+loop+"ȸ����"+i);
					isYes = false;
				}
			}
			
			
			if(isYes) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}





		}
	}
	static boolean dfs(int cur, int team) {

		check[cur] = team;

		for(int next : graph[cur]) {
			
			if(cur != next && check[cur] == check[next]) // ������ �ƴϰ� ����Ǿ��ִµ�, ���� ���̶�� �װ��� �̺б׷����� �ƴϴ�.
				return false;
			
			if(check[next] == -1 && !dfs(next, (team+1)%2)) { //false�� ������ �ٷ� return�ϴ� �ڵ�
				return false;
			}
			
		}

		return true;

	}
}

/*
 * 1�� 2�� �ݺ��ϰ� �ʹٸ� 3-x�� 3-1�� 3-2�� �����ϸ� �ݺ��� �� �ִ�. 
 * ���� ��ⷯ���ۿ� �������ϰ� �־��µ� ������ 0���� �����ؾ��ϴ� ����?�� �����ߴ�.
 */

//
//import java.util.*;
//
//public class Main {
//    public static boolean dfs(ArrayList<Integer>[] a, int[] color, int x, int c) {
//        color[x] = c;
//        for (int y : a[x]) {
//            if (color[y] == 0) {
//                if (dfs(a, color, y, 3-c) == false) {
//                    return false;
//                }
//            } else if (color[y] == color[x]) {
//                return false;
//            }
//        }
//        return true;
//    }
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n+1];
//            for (int i=1; i<=n; i++) {
//                a[i] = new ArrayList<Integer>();
//            }
//            for (int i=0; i<m; i++) {
//                int u = sc.nextInt();
//                int v = sc.nextInt();
//                a[u].add(v);
//                a[v].add(u);
//            }
//            int[] color = new int[n+1];
//            boolean ok = true;
//            for (int i=1; i<=n; i++) {
//                if (color[i] == 0) {
//                    if (dfs(a, color, i, 1) == false) {
//                        ok = false;
//                    }
//                }
//            }
//            if (ok) {
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
//        }
//
//    }
//}