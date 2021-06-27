package bruteforce;

/*
 * BOJ 1476 ��¥���
 * ESM ������ �ش��ϴ� ���� ������ �����ؼ� ������ ��� �����ϴ� �ּҼ��ڸ� ã�� ����
 * ������ �����ڴ� %N�� �� 0~N-1�� ���� �ݺ��Ѵ�. 
 * ���������� 1~N�� �ݺ��ϱ� ������ ��ü -1�� �����ϰ� �����Ѵ����� �� �� ���� +1�� �����.
 * �� ���� Ǯ�̴�� (i%15)+1 == n1 && (i%28)+1 == n2 && (i%19)+1 == n3
 * �̷��� ���� ���� �ִ�.
 */
import java.util.Scanner;

public class BOJ_1476 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt() - 1;
		int S = sc.nextInt() - 1;
		int M = sc.nextInt() - 1;
		for(int i = E; i < (15*28*19); i += 15) {
			if(i % 28 == S && i % 19 == M) {
				System.out.println(i+1);
				break;
			}
		}
    }
}

//import java.util.Scanner;
//public class Main {
//	public static void main(String args[]) {
//		Scanner s = new Scanner(System.in);
//		int n1 = s.nextInt();
//		int n2 = s.nextInt();
//		int n3 = s.nextInt();
//		for(int i = 0; i <=15*28*19; i++) {
//			if((i%15)+1 == n1 && (i%28)+1 == n2 && (i%19)+1 == n3) {
//				System.out.println(i+1);
//				break;
//			}
//		}
//	}
//}


