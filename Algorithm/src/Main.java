
/*
 * BOJ 1248 �����
 * ��ǥ�� �����̰� �� ���ڰ� �������� ���ߴ� ���̴�. �迭 �Է¿� ���� ���� ���� ���� �𸣴� �� �غ��߰ڴ�.
 * �׸��� �ĺ��� -10~10���� 21���ε�  21^10�� �ʹ� ����. 
 * �׷��� �� �غ��� ��Ʈ��ŷ�� ����Ѵ�.
 * �ϴ� arr[i][i]�� ���� ��ȣ������ �� �� �ִ�. 10^10���� �پ���. 10,000,000,000..
 * arr[i][i]�� ���� ����� 1~10 ������ -10~-1 �׸��� 0�̸� 0���� �ְ� ���� ���ڸ� �õ��ϸ�ȴ�. 
 */
import java.util.*;
import java.io.*;

public class Main {
	static char[][] arr;
	public static void main(String[] args) throws Exception {
		
		for(int i = 0; i < 2*2*2*2*2*2; i++) {
			String s = Integer.toBinaryString(i);
			if(s.length() < 6) {
				while(s.length() != 6) {
					s = "0"+s;
				}
			}
			System.out.println(s);
		}
		
	}
}



