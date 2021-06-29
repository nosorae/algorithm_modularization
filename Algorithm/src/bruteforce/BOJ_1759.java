package bruteforce;

/*
 * BOJ 1759 ��ȣ����� 
 * C���� �����߿��� �ߺ�x ����x ������������ L�� �̴� ���Ʈ���� ���� 
 * �� ���ڸ� �̰� �Ȼ̰� ������ ������ �ٶ� 
 * �߰� ������ �ִ�. �ּ� ���� �� �� �̻� ���� �ΰ� �̻��� ���̴�. �������� a e i o u��� �������� ���.. ����� �о��
 * �ִ� 15������ �̰� �Ȼ̰� �����ϰ� �Ź� L�� �˻��ؾ��ϴ�  2^15*15�� �Ҹ��ϴ�.
 */
import java.util.*;
import java.io.*;
public class BOJ_1759 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int chs= Integer.parseInt(st.nextToken());
		char[] source = new char[chs];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < chs; i++) {
			source[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(source);
		pickAllCombination(source, len, 0, "");
	}
	static void pickAllCombination(char[] src, int len, int idx, String str) {
		if(str.length() == len) {
			if(check(str))
				System.out.println(str);
			return;
		}
		if(idx >= src.length)
			return;
		
		pickAllCombination(src, len, idx+1, str+src[idx]);
		pickAllCombination(src, len, idx+1, str);
	}
	// �����ϳ� ���� �ΰ��̻� �ִ��� üũ
	static boolean check(String str) {
		int mo = 0;
		int za = 0;
		for(int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if(cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u')
				mo++;
			else
				za++;
		}
		return (mo >= 1 && za >= 2);
	}
}



