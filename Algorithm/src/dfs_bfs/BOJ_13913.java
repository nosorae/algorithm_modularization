package dfs_bfs;

import java.util.*;
import java.io.*;
/*
 * ���� 13913 ���ٲ���4 
 * 1. ���� �������� �̵��ϴ� next������ �ִ밪 ���ó���� ���൵ �ǰ�
 *    ���� �������� �̵��ϴ� next������ �ּҰ� ���ó���� ���൵ �ȴ�.
 * 2. �Ʒ� ������ �ڵ嵵 �ִ�.
 */
public class BOJ_13913 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int start;
    static int end;
    static final int size = 200001;
    static int[] dist = new int[size];
    static int[] prev = new int[size];
    static int[] direc = {-1, 1, 2};
    public static void main(String[] args) throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        if(start == end) {
            System.out.println(0);
            printTrace(end, start);
            return;
        }
        else {
            int ans = bfs(start, end);
            System.out.println(ans);
            printTrace(end, start);
        }
            
        
        
    }
    
    static int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        dist[start] = 1;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i < 3; i++) {
                int next = cur + direc[i];
                if(i == 2) 
                    next = cur * direc[i];
                if(next >= 0 && next < size && dist[next] == 0) {
                    prev[next] = cur;
                    
                    if(next == end)
                        return dist[cur];
                    
                    
                    q.add(next);
                    dist[next] = dist[cur] + 1;
                   
                }
            }
        
        }
        return 0;
    }
    static void printTrace(int end, int start) {
        Stack<Integer> stack = new Stack<Integer>();
        int cur = end;
        while(cur != start) {
            stack.push(cur);
            cur = prev[cur];
        }
        stack.push(cur);
        
        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
        
    }
}


/*
 * 2021.07.14
 * BOJ 13913 ���ٲ���4 https://www.acmicpc.net/problem/13913
 * ���� ���ٲ��� �������� start���� end�� ��������� ��ε� ����ؾ��ϴ� ����
 * prev�迭�� ���� ������ȣ�� ����� ���� �������� ��ε� ���� �� �ִ�.
 * ���� ���ٲ��� Ǯ �� next�� ã�� �� �ٷ� �ִܰŸ��� return�ϰ� �����µ� �̹����� end�� prev�� ä������Ѵ�.
 * �ȱ׷��� oneCycle�Լ��� ���� �ʾƼ� prev[end]�� ���� 0�̶� ���ѹݺ����� ����.
 * �׸��� ������ �ٷ� return�ϵ��� �ߴµ� ���� ��쵵 �����ϳ��� ����ؾ��ϹǷ� prev[start]=-1�� �� ������ ���ش�.
 */

//import java.util.*;
//import java.io.*;
//public class Main  {
//	static int[] prev = new int[200001];
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	public static void main(String[] args) throws IOException {
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int k = Integer.parseInt(st.nextToken());
//		
//		bw.write(bfs(n, k, 200000)+"\n");
//		traceBack(k);
//		
//		bw.flush();
//	}
//	static int bfs(int start, int end, int len) {
//		int[] dist = new int[len+1];
//		Queue<Integer> q = new LinkedList<Integer>();
//		
//		prev[start] = -1;
//		if(start == end) 
//			return 0;
//		
//		dist[start] = 1;
//		q.add(start);
//		while(!q.isEmpty()) {
//			int cur = q.poll();
//			//ã�ڸ��� �ٷ� �����ؼ� �����̶� ������ ���� �������ߴ�. �̰� ���������� ��������. 
//			//������ �͵� prev�� �־��־���ߴ�.
//			if(cur+1 == end || cur-1 == end || cur*2 == end) {
//				prev[end] = cur;
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
//			prev[next] = cur;
//			q.add(next);
//		}
//	}
//	
//	static void traceBack(int end) throws IOException {
//		Stack<Integer> stack = new Stack<Integer>();
//		int cur = end;
//		while(cur != -1) {
//			stack.add(cur);
//			cur = prev[cur];
//		}
//		
//		while(!stack.isEmpty()) {
//			bw.write(stack.pop()+" ");
//		}
//	}
//}

