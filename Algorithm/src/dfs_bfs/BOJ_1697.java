package dfs_bfs;

import java.util.*;
import java.io.*;

/*
 * ���� 1697 ���ٲ���
 * 1. �� ��ġ�� �����̶�� �����ϰ� -1 +1 *2 �� ��ġ�� ����� �����̶�� �����ϸ� bfs �ִܰŸ������� �ȴ�. 
 * 2. �� ��ġ�� ���� ��� ��ó�� ������ distance�� 1�� �ΰ� �����ϰ� check�迭�� �ȵθ� ã�� �� ����..
 * 3. bfsŽ���� ������������ ����ó�� �ʿ伺�� ������!!
 * 4. �Ʒ� �ð��� ������ Ǭ ������ �ִ�. �Լ��� ������ �� ����� �ڵ带 �������.
 */

public class BOJ_1697 {
    
    final static int size = 100001;
    static int[] direc = {-1, 1, 2};
    
    public static void main(String[] args) {
        
        Scanner sc  = new Scanner(System.in);
        int[] distance = new int[size]; 
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        
        int ans = bfs(distance, start, end);
        
        if(start == end)
        	ans = 0;
        
        System.out.println(ans);
        
    }
    
    static int bfs(int[] distance, int start, int end) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        distance[start] = 1;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i < 3; i++) {
            	
                int next = cur + direc[i];
                if(i == 2)
                    next = cur * direc[i];
                
                if(isIn(next) && distance[next] == 0) {
                    if(next == end)
                        return distance[cur];
                    else {
                        q.add(next);
                        distance[next] = distance[cur] + 1;
                    }
                }
            }
        }
        
         return -1;
        
    }
    static boolean isIn(int cur) {
        if(cur >= 0 && cur < size)
            return true;
        else
            return false;
    }
  
}





/*
 * 2021.07.14
 * BOJ 1697 ���ٲ��� https://www.acmicpc.net/problem/1697
 * ������ ��ǥ�󿡼� �������� �������� ���� �� +1 -1 *2 ������ ���길 �̿��ؼ� �������� �����ϴ� �Ÿ��̴�.
 * ������ ���������� 0�� ������ �Ͻ������� ��Ÿ��������, 
 * ���������� �Ÿ��� 1�� �ʱ�ȭ�ߴ�.(�̷��� �湮���θ� dist������ üũ�ؼ� �ߺ� �湮�� ������ �� �ִ�.) 
 * ��� ������ ���� �Ÿ����� -1�ؼ� ���� �����Ѵ�.
 * bfs/dfs�� �׻� �ѹ� �湮�ߴ� ���� �������� �ʴ� ��ġ�� �ʿ��ϴ�. 
 * start�� end�� ���� �� ����ó���� ������Ѵ�.
 */

//import java.util.*;
//import java.io.*;
//public class Main  {
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	public static void main(String[] args) throws IOException {
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int k = Integer.parseInt(st.nextToken());
//		
//		bw.write(bfs(n, k, 200000)+""); bw.flush();
//	}
//	static int bfs(int start, int end, int len) {
//		int[] dist = new int[len+1];
//		Queue<Integer> q = new LinkedList<Integer>();
//
//		if(start == end) 
//			return 0;
//
//		dist[start] = 1;
//		q.add(start);
//		while(!q.isEmpty()) {
//			int cur = q.poll();
//			//ã�ڸ��� �ٷ� �����ؼ� �����̶� ������ ���� �������ߴ�.
//			if(cur+1 == end || cur-1 == end || cur*2 == end) {
//				return dist[cur];
//			}
//			oneCycle(dist, q, cur, cur*2, len);
//			oneCycle(dist, q, cur, cur+1, len);
//			oneCycle(dist, q, cur, cur-1, len);
//		}
//		//��ã�� ����ε� ���⼭�� 1������ �����̱� ������ �̰��� ������ ���� ����.
//		return 0; 
//	}
//	
//	static void oneCycle(int[] dist, Queue<Integer> q, int cur, int next, int len) {
//		if(next >= 0 && next < len && dist[next] == 0) {
//			dist[next] = dist[cur]+1;
//			q.add(next);
//		}
//	}
//}


