package bruteforce;
/*
 * BOJ 18290 NM�� K (1) 
 * 2���� �迭 �� �����߿��� K�� ������ ��� �����߿��� ���õ� ���ҵ��� ���� ���� Ŭ �� ���� ���
 * �ٵ� ���õ� K���� �����ϸ� �ȵȴٴ� ������ �ִ�.
 * �� ��͸��� NM���� �� ����Ϸ��� NM^K�� �ִ� 100^4�� �ð��ʰ��Ѵ�. 
 * �׷��� ���� ��Ϳ��� ������ ���ҵ��� �����ϰ� ����ؾ��Ѵ�. �� �ߺ������� ���δ�!!
 * max�� static���� ���ϰ� Ǫ�� ����� ������? ��Ϳ��� return�� �̿��ؼ� �Ź� �ִ밪�� Ȯ�����ִ� ��ĸ��̴�.
 * ���������� �ȹٷ� �о��!!! ���Ұ��� ������ -10000���� 10000������. �ٵ� ���� max�� 0���� �ʱ�ȭ ������ 
 * �ִ밪�� ������ ���� ���� 0���ιۿ� �ȳ��Դ�. 
 * max min�� ���� ���� �ʱ�ȭ���� �� �Ű澲��!!
 */
import java.util.*;
import java.io.*;
public class BOJ_18290 {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int n;
	static int m;
	static int k;
	static int[][] arr;
	static boolean[][] check;
	static long max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		check = new boolean[n][m];
		max = -1000001;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pickAllCase(0, 0, 0, 0);
		System.out.println(max);
	}
	
	static void pickAllCase(int startX, int startY, int depth, long sum) {
		if(depth == k) {
			if(max < sum)
				max = sum;
			return;
		}
		for(int x = startX; x < n; x++) {
			for(int y = (startX == x ? startY : 0); y < m; y++) {
				// �湮�� �̷��� ������Ѵ�.
				if(!check[x][y]) {
					//������ �׹��⿡ �湮�� �̷��� ����� �Ѵ�.
					boolean flag = true;
					for(int i = 0; i < 4; i++) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if(isIn(nx, ny) && check[nx][ny])
							flag = false;
					}
					if(flag) {
						check[x][y] = true;
						pickAllCase(x, y, depth+1, sum+arr[x][y]);
						check[x][y] = false;
					}
				}
			}
		}
		
	}
	static boolean isIn(int x, int y) {
		if(x >= 0 && x < n && y >= 0 && y < m) 
			return true;
		else
			return false;
	}
	
}



