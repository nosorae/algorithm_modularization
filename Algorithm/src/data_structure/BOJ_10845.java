package data_structure;


import java.io.*;
import java.util.*;
/*
 * ���� 10845�� ť
 * ���� ���� 
 * 1. "push"�� "push 3" �ٸ��ٴ� ���� ������
 * 2. "push"���� ������ �ڸ����� ���ڸ���� ���� ���� -> �������� ����� �ľ�
 * 3. LinkedList�� get�� remove�� �򰥷ȴ�.
 * 4. ���� ������� �䱸�Ǹ� BufferedWriter BufferedReader �� ������
 * 3. ���� �Ҹ��� �ڵ忡 �Ǽ��� ������ �� Ȯ������
 */

class BOJ_10845 {
	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> q = new LinkedList<Integer>();

		int n = Integer.parseInt(br.readLine());
		

		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			switch(input) {
			case "pop":
				if(!q.isEmpty())
					bw.write(q.remove(0)+"\n");
				else 
					bw.write(-1+"\n");
				break;
				
			case "front":
				if(!q.isEmpty())
					bw.write(q.get(0)+"\n");
				else 
					bw.write(-1+"\n");
				break;

			case "back":
				if(!q.isEmpty())
					bw.write(q.get(q.size()-1)+"\n");
				else 
					bw.write(-1+"\n");
				break;
				
			case "size":
				bw.write(q.size()+"\n");
				break;
				
			case "empty":
				if(q.isEmpty())
					bw.write(1+"\n");
				else 
					bw.write(0+"\n");
				break;
				
			default:
				StringTokenizer st = new StringTokenizer(input);
				st.nextToken();
				int data = Integer.parseInt(st.nextToken());
				q.addFirst(data);
				

			}
		}
		bw.flush();
		br.close();
		bw.close();

	}
}