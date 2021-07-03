package PGM_Level2;

// 2021.07.02
// N���� ���� https://programmers.co.kr/learn/courses/30/lessons/17687
//������ �������°� ��ȯ�ϴ� �Լ� �ʿ�
//�׸��� m(�����ο�)�� ���ذ��� ���  
import java.util.*;
class PGM_ChangeUnitGame {
 static char[] nChar;
 public String solution(int n, int t, int m, int p) {
     
     inIt(); //�ʱ�ȭ
     
     //������ �´� 1~m*t������ ���� ����
     StringBuilder sb = new StringBuilder();
     for(int i = 0; i <= m*t; i++) {
         sb.append(parseNum(i, n));
     }
     String nums = sb.toString();
     //System.out.println(nums);
     
     int idx = p-1; // �ε����� 0���� �����ϴϱ� -1
     sb = new StringBuilder();
     for(int i = 0; i < t; i++) { // �ο��� ��ŭ ���ذ��� t�� �ݺ�
         sb.append(nums.charAt(idx));
         idx += m; 
     }
     
     return sb.toString();
 }
 static void inIt() {
     // ���ڿ� ���� ���ڿ� �ε��� �ʱ�ȭ
     nChar = new char[16];
     int idx = 0;
     for(char i = '0'; i <= '9'; i++) {
         nChar[idx] = i;
         idx++;
     }
     idx = 10;
     for(char i = 'A'; i <= 'F'; i++) {
         nChar[idx] = i;
         idx++;
     }
 }
 static String parseNum(int n, int nota) {
    
     if(n == 0) // 0�� ����ó��
         return "0";
     
      StringBuilder sb = new StringBuilder();
     int cur = n;
     while(cur != 0) {
         sb.append(nChar[cur%nota]);
         cur /= nota;
     }
     return sb.reverse().toString();
 }
}