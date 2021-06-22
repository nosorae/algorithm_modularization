package PGM_Level2;

/*
 * 2021.06.22
 * PGM ī�� https://programmers.co.kr/learn/courses/30/lessons/42842
 * ���� ���Ʈ���� ������� Ǯ���µ�(���μ��� ���� ��� ����� ���� �� �غ�)
 * �׳� �ܼ� ������ε� �Ǵ� �ٸ� ����� Ǯ�̵� ���Ҵ�. 
 */
class PGM_Carpet_Hard {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        
        int row = 3;
        int col = 3;
        boolean isFound = false;
        while(true) {
            for(col = row; col < 2500; col++) {
                int calYellow = (row-2)*(col-2);
                int calBrown = (row*col) - calYellow;
                if(brown == calBrown && yellow == calYellow) {
                    isFound = true;
                    break;
                }
            }
            if(isFound)
                break;
            row++;
        }
        answer[0] = col;
        answer[1] = row;
        
        return answer;
    }
}

/*
 * a�� ���α��� ���α��� ���̶�� �Ѵ�.
 * b��  ��ü Ÿ�� �� �� brown + yellow
 * 
 */

//import java.util.*;
//class Solution {
//    public int[] solution(int brown, int red) {
//        int a = (brown+4)/2;
//        int b = red+2*a-4;
//        int[] answer = {(int)(a+Math.sqrt(a*a-4*b))/2,(int)(a-Math.sqrt(a*a-4*b))/2};
//        return answer;
//    }
//}