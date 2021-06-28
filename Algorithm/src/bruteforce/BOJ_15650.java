package bruteforce;


/*
 * BOJ 15650 N�� M (2)
 * N�� �� �߿��� �ߺ�x ���� �� ������ ������ �������� �ϰ� ��� �̾� ���
 * check �迭�� �ʿ���� ����!? ���������̴� +1������ ä��� �ǰ� �ڿ������� �ߺ��� �Ͼ�� �ʴ´�.
 */
import java.util.*;
public class BOJ_15650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] ans = new int[n+1];
		placeAll(ans, 0, 1, n, m);
        	
	}
	static void placeAll(int[] ans, int depth, int start,  int n, int m) {
		if(depth == m) {
			for(int i = 0; i < depth; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
			return;
		}
		for(int i = start; i <= n; i++) {
			ans[depth] = i;
			placeAll(ans, depth+1, i+1, n, m);
			
		}
	}
}



