package bruteforce;

/*
 * BOJ 1748 �� �̾��
 * 1���� �־��� N���� �����ؼ� ���ڸ� ���� �� ���� ���̸� ����ϴ� ����
 * for������ =�� ���Ծ �����ߴ�. =�� ���ϱ� ������ ���� Ư���� ���� �ϳ� �־�� �ȴ�.
 * �� ����Ǯ�̴� len�� ���� ������ �����ߴµ� ������ �Լ�ȣ���ؼ� �� �� ��ȿ�� ���̴�..
 */
import java.util.*;
public class BOJ_1478 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		long answer = 0;
		
		long cur = 10;
		for(; cur <= N; cur *= 10) {
			answer += ((cur-1) - cur/10 + 1) * numLen(cur/10); 
		}
		cur /= 10;
		answer += (N - cur + 1) * numLen(cur);
		System.out.println(answer);
	}
	static int numLen(long n) {
		String str = n+"";
		return str.length();
	}
}

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//public class Main {
//	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		int ans = 0;
//		int len = 1;
//		for(int i = 1; i <= n; i*=10, len++) {
//			if(i*10 <= n)
//				ans += (i*10 - i)*len;
//			else
//				ans += (n-i+1)*len;
//		}
//		
//		System.out.println(ans);
//	}
//}






