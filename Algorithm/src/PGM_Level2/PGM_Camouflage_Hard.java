package PGM_Level2;


/*
 * 2021.06.20
 * PGM ���� https://programmers.co.kr/learn/courses/30/lessons/42578
 * ���� ���� 0���� ���ϱ� Ʋ����.. 1���� ���� �´�!
 * ������ �������� ���԰ų� �����ϳ��� ���� �� ������ +1 �ؼ� �� �����ְ� -1 ���ָ� 1���̻��Դ� ��� ������ ���´�.
 * ���Դ� ���� �ϳ��� ������ �����ؼ� ������ �����ϴ� ����� �����!
 * clothes[i][1] �̰� ������ ���� ���� �� �� ������
 *
 */ 

import java.util.*;

class PGM_Camouflage_Hard {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> clothCnt = new HashMap<String, Integer>();
        
        for(int i = 0; i < clothes.length; i++) {
            if (!clothCnt.containsKey(clothes[i][1])) {
                clothCnt.put(clothes[i][1], 1);
            } 
            else {
                int temp = clothCnt.get(clothes[i][1]) + 1;
                clothCnt.put(clothes[i][1] , temp);
            }
        }
        
        int answer = 1;
        
        for(Integer n : clothCnt.values()) {
            answer *= (n+1);
        }
        answer--;
        
        return answer;
    }
}