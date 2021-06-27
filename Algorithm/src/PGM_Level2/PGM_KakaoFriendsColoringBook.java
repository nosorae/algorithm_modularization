package PGM_Level2;

/*
 * 2021.06.26
 * PGM īī�������� �÷����� 
 * ������ã�� �����ε�, �� �������� ���������� ã������ϰ�, 
 * ���������� ���� ��ٷӴ�. �����¿�� �⺻�̰�, ���� ���ƾ� ����� ���̴�.
 * ���Դ� ���� �� ���͵� �ȴ�.
 * solution�Կ����� ��� ������ check�ؼ� �湮x�� bfs�õ��ϰ�, bfs�Լ��� ������ �����ؼ� 
 * �����ִ� ������ �����ϰڴ�.
 * m�� ���� ��, n�� ���� ���� �Ϳ� ����
 * 27��
 */
import java.util.*;

class PGM_KakaoFriendsColoringBook {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] check = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!check[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    int temp = bfs(picture, check, i, j);
                    if(maxSizeOfOneArea < temp)
                        maxSizeOfOneArea = temp;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static int bfs(int[][] picture, boolean[][] check, int startX, int startY) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0}; // ��������
        int cntV = 0; //���� �� ���� ����
        // ť�� �ְ� �湮 üũ�ϰ� ���� ���� ����
        Queue<Integer> qX = new LinkedList<Integer>();
        Queue<Integer> qY = new LinkedList<Integer>();
        qX.add(startX);
        qY.add(startY);
        check[startX][startY] = true;
        cntV++;
        
        while(!qX.isEmpty()) {
            int curX = qX.poll();
            int curY = qY.poll();
            for(int i = 0; i < 4; i++) {
                int nX = curX + dx[i];
                int nY = curY + dy[i];
                //���� Ȯ�� && �湮���� Ȯ�� && ���� ������ ��, ����ƴ��� Ȯ�� 
                //picture�� 0���� Ȯ���� �ʿ䰡 ����. 
                //�ֳ��ϸ� solution���� �̹� 0�� �ƴ� ���·� ���Ա� �����̴�.
                if(isIn(picture.length, picture[0].length, nX, nY) 
                   && !check[nX][nY] && picture[curX][curY] == picture[nX][nY]) {
                    qX.add(nX);
                    qY.add(nY);
                    check[nX][nY] = true;
                    cntV++;
                }
            }
        }
        return cntV;
    }
    
    static boolean isIn(int n, int m, int x, int y) {
        if(x >= 0 && x < n && y >= 0 && y < m) 
            return true;
        else
            return false;
    }
}