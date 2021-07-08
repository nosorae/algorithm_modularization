package dynamic;

/* 2021.07.08
 * BOJ 15990 1,2,3 ���ϱ� https://www.acmicpc.net/problem/15990
 * N�� �־����� 1,2,3�� ���ӵ��� �ʰ�  ����ؼ� N�� ����� ����� ���� ���ϴ� ����
 * n�� ����� ����� ���� dp[n-1] + dp[n-2] + dp[n-3]����  dp[n-1-1]
 * answer = dp[n] - dp[n-2] - dp[n-4] - dp[n-6] �� �ȵǴ� ������ ���� �����鵵 ���ӵ� ���ڸ� ������ �� �ֱ� ����
 * �������� ���� ���ڰ� �����ϸ� �ȵȴٴ� ������ �ְ� �̸� �˷��� ���ڰ� �������� �������� �˾ƾ��Ѵ�.
 * ���� �� ��ȭ�����Ǹ� dp[i][j]���ؼ� �־��� ������ i�� j�� ������ ����� ������� �����ϸ�ȴ�.
 * �׷��� ��ȭ���� dp[i][1] = dp[i-1][2]+dp[i-1][3] ... dp[i][3] = dp[i-3][1]+dp[i-3][2] �̴�.
 * ������ ������ Ŀ���ٰ� ��Ʈ�� �ָ� long�� ���� ����غ���
 * �ƹ��� 10������ �����������ص� int������ 20�������ϱ� 10�￡ ����� �� ���� ���ϸ� �����÷� �߻��� �� �ִٱ� 
 * ù��° �ڵ嵵 ����Ǳ� ������ �Ʒ��ڵ尡 ���������� �� ��Ȯ�ϴ�.
 */
import java.util.*;
import java.io.*;
public class BOJ_15990_HARD {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] dp = new int[100001][4];
		dp[1][1] = 1; dp[2][2] = 1; dp[3][1] = 1; 
		dp[3][2] = 1; dp[3][3] = 1;
		
		for(int i = 4; i <= 100000; i++) {
			dp[i][1] = dp[i-1][2]%1000000009 + dp[i-1][3]%1000000009;
			dp[i][2] = dp[i-2][1]%1000000009 + dp[i-2][3]%1000000009;
			dp[i][3] = dp[i-3][1]%1000000009 + dp[i-3][2]%1000000009;
			
		}
		
		int loop = Integer.parseInt(br.readLine());
		for(int l = 0; l < loop; l++) {
			int n = Integer.parseInt(br.readLine());
			bw.write((dp[n][1]%1000000009+dp[n][2]%1000000009+dp[n][3]%1000000009)+"\n");
		}
		bw.flush();
	}
}


//import java.util.*;
//import java.io.*;
//public class Main {
//	public static void main(String[] args) throws IOException {	
//		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		long[][] dp = new long[100001][4];
//		dp[1][1] = 1; dp[2][2] = 1; dp[3][1] = 1; 
//		dp[3][2] = 1; dp[3][3] = 1;
//		
//		for(int i = 4; i <= 100000; i++) {
//			dp[i][1] = (dp[i-1][2]%1000000009 + dp[i-1][3]%1000000009)%1000000009;
//			dp[i][2] = (dp[i-2][1]%1000000009 + dp[i-2][3]%1000000009)%1000000009;
//			dp[i][3] = (dp[i-3][1]%1000000009 + dp[i-3][2]%1000000009)%1000000009;
//			
//		}
//		
//		int loop = Integer.parseInt(br.readLine());
//		for(int l = 0; l < loop; l++) {
//			int n = Integer.parseInt(br.readLine());
//			bw.write((dp[n][1]%1000000009+dp[n][2]%1000000009+dp[n][3]%1000000009)%1000000009+"\n");
//		}
//		bw.flush();
//	}
//}
		
