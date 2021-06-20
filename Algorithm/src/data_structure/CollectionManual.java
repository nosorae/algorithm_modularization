package data_structure;

import java.util.*;

public class CollectionManual {

	public static void main(String[] args) {
		//����Ʈ�� �迭 
		ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[3];
		
		//ť ����� ���� ��ȸ ����
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.peek();
		q.poll();
		
		//<key, value> ���
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, null);
		
		System.out.println(map.putIfAbsent(4, "z")); // �ش� Ű�� �ش��ϴ� ���� ������ �ش� �׳� �ش� �� �����ϰ�, �ƴ϶��  �ش� �� �־��ش�.
		System.out.println(map.get(4));
		
		System.out.println(map.containsKey(1)); // �ʿ� �ش� Ű�� ���� �ִ°�? ������ true ������ false
		System.out.println(map.containsKey(4));
		System.out.println(map.containsValue("c"));
		System.out.println(map.containsValue("d"));
		
		System.out.println(map.getOrDefault(1, "z"));
		System.out.println(map.getOrDefault(4, "z"));
		
		
		System.out.println("entrySet()");
		for(Map.Entry<Integer, String> e : map.entrySet()) {
			System.out.println(e.getKey()+ " " + e.getValue());
		}
		System.out.println();
		
		System.out.println("keySet()");
		for(Integer key : map.keySet()) {
			System.out.println(key);
		}
		System.out.println();
		
		System.out.println("values()");
		for(String val : map.values()) {
			System.out.println(val);
		}
		System.out.println();
		
		System.out.println("size() : " + map.size());
		
		System.out.println(map);
		System.out.println(map.toString());
		
		
			
		
	
		
	}

}
