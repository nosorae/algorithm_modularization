package bruteforce;


/*
 * BOJ 15655 N�� M (6)
 * �Է����� �־��� N�� �� �߿��� M���� ��������o
 * ����鳢���� �ߺ��� �ȵ�
 * ��� ������ ���������� �����ϰ� ����ؾ��ϹǷ� ó���� �������ش�.
 */
import java.util.*;
import java.io.*;
public class BOJ_15655 {
	static BufferedWriter bw;
	static int[] input;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		input = new int[n+1];
		check = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		int[] ans = new int[n+1];
		placeAll(ans, 0, 1, n, m);
		bw.flush();
        	
	}
	static void placeAll(int[] ans, int depth, int start, int n, int m) throws IOException {
		if(depth == m) {
			for(int i = 0; i < depth; i++)
				bw.write(input[ans[i]] + " ");
			
			bw.write("\n");
			return;
		}
		for(int i = start; i <= n; i++) {
			//if(check[i]) continue;
			//check[i]= true;
			ans[depth] = i;
			placeAll(ans, depth+1, i+1, n, m);
			//check[i] = false;
		}
	}
}



