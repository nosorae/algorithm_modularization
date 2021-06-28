package PGM_Level2;

/*
 * 2021.06.28
 * PGM �޴� ������ https://programmers.co.kr/learn/courses/30/lessons/72411
 * ��ǰ -> �ڽ��丮, �ּ� �θ��̻��� ���帹�� �Բ� �ֹ��� ��ǰ�޴��� ����
 * �ּ� 2���̻����� ����
 * �Է��� ���� ���� �𸣴� �� �غ����ϰ�, �� order�� course������ŭ ����
 * �� order�� ���ĵǾ� ������ ������ ������������ �����Ͽ� �ذ�
 * �� ���յ��� HashMap���� ī��Ʈ�ؼ� �� ���ڿ� �´� max�� ã�´�.
 * �ּ� �θ��̻��� �ش� ������ �ֹ��ؾ��Ѵٴ� ������ ��� �� ����ȿ����� �ߺ��� ������ 2 �̻��̸� �ȴ�.
 * �������� course�� ���ĵǾ��ִٰ� �ߴµ� ���� order���� ���� ���ĵǾ��ִ� �� �˾Ҵ�.
 * 51��
 */
import java.util.*;

class PGM_MenuRenewal {
    static HashMap<String, Integer>[] orderMap;
    static int orderMapIdx = 0;
    
    static int[] combi = new int[10];
    
    public String[] solution(String[] orders, int[] course) {
        
        //�ؽ����� �迭 �ʱ�ȭ
        orderMap = new HashMap[course.length];
        for(int i = 0; i < course.length; i++) {
            orderMap[i] = new HashMap<String, Integer>();
        }
        
        for(int i = 0; i < orders.length; i++) {
            char[] curOrder = orders[i].toCharArray();
            Arrays.sort(curOrder);
            
            for(int j = 0; j < course.length; j++) {
                orderMapIdx = j;
                putIntoMap(curOrder, 0, 0, course[j]);
            }
        }
        
        // for(Map.Entry<String, Integer> e : orderMap[0].entrySet())
        //     System.out.println(e.getKey() +" " + e.getValue());
        
        int[] maxCourse = new int[course.length]; //���� �ĺ����� ����Ƚ��
        for(int i = 0; i < course.length; i++) {
            for(int val : orderMap[i].values()) {
                if(maxCourse[i] < val)
                    maxCourse[i] = val;
            } 
        }
        ArrayList<String> ans = new ArrayList<String>();
        for(int i = 0 ; i < orderMap.length; i++) {
            for(Map.Entry<String, Integer> e : orderMap[i].entrySet()) {
                if(maxCourse[i] < 2)
                    break;
                if(maxCourse[i] == e.getValue())
                    ans.add(e.getKey());
            }
        }
        
        Collections.sort(ans);
        String[] answer = {};
        answer = ans.toArray(new String[ans.size()]);
        return answer;
    }
    //���Ʈ����
    static void putIntoMap(char[] curOrder, int depth, int start, int m) {
        if(depth == m) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < depth; i++) {
                sb.append(curOrder[combi[i]]);
            }
            String key = sb.toString();
            if(orderMap[orderMapIdx].containsKey(key))
                orderMap[orderMapIdx].put(key, orderMap[orderMapIdx].get(key) + 1);
            else
                orderMap[orderMapIdx].put(key, 1);
        }
        for(int i = start; i < curOrder.length; i++) {
            combi[depth] = i;
            putIntoMap(curOrder, depth+1, i+1, m);
        }
        
    }
}