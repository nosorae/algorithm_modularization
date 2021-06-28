package PGM_Level2;

/*
 * 2021.06.28
 * PGM Ʃ�� https://programmers.co.kr/learn/courses/30/lessons/64065
 * �ߺ����� ���� �迭�� �־��� ��, 
 * �ߺ�o, ����o
 * �ϴ� �Է����� �־��� s �Ľ��� ���� : s.split("[^0-9]+")�� �ذ�
 * split�� ����� �ε��� 0�� ���ڿ��� ����� ������??
 * Map���� ����Ƚ���� �����ش�.
 * �׸��� ����Ƚ���� �������� �����ؼ� �����ؾ��ϱ� ������ Ŭ��������� ����Ƚ���� �����Ѵ�
 * ���ڸ� String���� ó�������� �������� �� �� ���� ���ڷ� �Ľ����ִ� �� ��������!
 * 31��
 */
import java.util.*;
class PGM_Tuple {
    public int[] solution(String s) {
        String[] sArr = s.split("[^0-9]+");
        HashMap<String, Integer> sMap = new HashMap<>();
        for(int i = 1; i < sArr.length; i++) {
            String key = sArr[i];
            if(sMap.containsKey(key))
                sMap.put(key, sMap.get(key) + 1);
            else
                sMap.put(key, 1);
        }
        ArrayList<Tuple> ans = new ArrayList<>();
        for(Map.Entry<String, Integer> e : sMap.entrySet()) 
            ans.add(new Tuple(e.getKey(), e.getValue()));
        
        Collections.sort(ans);
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = Integer.parseInt(ans.get(i).num);
        }
        
        return answer;
    }
    class Tuple implements Comparable<Tuple> {
        String num;
        int cnt;
        public Tuple(String n, int c) {
            num = n;
            cnt = c;
        }
        @Override
        public int compareTo(Tuple o) {
            return o.cnt - this.cnt; // cnt���� ��������
        }
    }
}