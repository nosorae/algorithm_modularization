package PGM_Level2;

/*
 * 2021.07.01
 * PGM ĳ�� https://programmers.co.kr/learn/courses/30/lessons/17680
 * LRU�ϱ� ĳ�ð� ��á�� �� ���� ������ ���� �������ϹǷ� ť�� ����� �� ����.
 * ������ ť�� contains�Լ��� O(N)�̶� �� N^2�� �Ǿ� �ð��ʰ��� �� ���� �ִ�.
 * �׷��� ���� ���δ� HashSet���� �����Ѵ�.
 * LinkedList<Integer>���� remove�� �� ��ü���� �ε������� ��� �˾�?
 * Set<String>�� �ڵ����� ��ҹ��� �������ֳ�??
 * ĳ�û����� 0�� �� ���ó���� �̸� �����߾���Ѵ�. ������ �������� �ð������һ�!
 * 24��
 */
import java.util.*;
class PGM_LRUCache {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0)
            return cities.length * 5;
        
        int answer = 0;
        LinkedList<String> cache = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
       
        
        for(String city : cities) {
            city = city.toLowerCase();
            if(set.contains(city)) {
                answer++;
                cache.remove(city);
                cache.addLast(city); //�������� �� �ڷ� �����ش�.
            }
            else {
                answer += 5;
                if(cache.size() == cacheSize) { 
                    // ĳ�ð� ������ ù��° �� ���ְ�
                    set.remove(cache.removeFirst());
                }
                //���ο� ���� set�� queue�� �߰����ش�.
                set.add(city);
                cache.addLast(city);
            }
            //System.out.print(answer+" ");
        }
        return answer;
    }
}