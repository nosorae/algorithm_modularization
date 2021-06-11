package dfs_bfs;

import java.io.*;
import java.util.*;

/*
 * ���� 11724 ���� ����� ����
 * 1. �������� �ʱ�ȭ �� �����
 * 2. �������������� N*(N-1)/2 �� ������ �����غ���,
 * �� ���� ���̿� ������ �ϳ���� �߰�, �� ������ �ٸ� N-1���� ������ ��� ����Ǿ��ִٰ� �� ��
 * �׷� ������ N�� �ִٰ� �ϸ� N*(N-1)�̰� ������̴ϱ� /2 
 */
class BOJ_11724 {
    static BufferedReader br;
    static int n;
    static int m;
    static boolean[] check;
    static LinkedList<Integer>[] graph;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //���� ��, ���� ��, �׷��� �����迭 �ʱ�ȭ
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new LinkedList[n+1];
        check = new boolean[n+1];
        
        //�׷��� �� ������ ���Ḯ��Ʈ �ʱ�ȭ
        for(int i = 1; i <= n; i++) {
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
        
        int ans = 0; 
        //��� ������ ���������� ����ϰ� dfs����
        //�� ������ ��� ����Ǵ��İ� ������ ����
        for(int i = 1; i <= n; i++) {
            if(!check[i]) {
                ans++;
                dfs(i);
            }
        }
        
        System.out.println(ans);
       
    }
    static void dfs(int cur) {
        check[cur] = true;
        
        for(int next : graph[cur]) {
            if(!check[next])
                dfs(next);
        }
    }
}