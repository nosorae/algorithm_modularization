package PGM_Level1;

/*
 * 2021.06.19
 * PGM �̻��� ���� ����� https://programmers.co.kr/learn/courses/30/lessons/12930#
 * String => char[] ��ȯ & ���� => String ��ȯ ������ �����ϴ� ���
 * �빮�� ASCII 65 90
 * �ҹ��� ASCII 97 122
 * char�� ���������� �����ϴ�
 */
class PGM_MakeStrangeString {
    public String solution(String s) {
        char[] letters = s.toCharArray();
        
        int localIdx = -1;
        
        for(int i = 0; i < letters.length; i++) {
            
            char cur = letters[i];
            localIdx++;
            
            if(cur == ' ') {
                localIdx = -1;
                continue;
            }
            
            //¦���̰� �ҹ��ڴ� �빮�ڷ� �ٲ�����
            if(localIdx%2 == 0 && cur >= 97 && cur <= 122){
                letters[i] -= 32;    
            }
            
            //Ȧ���̰� �빮���̴� �ҹ��ڷ� �ٲ�����
            else if(localIdx%2 != 0 && cur >= 65 && cur <= 90){
                letters[i] += 32;

            }
        
        }
        
        
        String answer = new String(letters);
        return answer;
    }
    
   
}