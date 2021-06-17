package PGM_Level2;

/*
 * 21.06.17
 * ���α׷��ӽ� �Ǻ����� https://programmers.co.kr/learn/courses/30/lessons/12945
 * ���ó���� ������ ���� ���� 
 * (a+b)%c = (a%c + b%c) % c
 */
class PGM_Pibo {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%1234567;
        }
        
        int answer = dp[n];
        return answer;
    }
}