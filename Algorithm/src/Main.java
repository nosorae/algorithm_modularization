
/*
 * BOJ 15661 링크와 스타트
 * N명있을 때 팀 짤 건데 팀에 한명이상만 있으면 만족, 참석을 안하는 경우도 있다.
 * 팀 사이의 능력치 차이가 최소가되게 답을 내는 문제
 * 능력치는 i와 j가 팀이면 arr[i][j]+arr[j][i] 가 된다.
 * 입력이 어떻게 올지 모르니까 다 해봐야하고,
 * 1팀, 2팀 두가지 경우가 있기때문에 3^20약 34억..에다가 매번 이중 for문으로 최대 20^2이므로 다 하면 시간초과가 벌써 보인다.
 * 그러므로 성능향상을 꾀해야한다.
 * 일단 3^20을  2^20으로 바꿀 수 있다. 
 * 왜냐하면 팀에 한명 이상 있기만 하면 매번 검사해서 나머지는 참석안한 것으로 처리하면 된다.
 * 그래도 100만*400은 4억으로 여전히 크다.
 * 
 */
import java.util.*;
import java.io.*;

public class Main {
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
		if(idx > n) return;
		
		if(t1.size() > 0 && t2.size() > 0) {
			int diff = getAbilityDiff(t1, t2);
			if(min > diff)
				min = diff;
			System.out.println(t1.toString()+" vs "+ t2.toString()+" = "+ diff);
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
		for(int i = 0; i < t1.size(); i++) {
			for(int j = i+1; j < t1.size(); j++) {
				sum1 += ability[t1.get(i)][t1.get(j)];
				sum1 += ability[t1.get(j)][t1.get(i)];
			}
		}
		for(int i = 0; i < t2.size(); i++) {
			for(int j = i+1; j < t2.size(); j++) {
				sum2 += ability[t2.get(i)][t2.get(j)];
				sum2 += ability[t2.get(j)][t2.get(i)];
			}
		}
		return abs(sum1, sum2);
	}
}



