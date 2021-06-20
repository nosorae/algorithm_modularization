package PGM_Level2;

/*
 * 2021.06.19
 * PGM ������
 * �ð����⵵ N^2�� �ƴ� NM�� �����غô�. 
 * �� �������� M�� 9�̴�. 
 * �߿䵵�� �ε������ϴ� �迭�� ����� �� ������ ���� �ִ븦 �����ذ��� 
 * ���� ���� ���� �ڷ� �ְų� �׳� ���ų��� �ݺ��Ѵ�.
 */
import java.util.*;

class PGM_Printer {
    public int solution(int[] priorities, int location) {
        int len = priorities.length;
        int popCnt = 0;

        // ť�� ������ max �ʱ�ȭ
        Queue<Doc> q = new LinkedList<Doc>();
        int[] maxArr = new int[10];


        for(int i = 0; i < len; i++) {
            int priority = priorities[i];
            q.add(new Doc(i, priority));
            maxArr[priority]++;
        }

        int maxIdx = 9;
        int answer = 0;
        while(!q.isEmpty()) {

            while(maxIdx >= 1 && maxArr[maxIdx] == 0) // ���� max ����
                maxIdx--;

            if(q.peek().pri < maxIdx) { // ���� max���� �۴ٸ� ������ ���� �ڷ� �ֱ�
                q.add(q.poll());
            }
            else {
                answer++;
                maxArr[maxIdx]--;
                if(location == q.peek().waitN) 
                    break;
                q.poll();
            }
        }


        return answer;
    }
}

class Doc {
    int waitN;
    int pri;
    public Doc(int w, int p) {
        waitN = w;
        pri = p;
    }
}