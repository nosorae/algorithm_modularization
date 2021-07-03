package PGM_Level2;

// 2021.07.02
// PGM �ܾ� ��ȯ https://programmers.co.kr/learn/courses/30/lessons/43163
//�� ���� �ܾ� begin, target�� �ܾ��� ���� words�� �Ű������� �־��� ��, �ּ� �� �ܰ��� ������ ���� begin�� target���� ��ȯ�� �� �ִ��� return 
//�ּ� �Ÿ��� ã�¹���, �ܾ���� �����̰� �ѱ��ڸ� ���̳��� ���� �ƴٰ� �����ϸ� bfs������ �ȴ�.
//��ȯ �Ұ��� ��� 0����
import java.util.*;
class PGM_WordTransformation {
 static int[] dist;
 static String[] print;
 public int solution(String begin, String target, String[] words) {
     print = words;
     int len = words.length;
     LinkedList<Integer>[] graph = new LinkedList[len];
     for(int i = 0; i < len; i++) {
         graph[i] = new LinkedList<Integer>();
     }
     
     // �׷��� �ʱ�ȭ
     for(int i = 0; i < len; i++) {
         for(int j = 0; j < len; j++) {
             if(i == j) continue;
             if(isLinked(words[i], words[j]))
                 graph[i].add(j);
         }
     }
     
     //���� �� �ε��� ã�� 
     int start = -1;
     int end = -1;
     for(int i = 0; i < len; i++) {
         if(isLinked(words[i], begin))
             start = i;
         if(words[i].equals(target))
             end = i;
     }
     if(start == -1 || end == -1) //������ �ٷ� 0 ��ȯ
         return 0;
     
     
     
     
     
     System.out.println(start+" "+end);
     
     bfs(graph, start, end);
     int answer = dist[end];
     return answer;
 }
 static boolean isLinked(String s1, String s2) {
     int cnt = 0;
     for(int i = 0; i < s1.length(); i++) {
         if(s1.charAt(i) != s2.charAt(i))
             cnt++;
     }
     if(cnt == 1)
         return true;
     else
         return false;
 }
 
 static void bfs(LinkedList<Integer>[] graph, int start, int end) {
     Queue<Integer> q = new LinkedList<Integer>();
     dist = new int[graph.length];
     
     dist[start] = 1;
     q.add(start);
     while(!q.isEmpty()) {   
         int cur = q.poll();
         for(int next : graph[cur]) {
             if(dist[next] == 0) {
                 dist[next] = dist[cur] + 1;
                 q.add(next);
             }
         }
     }
 }
}