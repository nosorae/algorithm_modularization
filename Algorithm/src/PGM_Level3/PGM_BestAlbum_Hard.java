package PGM_Level3;

import java.util.*;
/*
 * 2021.06.21
 * PGM ����Ʈ�ٹ� https://programmers.co.kr/learn/courses/30/lessons/42579
 * ������ ���� ������ Ǯ���� ������ ������ �ٽ� Ǯ����߰ڴ�.
 * �� ����Ǯ�� ����� <String, Integer>�� �� �帣�� �÷������� ���� �����ϰ�, 
 * <String, LinkedList<Music>>�� �� �帣���� Music����Ʈ�� ���� ������ �����ؼ�
 * �÷������� ���� ���� �帣���� �ִ� �ΰ��� ���ְ� �� �帣�� �ʿ��� �����Ͽ���. 
 * ó���� �帣�� �뷡�� ������� ���� �ߺ����� �ʴ� �ٴ� ���� ĳġ ���ϰ� ��� �뷡�� ������� �ߺ��� �ȵǴ� �� �˾Ҵ�.
 * ������ ����� �ľ������� �ʰ� ������ Ǫ�ϱ� �ð����� �Ͽ���, 
 * ���߿� ����� �ľ��ϰ� �ڵ带 ��ġ���� �������� �� �ð������ϰ� �ڵ嵵 ����������. 
 * for���ȿ� �ӽú����� ����� ���� ������ ������ �� ����. 
 * �׸��� HashMap�� put�̰� HashSet add��.. HashSet�� Collection�������̽��� �����߰� HahsMap�� Map�������̽��� �����ߴ�.
 *
 */

class PGM_BestAlbum_Hard {
	public int[] solution(String[] genres, int[] plays) {


		HashMap<String, LinkedList<Music>> map  = new HashMap<String, LinkedList<Music>>(); 
		HashMap<String, Integer> genSum = new HashMap<String, Integer>();
		int len = genres.length;


		//map���� �帣���� �÷��̼� ����Ʈ�� ����� 
		for(int i = 0; i < len; i++) {
			if(map.containsKey(genres[i])) {
				LinkedList<Music> temp = map.get(genres[i]);
				temp.add(new Music(i, genres[i], plays[i]));

				genSum.put(genres[i], genSum.get(genres[i]) + plays[i]);
			}
			else {
				LinkedList<Music> temp = new LinkedList<Music>();
				temp.add(new Music(i, genres[i], plays[i]));
				map.put(genres[i], temp);

				genSum.put(genres[i], plays[i]);
			}

		}

		//�帣�� ���Ƚ�� �������� �������� ����
		Genres[] gen = new Genres[genSum.size()];
		int genIdx = 0;
		for(Map.Entry<String, Integer> entry : genSum.entrySet()) {
			gen[genIdx++] = new Genres(entry.getKey(), entry.getValue());
		}
		Arrays.sort(gen);


		for(LinkedList<Music> list : map.values()) {
			System.out.println(list.toString());
		} 


		LinkedList<Integer> ans = new LinkedList<Integer>();
		for(int i = 0; i < gen.length; i++) {
			if(!map.containsKey(gen[i].genres))
				continue;

			LinkedList<Music> temp = map.get(gen[i].genres);

			Collections.sort(temp); //�帣���� ���ǵ��� ���Ƚ�� �������� �������� ����

			//temp�� size�� ������ 1�̻��̴�. �׷��� �ϴ� �ϳ� ���� �� ���� ������� Ȯ���ϰ� �ϳ� �� ���� �帣 ����
			ans.add(temp.remove(0).id);
			if(!temp.isEmpty()) {
				ans.add(temp.remove(0).id);
			}   
			map.remove(gen[i].genres);
		}

		int[] answer = new int[ans.size()];
		int ansIdx = 0;
		for(int a : ans) {
			answer[ansIdx++] = a;
		}

		return answer;
	}
}
class Genres implements Comparable<Genres> {
	String genres;
	int playSum;
	public Genres(String genres, int playSum) {
		this.genres = genres;
		this.playSum = playSum;
	}
	public int compareTo(Genres o2) {
		if(this.playSum > o2.playSum)
			return -1;
		else 
			return 1;
	}
}

class Music implements Comparable<Music> {
	int id;
	String genres;
	int play;

	public Music(int i, String g, int p) {
		id = i;
		genres = g;
		play = p;
	}

	public int compareTo(Music o2) {
		if(this.play > o2.play) 
			return -1;
		else if (this.play == o2.play) {
			if(this.id > o2.id)
				return 1;
			else
				return -1;
		}
		else
			return 1;
	}

	public String toString() {
		return "(" + id +", " + genres + ", " + play +")";
	}
}