package PGM_Level1;


/*
 * 2021.06.19
 * PGM �ζ��� �ְ� ������ ���� ���� https://programmers.co.kr/learn/courses/30/lessons/77484
 * ������ ������� ���� ����� ���� ������Ѵٴ� ���� �Ű�ȽἭ �ð� ��Ƹ���
 */
class PGM_LottoMaxMinGrade {
    static final int[] grade = {6, 6, 5, 4, 3, 2, 1};
    public int[] solution(int[] lottos, int[] win_nums) {
        
        boolean[] exist = new boolean[46];
        int zeroCnt = 0;
        
        //������ ���ڿ� 0�� ���� üũ
        for(int i = 0; i < lottos.length; i++) {
            exist[lottos[i]] = true;
            if(lottos[i] == 0)
                zeroCnt++;
        }
        
        //��÷���ڹ迭�� �ش��ϴ� ���ڰ� ��ִ��� ī��Ʈ
        int eqCnt = 0;
        for(int i = 0; i < win_nums.length; i++) {
            if(exist[win_nums[i]])
                eqCnt++;
        }
        
        
        //�ִ� �ּ� �Է�
        int[] answer = new int[2];
        answer[0] = grade[eqCnt+zeroCnt];
        answer[1] = grade[eqCnt];
        
        return answer;
    }
}