package dfs_bfs;

import java.util.*;
import java.io.*;

/*
 * ���� 2178�� �̷� Ž��
 * 1. �ε����� 1���� �����ϴµ� ���˻�� 0~(n-1)���ؼ� n,m�� ���� ��� 0�� ������ ������ �־���.
 * 2. �׸��� ��� ���� ���̰� �ٸ��� �־����� �����ε�, ����for�� 2���� �迭 �Է¿��� m�� �ƴ� n���� �Է¹޵��� ��Ÿ�� �´�. ���� ����..
 */

public class BOJ_2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0}; // ��������
    static int n; // ����
    static int m; // ����
    static int[][] map; //����
    static int[][] check; // �湮�������� �Ÿ�
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n+1][m+1];
        check = new int[n+1][m+1];
        
        for(int i = 1; i <= n; i++) {
            String line = br.readLine();
            for(int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j-1) - '0';
            }
        }
        
        bfs(1, 1);
        
        System.out.println(check[n][m]);
//        for(int i = 1; i <= n; i++) {
//        	for(int j = 1; j <= m; j++) {
//        		System.out.print(check[i][j]+" ");
//        	}
//        	System.out.println();
//        }
    }
    
    static void bfs(int startX, int startY) {
        Queue<Integer> qX = new LinkedList<Integer>();
        Queue<Integer> qY = new LinkedList<Integer>();
        qX.add(startX);
        qY.add(startY);
        int distance = 1;
        check[startX][startY] = distance;
        

        while(!qX.isEmpty()) {
            int curX = qX.poll();
            int curY = qY.poll();
            distance = check[curX][curY];
            distance++;
            for(int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if(isIn(n, m, nextX, nextY) && map[nextX][nextY] == 1 
                   && check[nextX][nextY] == 0)  {
                    qX.add(nextX);
                    qY.add(nextY);
                    check[nextX][nextY] = distance;
                }
            }
        }
    }
    
    static boolean isIn(int vertical, int horizontal, int x, int y) {
        if(x >= 1  && x <= vertical && y >= 1 && y <= horizontal) 
            return true;
        else 
            return false;
    }
}

//import java.util.*;
//
//class Pair {
//    int x;
//    int y;
//    Pair(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//public class Main {
//    public static final int[] dx = {0, 0, 1, -1};
//    public static final int[] dy = {1, -1, 0, 0};
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] a = new int[n][m];
//        sc.nextLine();
//        for (int i=0; i<n; i++) {
//            String s = sc.nextLine();
//            for (int j=0; j<m; j++) {
//                a[i][j] = s.charAt(j) - '0';
//            }
//        }
//        int[][] dist = new int[n][m];
//        boolean[][] check = new boolean[n][m];
//        Queue<Pair> q = new LinkedList<Pair>();
//        q.add(new Pair(0, 0));
//        check[0][0] = true;
//        dist[0][0] = 1;
//        while (!q.isEmpty()) {
//            Pair p = q.remove();
//            int x = p.x;
//            int y = p.y;
//            for (int k=0; k<4; k++) {
//                int nx = x+dx[k];
//                int ny = y+dy[k];
//                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
//                    if (check[nx][ny] == false && a[nx][ny] == 1) {
//                        q.add(new Pair(nx, ny));
//                        dist[nx][ny] = dist[x][y] + 1;
//                        check[nx][ny] = true;
//                    }
//                }
//            }
//        }
//        System.out.println(dist[n-1][m-1]);
//    }
//}