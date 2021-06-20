package PGM_Level1;


import java.util.*;
/*
 * 2021.06.20 
 * PGM ü���� https://programmers.co.kr/learn/courses/30/lessons/42862
 * �ϴ� ���ʺ��� �������� �����شٰ� �����ϸ� �ּ��� �� ���̴�. �ٵ� �̰� ������� �־��� ��츸 �ش��ϴ� �� �ƴѰ�??
 * ó������ �迭�� 0 1 2�� �̿��ؼ� ���ʸ��� ��ȸ�ϴ� �ͱ��� �ߴµ� �� Ʋ�ȴ��� �ڵ尡 ���󰡼� �𸣰ڴ�.
 * ���� �ٸ� ��� �ڵ庸�� �ߺ��� ���ٴ� ���� ������ Set���� �����ϴµ� ���� �����տ��� ��¦ ������ �־���.
 * �� ������ ���� �������� ����� �ϴ� ��Ȳ���� a-b�ѻ��¿��� b-a�� �ϸ� a�� ���ϴ� ����� ��������
 * b-a���� a�� �̹� ���� b�� ��ġ�� ���Ұ� �������� ������ b������ ������ ���Ҹ� ������ �� ���� ������ �߻��Ѵ�.
 * 
 */







class PGM_GymSuit_Hard {
	public int solution(int n, int[] lost, int[] reserve) {
		
		int answer = 0;
		
		HashSet<Integer> lostSet = new HashSet<Integer>();
		HashSet<Integer> reserveSet = new HashSet<Integer>();
		
		for(int l : lost) {
			lostSet.add(l);
		}
		for(int r : reserve) {
			reserveSet.add(r);
           
		}
		
		lostSet.removeAll(reserveSet);
        
        for(int l : lost) {
            reserveSet.remove(l);
        }
        
		
		
		Iterator lostIt = lostSet.iterator();
		
		for(int cur : reserveSet) {
            System.out.println(cur);
			if(lostSet.contains(cur-1)) {
				lostSet.remove(cur-1);
			}
			else if(lostSet.contains(cur+1)) {
				lostSet.remove(cur+1);
			}
		}
		
		answer = n-lostSet.size();
		return answer;
	}

}