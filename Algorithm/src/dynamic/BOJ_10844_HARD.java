package dynamic;
/*
 * 2021.07.08
 * BOJ 10844 ���� ��� ��
 * 0���� �������� �ʴ�, 0~9���� �������� ��, ���̰� N�� ��� ���� � �ִ��� ���ϴ� ����
 * �ݺ������� 1�� 9�� ���ܰ� �����. �̸� ���ڰ� ó���ϱ� ���ؼ� �׳� �ݺ��� �ȿ� if���� ���� ���� �ִ�.
 * ������ ���� Ŀ�� �� ���Ƽ� 10�� ��ⷯ���� �־��ٸ� �翬�� long ����� ����غ����ϴ� �� �ƴѰ�?? ����������
 */

//� ���� a�� b�� �������� �� q ������ r�� �����մϴ�. �� �����ϰ� a=bq+r�� ǥ���˴ϴ�.
//���� �� ������ ���ϰ� b��� Ư�� ������ ���� �������� ���ϴ� �� �������� b�� ������ ���ϴ°��� �������� ���̸� �˴ϴ�.
//a=bq+r 
//c=Bq+R�̶�� �Ҷ�
//a+c= (b+B)q+r+R�Դϴ�.
//(a+c) %q= (r+ R)%q
//(a%q+c%q)%q= (r+R)%q�̹Ƿ� �����մϴ�. 

import java.util.*;
import java.io.*;
public class BOJ_10844_HARD {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+2][10];
		for(int i = 1; i <= 9; i++) {
			dp[1][i] = 1; //dp[1][0]�� 0�ӿ� �������� (0���� �����ϴ� ���� ���ٴ� ���� ������ ����)
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j-1 >= 0) 
					dp[i][j] += dp[i-1][j-1];
				if(j+1 <= 9)
					dp[i][j] += dp[i-1][j+1];
				dp[i][j] %= 1000000000;
			}
		}
		long answer = 0;
		for(int i = 0; i <= 9; i++) {
			answer += dp[n][i];
		}
		answer %= 1000000000;
		System.out.print(answer);
	}
}

