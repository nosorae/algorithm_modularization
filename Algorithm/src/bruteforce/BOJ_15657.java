package bruteforce;


/*
 * BOJ 15657 N과 M (8)
 * 입력으로 주어진 N개 수 중에서 M개를 중복o 결과 숫자가 비내림차순되게 모두 뽑아 출력
 * 결과들끼리의 중복은 안됨
 * 출력 순서는 사전순으로 증가하게 출력해야하므로 처음에 정렬해준다.
 */
import java.util.*;
import java.io.*;
public class BOJ_15657 {
	static BufferedWriter bw;
	static int[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		input = new int[n+1];
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
			ans[depth] = i;
			placeAll(ans, depth+1, i,  n, m);
		}
	}
}



