package PGM_Level2;

/*
 * 2021.07.02
 * PGM ���� https://programmers.co.kr/learn/courses/30/lessons/17684
 * �ϴ� HashMap<String, Integer>�� �ܾ�� ���ι�ȣ�� �����ؾ߰ڴ�.
 * A-Z���� 1~26���� �ʱ�ȭ
 * wã�� ���ι�ȣ ���, �������� �ٿ��� ������ ���
 * �׳� ��Ű�´�� �ߴ��� Ǯ����.
 */
import java.util.*;
class PGM_Compression {
    static int idx;
    static int len;
    public int[] solution(String msg) {
        idx = 1;
        HashMap<String, Integer> dic = new HashMap<>();
        for(char c = 'A'; c <= 'Z'; c++)
            dic.put(c+"", idx++);
        
        len = msg.length();
        int start = 0;
        int end = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < len; ) {
            start = i;
            end = findEnd(dic, msg, start);
            String w = msg.substring(start, end); //ó���� ���ڿ�
            ans.add(dic.get(w));
            if(end+1 <= len)
                dic.put(msg.substring(start, end+1), idx++);// w+c�� ������ �߰�
            i = end; // �ε����� ����
        }
        
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            answer[i] = ans.get(i);
        
        return answer;
    }
    static int findEnd(HashMap<String,Integer> dic, String msg, int start) {
        for(int i = start+1; i <= len; i++) {
            String sub = msg.substring(start, i);
            if(!dic.containsKey(sub))
                return i-1;
        }
        return len;
    }
}