package PGM_Level1;

/*
 * 2021.06.23
 * PGM ���ڿ� �ٷ�� �⺻ https://programmers.co.kr/learn/courses/30/lessons/12918
 * �� ����� �ڵ带 ã�ƺ� ��
 * (�߰�) 0�� ���ڶ���..
 * ���Խ� Ǯ��1 ���̰˻� -> s.matches("(^[0-9]*$)"); 
 * ���Խ� Ǯ��2 s.matches("^[0-9]{4}|{6}$");
 */

class PGM_StringBasic {
    public boolean solution(String s) {
        int len = s.length();
        if(len == 4 || len == 6) {
            for(int i = 0; i < len; i++) {
                if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }
}