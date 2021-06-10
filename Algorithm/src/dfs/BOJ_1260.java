package dfs;

import java.util.*;
import java.io.*;

/*
 * ����  1260 DFS�� BFS
 * 1. BufferedWriter/Reader �� �� �Լ��� throws IOException ���� ���� 
 * 2. static ������ ����
 * 3. ������ ��ŸƮ�� 1���� 0���� �� �ľ��ض�
 */

class BOJ_1260 {
    static boolean[] check;
    static LinkedList<Integer>[] graph;
    static BufferedReader br;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //���� ����, ���� ����, ��������
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        
        //�ʱ�ȭ
        graph = new LinkedList[n+1]; 
        for(int i = 1 ; i <= n; i++) {
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
        
        for(int i = 1 ; i <= n; i++) {
        	Collections.sort(graph[i]);
        }
        
        check = new boolean[n+1];
        dfs(start);
        
        bw.write("\n");
        
        check = new boolean[n+1];
        bfs(start);
        
        bw.flush();

    }
    static void bfs(int start) throws IOException {
        Queue<Integer> q = new LinkedList<Integer>();
        check[start] = true;
        q.add(start);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            bw.write(cur+" ");
            for(int next : graph[cur]) {
                if(!check[next]) {
                	check[next] = true;
                	q.add(next);
                }
                    
            }
        }
        
    }
    
    static void dfs(int cur) throws IOException {
        check[cur] = true;
        bw.write(cur+ " ");
        
        for(int next : graph[cur]) {
            if(!check[next])
                dfs(next);
        }
        
    }
}