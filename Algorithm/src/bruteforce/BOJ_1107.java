package bruteforce;

import java.util.*;
/*
 * BOJ 1107 ������ 
 * ��ư : 0~9, +/-, ���峭 ��ư �־��� 
 * ä�� ���� : 0~���Ѵ�, ��� ������ 100�� �̻� ���Ÿ� 0���� 50�� ���� ���⿡ ��ǻ� 0~100���̴�. 
 * � ��ư�� ���峭�� �𸣴� �� �������� �������� �ܼ��̵��� ���ؼ� ���� ����.
 * 100�� * 10 * 6 �뷫 6õ��
 * 
 * 
 */
import java.util.*;
public class BOJ_1107 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
	
		int ans = abs(n, 100);
		HashSet<Integer> broken = new HashSet<Integer>();
		for(int i = 0; i < m; i++) {
			broken.add(sc.nextInt());
		}
		
		for(int i = 0; i < 1000000; i++) {
			//���� �� �ְ�, ���̰� ª�ٸ�
			if(pressNumber(broken, i) && ans > (abs(n, i) + numLen(i))) {
				ans = abs(n, i) + numLen(i);
			}
		}
		
		System.out.println(ans);
	}
	static boolean  pressNumber(HashSet<Integer> broken, int n) {
		do {
			if(broken.contains(n%10))
				return false;
			n /= 10;
		} while(n != 0);
		
		return true;
	}
	static int abs(int a, int b) {
		if(a > b)
			return a - b;
		else 
			return b - a;
	}
	static int numLen(int n) {
		String str = n+"";
		return str.length();
	}
}


//import java.util.Scanner;
//public class Main {
//	public static void main(String args[]) {
//		Scanner s = new Scanner(System.in);
//		int n  = s.nextInt();
//		int x = s.nextInt();
//		int[] arr = new int[x];
//		for(int i = 0; i < x; i++) {
//			arr[i] = s.nextInt();
//		}
//		boolean flag = false;
//		int min = Math.abs(n-100);
//		
//		for(int i = 0; i < 1000000; i++) {
//			int num = i;
//			int count = 0;
//			if(i == 0) 
//				count = 1;
//			while(num != 0) {
//				count++;
//				if(Include(arr, num%10)) {
//					flag = true;
//					break;
//				}
//				num/=10;
//			}
//			if(flag) {
//				flag = false;
//				continue;
//			}
//			if(i == 0 && Include(arr, i))
//				continue;
//
//			if(min > Math.abs(n-i)+count) {
//				min = Math.abs(n-i)+count;
//				//System.out.println(i+" "+count+" "+min);
//			}
//				
//		}
//		System.out.println(min);
//	}
//	
//	public static boolean Include(int[] arr, int x) {
//		for(int i = 0; i < arr.length; i++) {
//			if(arr[i] == x)
//				return true;
//		}
//		return false;
//	}	
//}


