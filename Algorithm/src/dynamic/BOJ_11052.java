package dynamic;

/*
 * 2021.07.08
 * BOJ 11052 ī�� �����ϱ�
 * p1 ~ pN�� ���� �־��� �� N�� ä��� ���� �ִ븦 ���ϴ� ����
 * N���� 1~1000
 * dp[n]�� ���ϱ� ���ؼ�dp[0] + p(n), dp[1]+p(n-1), dp[2]+p(n-2), ... dp[n-1]+p(1)   �߿��� �ִ븦 �����Ѵ�.
 * �̰͵� �� ���� Ǯ�̰� �� �����ϴ�. ������ max������ ���� ��� dp[n]�� �ִ� ���ϴµ� ��� �����̴�.
 */
import java.util.*;
import java.io.*;
public class BOJ_11052 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int[] p = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 0;
		dp[1] = p[1];
		for(int i = 2; i <= n; i++) {
			int max = 0;
			//dp[0] + p(n), dp[1]+p(n-1), dp[2]+p(n-2), ... dp[n-1]+p(1) ���� �ִ�
			for(int j = 0; j < i; j++) {
				if(max < dp[j] + p[i-j])
					max = dp[j] + p[i-j];
			}
			dp[i] = max;
		}
		System.out.println(dp[n]);
	}
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.StringTokenizer;
//
//public class Main {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int num = Integer.parseInt(br.readLine());
//		int[] p = new int[num+1];
//		int[] answer = new int[num+1];
//		
//		String str = br.readLine();
//		StringTokenizer st = new StringTokenizer(str);
//		for(int i = 1; i <= num; i++) {
//			p[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		answer[1] = p[1];
//		for(int i = 2; i <= num; i++) {
//			for(int j = 1; j <= i; j++) {
//				if(answer[i] < answer[i - j] + p[j])
//					answer[i] = answer[i-j] + p[j];
//			}
//			
//		}
//		
//		System.out.println(answer[num]);
//		
//		
//
//	}
//}



		
