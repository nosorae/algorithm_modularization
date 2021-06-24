package data_structure;

import java.util.*;

public class CollectionManual {

	public static void main(String[] args) {
		//����Ʈ�� �迭 
		ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[3];
		
		g[0] = new ArrayList<Integer>(3);
		//ť ����� ���� ��ȸ ����
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.peek();
		q.poll();
		//-------------------------------------------------------------------
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
		
		HashMap<Integer, Integer> maps = new HashMap<>();
		maps.put(1, 2);
		maps.put(2, 3);
		maps.put(3, 4);
		Set<Map.Entry<Integer, Integer>> entries = maps.entrySet();
		
		for(Map.Entry<Integer, Integer> entry : entries)
			System.out.println(entry.getValue());
		
		
		
		//------------------------------------------------------------------
		LinkedList<Integer> list = new LinkedList<Integer>();
    	list.add(1);
    	list.add(2);
    	
    	Integer[] arr3 = new Integer[list.size()];
    	arr3[0] = -1;
    	arr3[1] = -2;
    	Integer[] arr2 = list.toArray(arr3);
    	for(int a : arr2) {
    		System.out.println(a);
    	}
    	for(int a : arr3) {
    		System.out.println(a);
    	}
    	System.out.println(arr3 == arr2);
    	
    	
    	String[] array = new String[3];

    	array[0] = "Test1";
    	array[1] = "Test2";
    	array[2] = "Test3";

    	ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
		
		arrayList.add("Test4");
		for(String str : arrayList) {
			System.out.println(str);
		}
		//--------------------------------------------------------------
	
		
	}

}
