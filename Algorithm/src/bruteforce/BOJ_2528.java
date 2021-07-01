package bruteforce;
/*
 * BOJ 2529 �ε�ȣ
 * 0-9���� �ߺ�x ����x�� k+1�� �̾Ƽ� �Է����� �־��� k���� �ε�ȣ ���� �����ϴ��� ã���� �ȴ�. 
 * �Է��� ��� ������ �𸣴� �� �غ����ϱ� �ϴµ�, �տ��� �̹� ������ ���ϴٸ� �� �غ� �ʿ� ���⶧���� ��Ʈ��ŷ�� �ϵ���
 * �ƴϸ� ���ʿ� �� �ε�ȣ�� �°� ���� ��� ���ڸ� �־��ִ��� �ϸ� �ȴ�. 
 * ������ ���ϴ� ���� �ȹٷ� �ľ��ض� ���������� �� ����ϴ� �� �ƴ϶� min max�� ���ϴٱ�
 * �׸��� 0���� �����ϴ� ���ڸ� parse
 */
import java.util.*;
import java.io.*;

public class BOJ_2528 {
	static boolean[] check = new boolean[10];
	static long max = 0L;
	static long min = 9876543211L;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		char[] sign = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			sign[i] = st.nextToken().charAt(0); 
		}
		for(int i = 0; i <= 9; i++) {
			check[i] = true;
			placeAll(sign, k, i+"");
			check[i] = false;
		}
		System.out.println(max);
		if(numLen(min) <= k)
			System.out.println("0"+min);
		else			
			System.out.println(min);
	}
	static int numLen(long n) {
		return (n+"").length();
	}
	static void placeAll(char[] sign, int k, String ans) {
		
		int depth = ans.length()-1;
		if(depth+1 == k+1) {
			// 0���� �����ϴ� ���� ����ó��?
			long cur = Long.parseLong(ans);
			if(min > cur)
				min = cur;
			if(max < cur)
				max = cur;
			return;
		}
		

		int num = ans.charAt(depth) - '0';
		if(sign[depth] == '>') {
			for(int i = 0; i < num; i++) {
				if(!check[i]) {
					check[i] = true;
					placeAll(sign, k, ans+i);
					check[i] = false;
				}
			}
		}
		else {
			for(int i = num+1; i <= 9; i++) {
				if(!check[i]) {
					check[i] = true;
					placeAll(sign, k, ans+i);
					check[i] = false;
				}
			}
		}


	}


}



