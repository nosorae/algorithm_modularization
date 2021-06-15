package dfs_bfs;

import java.util.*;
import java.io.*;

/*
 * ���� 1697 ���ٲ���
 * 1. �� ��ġ�� �����̶�� �����ϰ� -1 +1 *2 �� ��ġ�� ����� �����̶�� �����ϸ� bfs �ִܰŸ������� �ȴ�. 
 * 2. �� ��ġ�� ���� ��� ��ó�� ������ distance�� 1�� �ΰ� �����ϰ� check�迭�� �ȵθ� ã�� �� ����..
 * 3. bfsŽ���� ������������ ����ó�� �ʿ伺�� ������!!
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