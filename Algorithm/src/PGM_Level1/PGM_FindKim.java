package PGM_Level1;


/*
 * PGM ���￡�� �輭�� ã�� https://programmers.co.kr/learn/courses/30/lessons/12919?language=java
 */
class PGM_FindKim {
    public String solution(String[] seoul) {
         String answer = "";
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                answer = "�輭���� "+i+"�� �ִ�";
                break;
            }
        }
       
        return answer;
    }
}