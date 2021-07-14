package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BFS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// ���� ������ȣ�� ���� prev�迭�� �־����� �� �������ؼ� ������ִ� �Լ�
	// prev�迭�� ��� ������ ��� ���� ������ȣ�� �����ϰ� �־�߸� �Ѵ�.
	// ������ ������ ���� ������ȣ�� -1�� �����صξ���Ѵ�.
	static void traceBack(int[] prev, int end) throws IOException {
		Stack<Integer> stack = new Stack<Integer>();
		int cur = end;
		while(cur != -1) {
			stack.add(cur);
			cur = prev[cur];
		}
		
		while(!stack.isEmpty()) {
			bw.write(stack.pop()+"");
		}
	}

}
