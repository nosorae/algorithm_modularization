package PGM_Level1;

/*
 * 2021.06.22
 * PGM �Ҽ� ����� https://programmers.co.kr/learn/courses/30/lessons/12977
 * �����佺�׳׽��� ü�� �Ҽ��迭�� ����� ���Ʈ����-������ ��� ��� �� �õ��غ��� ������� Ǯ��
 * nPr ���� �����ϴ� �� �������.. nCr��!
 * ��ͷ� ������ ���� �������̴�.
 * �����ľ� ����� ���ϰ� �ѹ� Ʋ�ȴ�. �Ҽ�ã�� �迭 ����� 1000���� ��Ҵ�.. 
 * �����ϳ��� �ִ밪�� 1000�ε� ���̴�.. �׷� �ִ� 3000�̴� ����� 3000���� ��ƾ���!
 * 40��
 */
class PGM_MakePrimeNumber {
    public int solution(int[] nums) {
        boolean[] isPrime = getEratos(3000);
        int result = 0;
        for(int i = 0; i < nums.length-2; i++) {
            for(int j = i+1; j < nums.length-1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(!isPrime[nums[i] + nums[j] + nums[k]])
                        result++;
                }
            }
        }
        return result;
    }
    
    static boolean[] getEratos(int n) {
        boolean[] era = new boolean[n+1];
        era[0] = era[1] = true;
        for(int i = 2; i*i <= n; i++) {
            for(int j = i*i; j <= n; j += i) {
                era[j] = true;
            }
        }
        return era;
    }
    
}