package PGM_Level1;



/*
 * 21.06.17
 * ���α׷��ӽ� ������ https://programmers.co.kr/learn/courses/30/lessons/42840
 * 1���� 12345 �ݺ�
 * 2���� 21232425 �ݺ�
 * 3���� 3311224455 �ݺ�
 * ȿ�������� Ǫ�� ���?  Ŭ������ ���� �й��� 
 * int b = (5 < 4) ? 50 : 40; ���׿����� ����
 * new int[] {} �迭 �ʱ�ȭ ���
 * �ְ����� �Ҷ� max �Լ� ���� ��ø�ؼ� �ι����� ��� -> �ƽ� ���س��� �ƽ��� ���� ���� ���� ã�Ƽ� 
 */
class PGM_MockTest_Hard {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] ansCnt = {0, 0, 0};
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == student1[i%student1.length]) 
                ansCnt[0]++;
            if(answers[i] == student2[i%student2.length])
                ansCnt[1]++;
            if(answers[i] == student3[i%student3.length])
                ansCnt[2]++;
        }
      
        
        int[] answer = {};
        
        //1���� ������ ���
        if(ansCnt[0] == ansCnt[1] && ansCnt[1] == ansCnt[2]) 
            answer = new int[] {1, 2, 3};
        
        //1���� �θ��� ���
        else if(ansCnt[1] == ansCnt[2] && ansCnt[2] > ansCnt[0]) 
            answer = new int[] {2, 3};
        
        else if(ansCnt[0] == ansCnt[1] && ansCnt[1] > ansCnt[2])
            answer = new int[] {1, 2};
        
        else if(ansCnt[0] == ansCnt[2] && ansCnt[2] > ansCnt[1])
            answer = new int[] {1, 3};
        
        //1���� �Ѹ��� ���
        else {
            int max = 0;
            int winner = 0;
            if(ansCnt[0] > ansCnt[1]){
                max = ansCnt[0];
                answer = new int[] {1};
           }
            else {
                max = ansCnt[1];
                answer = new int[] {2};
            }
                
            if(ansCnt[2] > max) {
                max = ansCnt[2];
                answer = new int[] {3};
            }
            
        }
        
        
        return answer;
    }
}

