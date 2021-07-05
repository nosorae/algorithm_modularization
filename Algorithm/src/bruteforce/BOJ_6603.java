package bruteforce;



/*
 * BOJ 6603 �ζ�
 * N�� M 6? ������ ���� ������� Ǯ�� �ȴ�.
 * �ٵ� �̰� �����ε� Ǯ �� �ִٰ� �ϴµ�, N������ M�� �̴� ����� ���� �̰� �Ȼ̰� ���� ��
 * N���߿��� M���� �̰�� �����ϸ� �Ǵ� �����̴�. �׷��� �տ� 0�� k-6��, �׸��� 1�� 6�� ��� ���� ��ȸ�ϸ� ���� �� �� �ִ�.
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



