package PGM_Level1;

import java.util.*;
/*
 * 2021.06.23
 * PGM Ű�е� ������ https://programmers.co.kr/learn/courses/30/lessons/67256
 * 4���� �̵� 
 * 147�� �޼� 369�� ������
 * 2580�� ����� ������ �����µ�, �� �������� ������.
 * �־��� ���ڹ迭�� �ϳ��� ������, ������ġ���� �޼����� ������ ���������� ������ ����
 * switch������ break ������ ���� 
 * 0�� ���Դ� �Ǽ� �߾���.
 * 33��
 */
class PGM_PushKeypad {
    public String solution(int[] numbers, String hand) {
        int[] left = {3, 0};
        int[] right = {3, 2};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++) {
            switch(numbers[i]) {
                case 1, 4, 7:
                    left[0] = numbers[i]/3;
                    left[1] = 0;
                    sb.append("L");
                    break;
                case 3, 6, 9:
                    right[0] = (numbers[i]/3)-1;
                    right[1] = 2;
                    sb.append("R");
                    break;
                case 2, 5, 8, 0:
                    if(numbers[i] == 0)
                        numbers[i] = 9;
                    int distLeft = abs(left[0], numbers[i]/3) + abs(left[1], 1);
                    int distRight = abs(right[0], numbers[i]/3) + abs(right[1], 1);
                    if(distLeft > distRight) {
                        right[0] = numbers[i]/3;
                        right[1] = 1;
                        sb.append("R");
                    } else if(distLeft < distRight) {
                        left[0] = numbers[i]/3;
                        left[1] = 1;
                        sb.append("L");
                    } else {
                        if(hand.equals("left")) {
                            left[0] = numbers[i]/3;
                            left[1] = 1;
                            sb.append("L");  
                        }
                        else {
                            right[0] = numbers[i]/3;
                            right[1] = 1;
                            sb.append("R");
                        } 
                        
                    }
            }
        }

        return sb.toString();
    }
    static int abs(int a, int b) {
        if(a > b)
            return a-b;
        else
            return b-a;
    }
}