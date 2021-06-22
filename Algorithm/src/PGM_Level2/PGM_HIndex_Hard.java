package PGM_Level2;

import java.util.*;

/*
 * 2021.06.22
 * PGM H-Index https://programmers.co.kr/learn/courses/30/lessons/42747#
 * �ϴ� ���� Ǭ ����� �ο�� �������� �����ؼ� ū �ͺ��� Ȯ���ؼ� �ε���(�� ���ݱ��� ������ �� ��)�� ���ؼ� 
 * ã���� �� ã���� ���� �ο��-1���� ++�غ���, ���� ��ã�Ҵٸ� ��� ���� �ο������ ���� ������ ū ���̹Ƿ� ���� ������ ��
 * �� ����� �ٸ� ����� Ǯ�̰� �Ʒ� �ִ�. 
 * �ο�� �������� �����ؼ� �ο�� ū �ͺ��� Ȯ���ϸ� �ο���� ������ ���� ������ ���� ���� ���ؼ� ���� ���� �� �ĺ����ǰ�
 * ���߿��� �ִ밪�� ���̵ȴ�.
 */

class PGM_HIndex_Hard {
    public int solution(int[] citations) {
              
        int len = citations.length;
        Integer[] cit = new Integer[len];
        for(int i = 0; i < len; i++) 
            cit[i] = citations[i];
        Arrays.sort(cit, Collections.reverseOrder());
        // 1000 1000 1000 1000 1 0 =>  4
        int answer = 0;
        int curH = 0;
        int idx = 0;
        for(int i = 0; i < len; i++) {
            int h = cit[i];
            if(i+1 >= h) {
                curH = h;
                idx = i;
                break;
            }
        }
             
        
        while(curH < idx) {
            curH++;    
        }
        
        answer = curH;
        // if(len == 1 && cit[0] > 1)
        //     answer = 1;
        if(idx == 0) { //�� for������ ��ã�� ��� ����ó��
            answer = len;
            if(cit[0] == 0)
                answer = 0;
        }
            
        
        return answer;
    }
}


// import java.util.*;

// class Solution {
//     public int solution(int[] citations) {
//         Arrays.sort(citations);

//         int max = 0;
//         for(int i = citations.length-1; i > -1; i--){
//             int min = (int)Math.min(citations[i], citations.length - i);
//             if(max < min) max = min;
//         }

//         return max;
//     }
// }