package PGM_Level1;

/*
 * 2021.06.23
 * PGM ����� ������ ���� https://programmers.co.kr/learn/courses/30/lessons/77884
 * ���� ����������� Ǯ�̹���� ������ �뷫 �ִ� 100���ε� �� ȿ������ ����� ������ �ϴ�
 * ����ó�� �ϳ� ���߾ Ʋ�ȴ�. �׻� ��迡�� ���ܸ� �����϶�!
 */
class PGM_MeasureCountPlus {
    public int solution(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++) {
            if(oddEven(i))
                sum += i;
            else 
                sum -= i;
        }
        return sum;
    }
    static boolean oddEven(int n) { // false�� Ȧ true�� ¦
        if(n == 1)
            return false;
        
        int cnt = 2; // 1�� �ڽ� �ΰ��� true
        for(int i = 2; i < n; i++) {
            //1�� �ڽ��� ������ ��� ���� ������� Ȯ��
            if(n % i == 0)
                cnt++;
        }
        if(cnt % 2 ==  0) return true;
        else return false;
    }
}