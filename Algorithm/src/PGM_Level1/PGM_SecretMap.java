package PGM_Level1;

//���簢�� ���� n
//�ϳ��� �� -> ��  1
//��� ���� -> ����  0
//���� �� ��Ʈ�� ��ġ�� �ش��Ѵ�.
/*
* 2021.06.19
* PGM ������� https://programmers.co.kr/learn/courses/30/lessons/17681
* ������ 1�̶�� �����ϰ� ó���� &�� �ߴٰ� ������
* ��Ʈ���� ���� https://coding-factory.tistory.com/521 (����) 
* �Ʒ� �������� �� ������ �ڵ�ε� Ǯ �� �ִ�.
* Integer.toBinaryString(int) 
* String.format("%" + n + "s", result[i])  https://interconnection.tistory.com/116 (����)
* String[].replaceAll("", "")�� Ȱ���ؼ��� Ǯ �� �ִ�.
*/
class PGM_SecretMap {
 public String[] solution(int n, int[] arr1, int[] arr2) {
     
     int[] andOpResult = new int[n];
     
     for(int i = 0; i < n; i++) {
         andOpResult[i] = arr1[i] | arr2[i];
     }
     
     String[] answer = new String[n];
     
     for(int i = 0; i < n; i++) {
         StringBuilder sb  = new StringBuilder();
         for(int j = 0; j < n; j++) {
             
             //System.out.println("���ڴ� "+andOpResult[i]+" �������� "+(andOpResult[j]>>j));
             
             if((andOpResult[i] >> j) % 2 != 0)
                 sb.append("#");
             else
                 sb.append(" ");
         }
         //System.out.println();
         answer[i] = sb.reverse().toString();
     }
     
     
     return answer;
 }
}