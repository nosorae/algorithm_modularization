package PGM_Level1;


/*
 * 2021.06.21
 * PGM �������� ���� ���� https://programmers.co.kr/learn/courses/30/lessons/42576
 * �� ������ �ٽ��� �ߺ��̸��� ���� �� �ִٴ� ���̴�.
 * �ߺ��̸��� ���ٸ� HashSet���ε� ������ �ذ��� �� ������, �ߺ��̸��� ���ڸ� ���ֱ� ���� HashMap�� ����Ͽ���.
 */

import java.util.*; 
class PGM_UnfinishedPlayer_Hard {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int len = participant.length;
        HashMap<String, Integer> pass = new HashMap<String, Integer>();
        
        for(int i = 0; i < participant.length; i++) {
            if(pass.containsKey(participant[i]))
                pass.put(participant[i], pass.get(participant[i]) + 1); // �ߺ��̸��̶�� 1 �����ش�.
            else
                pass.put(participant[i], 1); // ó�� ������ �̸��̸� value�� 1�� �ʱ�ȭ
        }
        
        for(int i = 0; i < completion.length; i++) {
            String name = completion[i];
    
            if(pass.get(name) >= 2)
                pass.put(completion[i], pass.get(completion[i]) - 1); //2 �̻��̸� value 1 ���ְ�
            else {
                pass.remove(name); // 1�̸� �ʿ��� �����Ѵ�
            }
        }
        
        Iterator<String> it = pass.keySet().iterator();
        answer = it.next();

        return answer;
    }
}