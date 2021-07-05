package PGM_Level2;

/*
 * 2021.07.02
 * PGM �ĺ�Ű https://programmers.co.kr/learn/courses/30/lessons/42890#
 * ��� �������� ������ ��� ������ �κ������� �˻��غ����Ѵ�. 
 * ��� 1~(1<<N)������ ��� ���ڷ� �õ��غ��� ��Ʈ�� 1�� ���� �������� �ĺ�Ű ���� ���θ� �õ��ؾ��Ѵ�.  
 * ���� 1~(1<<N)�������� K�� �˻��ϰ� �ִٰ� �����غ��� 
 * �׷��� ���� �ͺ��� �ĺ�Ű ������ ���� ���տ� �ְ� ���ο� �� �˻��� �� �˻��ϱ� ���� set ��ü�� ���� Ȯ���Ѵ�.
 * �ּҼ� -> ���ϼ� �Լ� ���� �����
 * �� ������ ��Ʈ�� Ǯ�� �������� �ּҼ� �˻翡 �ִ�.
 * 0011 1011 1001 1000 
 * 3 11 9 8
 */
import java.util.*;
class PGM_CandidateKey {
    static String[][] input;
    public int solution(String[][] relation) {
        input = relation;
        int answer = 0;
        int len = input[0].length; // �� ����
         HashSet<Integer> set = new HashSet<Integer>(); // �̹� �ĺ�Ű�� Ȯ�ε� ����
         
        for(int i = 1; i < (1<<len); i++) { 
            ArrayList<Integer> list = new ArrayList<Integer>(); // �� �ε���
            String bin = Integer.toBinaryString(i);
            
            for(int j = bin.length() - 1 ; j >= 0 ; j--) { // �� �κп��� �Ǽ��� �־���.
                if(bin.charAt(j) == '1') {
                    list.add(bin.length() -1 - j);
                }
            }

            if(!isMinimal(set, i))
                continue;
            
            if(isUnique(list)) {
                answer++;
                set.add(i);
            }
        }
        
        return answer;
    }
    static boolean isUnique(ArrayList<Integer> list) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < input.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < list.size(); j++) {
                sb.append(input[i][list.get(j)]);
            }
            String cur = sb.toString();
            
            if(set.contains(cur))
                return false;
            else
                set.add(cur);
        }
        return true;
    } 
    static boolean isMinimal(HashSet<Integer> set, int cur) {
        for(int s : set) {
            int temp = (s & cur);
            if((s^temp) == 0) // set���ִ� ������ ��� ��Ʈ�� �����ϰ� �ִ� ���
                return false;
        }
        return true;
    }
}