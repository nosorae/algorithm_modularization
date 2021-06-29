package bruteforce;
/*
 * BOJ 14889 ��ŸƮ�� ��ũ
 * N������ �� �� © �ǵ�  �������� «, 
 * �� ������ �ɷ�ġ ���̰� �ּҰ��ǰ� ���� ���� ����
 * �ɷ�ġ�� i�� j�� ���̸� arr[i][j]+arr[j][i] �� �ȴ�.
 * �Է��� ��� ���� �𸣴ϱ� �� �غ����ϰ�,
 * 1��, 2�� �ΰ��� ��찡 �ֱ⶧���� 2^20���ٰ� �Ź� ���� for������ 10^2�̹Ƿ� �� �غ��� �ϴ�. 
 * �����̶�� ������ �����̶� ������ �Ѵ� ���� �ٷ� ��Ʈ��ŷ
 */
import java.util.*;
import java.io.*;

public class BOJ_14889 {
	static int min = 40001;
	static int[][] ability;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ability = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> team1 = new ArrayList<Integer>();
		ArrayList<Integer> team2 = new ArrayList<Integer>();
		makeAllTeam(team1, team2, 0); 
		
		System.out.println(min);

	}
	static void makeAllTeam(ArrayList<Integer> t1, ArrayList<Integer> t2, int idx) {
		if(t1.size() > n/2 || t2.size() > n/2) return; //�� �κ��� ��Ʈ��ŷ
		
		if(idx == n) {
			
			int diff = getAbilityDiff(t1, t2);
			//System.out.println(t1.toString() +" vs "+ t2.toString() +" = "+ diff);
			if(min > diff)
				min = diff;
		}
		
		t1.add(idx);
		makeAllTeam(t1, t2, idx+1);
		t1.remove(t1.size() - 1);
		
		t2.add(idx);
		makeAllTeam(t1, t2, idx+1);
		t2.remove(t2.size() - 1);
	}
	static int abs(int a, int b) {
		int dist = a - b;
		if(dist < 0)
			dist = -dist;
		return dist;
	}
	static int getAbilityDiff(ArrayList<Integer> t1, ArrayList<Integer> t2) {
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 0; i < n/2; i++) {
			for(int j = i+1; j < n/2; j++) {
				sum1 += ability[t1.get(i)][t1.get(j)];
				sum1 += ability[t1.get(j)][t1.get(i)];
				sum2 += ability[t2.get(i)][t2.get(j)];
				sum2 += ability[t2.get(j)][t2.get(i)];
				
			}
		}
		return abs(sum1, sum2);
	}
}



