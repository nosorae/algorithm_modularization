package bruteforce;



/*
 * BOJ 6603 �ζ�
 * N�� M 6? ������ ���� ������� Ǯ�� �ȴ�.
 * �ٵ� �̰� �����ε� Ǯ �� �ִٰ� �ϴµ�, N������ M�� �̴� ����� ���� �̰� �Ȼ̰� ���� ��
 * N���߿��� M���� �̰�� �����ϸ� �Ǵ� �����̴�. �׷��� �տ� 0�� k-6��, �׸��� 1�� 6�� ��� ���� ��ȸ�ϸ� ���� �� �� �ִ�.
 * �Ʒ� �� �� �� Ǯ���� �ڵ嵵 �ִ�. ���� ���� �̸��� �� �� ���� �� ����. �й��ؾ���
 */
import java.util.*;
import java.io.*;

public class BOJ_6603 {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int k = sc.nextInt();
			if(k == 0)
				break;
			int[] candidate = new int[k];
			for(int i = 0; i < k; i++) {
				candidate[i] = sc.nextInt();
			}
			selectSixNum(candidate, "", 0, 0);
			System.out.println();
		}
	}
	static void selectSixNum(int[] candidate, String result, int depth, int start) {
		if(depth == 6) {
			System.out.println(result);
			return;
		}
		for(int i = start; i < candidate.length; i++) {
			selectSixNum(candidate, result+candidate[i]+" ", depth+1, i+1);
		}
	}
}





//import java.util.*;
//import java.io.*;
//class Main {
//	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	public static void main(String args[]) throws Exception	{
//
//		String input = "";
//		while(!(input = br.readLine()).equals("0")) {
//			StringTokenizer st = new StringTokenizer(input);
//			int n = Integer.parseInt(st.nextToken());
//			int[] arr = new int[n];
//			int[] result = new int[6];
//			for(int i = 0; i < n; i++) {
//				arr[i] = Integer.parseInt(st.nextToken());
//			}
//	
//			placeAll(arr, result, 0, 0);
//			bw.write("\n");
//		}
//		bw.flush();
//		
//	}
//	
//	static void placeAll(int[] arr, int[] result, int depth, int start) throws IOException {
//		if(depth == 6) {
//			printLotto(result);
//			return;
//		}
//		for(int i = start; i < arr.length; i++) {
//			result[depth] = arr[i];
//			placeAll(arr, result, depth+1, i+1);
//			
//		}
//	}
//	
//	static void printLotto(int[] result) throws IOException {
//		for(int i = 0; i < result.length; i++) {
//			bw.write(result[i]+" ");
//		}
//		bw.write("\n");
//		
//	}
//}


