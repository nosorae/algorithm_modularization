package PGM_Level1;

/*
 * 21.06.17
 * ���α׷��ӽ� 2016 https://programmers.co.kr/learn/courses/30/lessons/12901#
 * ��¥ �Ű����� �Ǽ� ������ �ð� ���� ��Ƹ���.
 */

class PGM_2016 {
 public String solution(int a, int b) {
     final String[] days ={"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
     final int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
     int sum = 0;
     for(int i = 1; i < a; i++) {
         sum = sum + months[i];
     }
     sum = sum + b;
     int ans = sum % 7;
     String answer = days[ans] + "";
     
     
     
     return answer;
 }

}