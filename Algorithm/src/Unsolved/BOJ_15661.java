package Unsolved;

/*
 * BOJ 15661 ��ũ�� ��ŸƮ
 * N������ �� �� © �ǵ� ���� �Ѹ��̻� ������ ����, ������ ���ϴ� ��쵵 �ִ�.
 * �� ������ �ɷ�ġ ���̰� �ּҰ��ǰ� ���� ���� ����
 * �ɷ�ġ�� i�� j�� ���̸� arr[i][j]+arr[j][i] �� �ȴ�.
 * �Է��� ��� ���� �𸣴ϱ� �� �غ����ϰ�,
 * 1��, 2�� �ΰ��� ��찡 �ֱ⶧���� 3^20�� 34��..���ٰ� �Ź� ���� for������ �ִ� 20^2�̹Ƿ� �� �ϸ� �ð��ʰ��� ���� ���δ�.
 * �׷��Ƿ� ��������� ���ؾ��Ѵ�.
 * �ϴ� 3^20��  2^20���� �ٲ� �� �ִ�. 
 * �ֳ��ϸ� �������� ���ϰų� �������ϰų��� �����ϸ� ������ ������ ���ϴ� ����� �����Ǳ� �����̴�.
 * �� ������ Ʋ�� �� ����. 
 * �׷��� 100��*400�� 4������ ������ ũ��.
 * �ϴ� ��ŸƮ�� ��ũ�� �� ���ϳ��� n/2�� �Ѿ���ϱ⶧���� 
 * �𸣰ڴ� ������ ��������
 * 
 */
import java.util.*;
import java.io.*;

public class BOJ_15661 {
	static int min = 40001;
	static int[][] ability;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ability = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		HashSet<Integer> team1 = new HashSet<Integer>();
		makeAllTeam(team1, n, 0); 
		
		System.out.println(min);

	}
	static void makeAllTeam(HashSet<Integer> t1, int n, int idx) {
		
		
		if(t1.size() == n/2) {
			//System.out.println(t1.toString());
			int sum1 = 0;
			int sum2 = 0;
			for(int i = 0; i < n; i++) {
				for(int j = i+1; j < n; j++) {
					if(t1.contains(i) && t1.contains(j)) {
						sum1 += ability[i][j];
						sum1 += ability[j][i];
					}
					else if(!t1.contains(i) && !t1.contains(j)) {
						sum2 += ability[i][j];
						sum2 += ability[j][i];
					}
				}
			}
			if(min > abs(sum1, sum2))
				min = abs(sum1, sum2);
			return;
		}
		if(idx >= n) return;
		if(t1.size() > n/2) return;
		if(n/2 - t1.size() > n-(idx+1)) return;		
		
		t1.add(idx); // 1���� �־��
		makeAllTeam(t1, n, idx+1);
		
		t1.remove(idx); // 2������ �־
		makeAllTeam(t1, n, idx+1);
	}
	static int abs(int a, int b) {
		int dist = a - b;
		if(dist < 0)
			dist = -dist;
		return dist;
	}
}



