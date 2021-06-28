package bruteforce;

/*
 * BOJ 15649 N�� M (3)
 * N�� �� �߿��� M���� �ߺ�o ����o�ϰ� ��� �̾� ���
 * ����� ������ ������������̰�, �ߺ��� ������ ����ϸ� �ȵ�
 * ����� ���Ƽ� System.out.print�δ� �ð��ʰ� ���� BufferedWriter�Ǵ� StringBuilder�� ���
 */
import java.util.*;
import java.io.*;
public class BOJ_15651 {
	static BufferedWriter bw;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] ans = new int[n+1];
		placeAll(ans, 0, n, m);
		bw.flush();
        	
	}
	static void placeAll(int[] ans, int depth, int n, int m) throws IOException {
		if(depth == m) {
			for(int i = 0; i < depth; i++)
				bw.write(ans[i] + " ");
			
			bw.write("\n");
			return;
		}
		for(int i = 1; i <= n; i++) {
			ans[depth] = i;
			placeAll(ans, depth+1, n, m);
		}
	}
}



