package PGM_Level2;

/*
 * 2021.06.26
 * PGM ��ü���� ��� https://programmers.co.kr/learn/courses/30/lessons/1835
 * ���� �м� - �˰��� ���� - ������ �����ڵ� - �ڵ� �� ������ �� ���״�.
 * �ð��� �����ɸ� ������ ���� �м����� �ڵ�� �ű� �� �߻��ߴ�. 
 * ���� ����(���� ��� indexOf charAt �̷� �� ���� �����ϴ� �Ͱ� �޶� ���� Ʋ���� �� �˾Ҵµ�,
 * �˰��� �׳� +1 �ϳ��� �����༭ �׷���... +1������ 40�� ���ȴ�. 
 * �̻�� �ʰ�, ���Ͽ� �̸��� ���̸� �ΰ��ϰ� �޾Ƶ鿩��.
 * ���������� Ʋ�� �ſ��� �ظ��� ���� ������ ��Ȯ�� ���״��� 1������ �� Ȯ���ؼ� �ð����� ���� ��!
 * 1�ð� 16��
 * ��� ���ϰ� Ǯ���� �˾Ҵµ� �ȵǱ淡 �������� Ʋ�� �� ���� �� �� Ʋ������ ������ ����ϴٰ�
 * �˻��ؼ� �˾Ƴ� ����ε� �� ������ count�� ���������� ����ϸ� Ŭ�����ȿ��� �ʱ�ȭ�� ������Ѵܴ�..
 * (�������� �ʱ�ȭ ���� ��ó) https://fbtmdwhd33.tistory.com/252 
 * �迭�� String���� ����� �� new String(char[]);
 */ 

//������ �� ������ ���̿� �ִ� �ٸ� �������� ��
// ������ �����ϰ� ���� ����� �� ��� 
// 8! = 40320 �̶� ���⿡ 100���ϸ� �ִ� �� 400*8���� �������� ����Ȯ���� �����ϴ�.
// ��ͷ� ��� ����� ���� �� �غ���, ���̰� 8�� �� �����Լ��� Ȯ���ϰ� Ż�� 

class Solution {
    static String[] cond;
    static int len;
    static int answer = 0;
    static final int FRIENDNUM = 8;
    static char[] place = new char[8];
    static boolean[] check = new boolean[FRIENDNUM];
    static final char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    public int solution(int n, String[] data) {
        answer = 0;
        len = n;
        cond = data;
        placeAll(0);
    
        return answer;
    }
    
    static void placeAll(int deep) {
        if(deep == FRIENDNUM) {
            if(checkCondition(new String(place))) 
                answer++;
            return;
        }
        for(int i = 0; i < FRIENDNUM; i++) {
            if(!check[i]) {
                place[deep] = friends[i];
                check[i] = true;
                placeAll(deep+1);
                check[i] = false;
            }
        }
    }
    
    static boolean checkCondition(String placing) {
        for(int i = 0; i < cond.length; i++) {
            //�Ľ�
            char f1 = cond[i].charAt(0);
            char f2 = cond[i].charAt(2);
            int fIdx1 = placing.indexOf(f1);
            int fIdx2 = placing.indexOf(f2);
            char comp = cond[i].charAt(3);
            int num = (int)(cond[i].charAt(4) - '0');
            
            switch(comp) {
                case '=':
                    if(abs(fIdx1, fIdx2) != num+1)
                        return false;
                    break;
                case '>':
                    if(abs(fIdx1, fIdx2) < num+2)
                        return false;
                    break;
                case '<':
                    if(abs(fIdx1, fIdx2) > num)
                        return false;
            }
        }
        return true;
    }
    
    static int abs(int a, int b) {
        if(a > b)
            return a - b;
        else
            return b - a;
    }
    
}