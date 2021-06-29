package bruteforce;

/*
 * BOJ 9095 1,2,3 ���ϱ�
 * ���̳������α׷������� Ǯ�������
 * �̹���, ������ 10�����ۿ� �ȵǹǷ� 3^10���� �غ��� �ϴ�. �׷��Ƿ� ���Ʈ�����ε� �����غ���.
 */
import java.util.*;
import java.io.*;
public class BOJ_9095 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int loop = 0; loop < t; loop++) {
			int n = Integer.parseInt(br.readLine());
			int ans = placeAll(n, 0);
			System.out.println(ans);
		}
	}
	static int placeAll(int n, int sum) {
		if(sum == n) 
			return 1;
		if(sum > n)
			return 0;
		int localAns = 0;
		for(int i = 1; i <= 3; i++) {
			localAns+= placeAll(n, sum+i);
		}
		return localAns;
	}
}



