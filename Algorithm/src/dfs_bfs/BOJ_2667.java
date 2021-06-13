package dfs_bfs;

import java.util.*;
import java.io.*;

/*
 * ���� 2667 ������ȣ ���̱�
 */

class BOJ_2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1}; //�����¿�
    static int size;
    static int[][] map; // ����
    static boolean[][] check; // �湮����
    static ArrayList<Integer> team = new ArrayList<Integer>();
    static int cnt; // �� ����
    
    public static void main(String[] args) throws IOException {
        // ���� ũ�� �Է°� �ʱ�ȭ
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        check = new boolean[size][size];
        
        // ���� �Է� 
        for(int i = 0; i < size; i++) {
            String line = br.readLine();
            for(int j = 0; j < size; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        
        // ��� ��ǥ�� ��ȸ�ϸ� �ش� ��ǥ���� 1�̸鼭 �湮���� �ʾҴٸ� dfs
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(map[i][j] == 1 && !check[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    team.add(cnt);
                } 
            }
        }
        
        Collections.sort(team);
        System.out.println(team.size());
        for(int ans : team) {
            System.out.println(ans);
        }
        
    }
    static void dfs(int curX, int curY) {
        check[curX][curY] = true;
        cnt++;
        
        for(int i = 0; i < 4; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];
            if(nextX >= 0 && nextX < size && nextY >= 0 && nextY < size) {
                if(map[nextX][nextY] == 1 && !check[nextX][nextY])
                    dfs(nextX, nextY);
            }
        }
        
        
    }
}