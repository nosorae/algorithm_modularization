package PGM_Level2;

/*
 * 2021.06.26
 * PGM ���ڿ� ����
 * �Է� String�� 1�̻��� ������ �߶� �����ϸ� �����Ѹ�ŭ ���ں��̰�
 * �ϳ��� ���̴µ�, �̶� ������ ���̵�(������ ���̰� ���� ª��) ���ڿ��� ���̰� ��
 * �Է¿� ���� ���� �� �� ����, ���̰� �ִ� 1000�̹Ƿ� 1000*500�̸� �� �غ����ϴ� ���Ʈ������ Ǯ����.
 * �Է±��̰� 1000�� �� 500������ �غ��� �Ǵ� ������ �����Ϸ��� �ּ� �ι��� �����ؾ��ؼ���.
 * �ݺ�ȸ���� �� �ڸ��� �̻��� ���� �� ���� ��������.. ���ڸ� ���� �͸� �����ϰ� Ǯ����..
 * �迭 �յ� ���ذ��� ���ǿ� ������ ī��Ʈ�ϰ� �� ���� �ٵ��� ���� �������ִ� ������ �׻� �������� �����϶�!!!!
 * �ߺ��Ǵ� if else���� ���� �� �ִ�!!
 */
class PGM_StringCompression_Hard {
	public int solution(String s) {
		int len = s.length();
		int localAns = len;
		int answer = len;
		for(int i = 1; i <= len/2; i++) {
			localAns = len;
			int cnt = 1;
			for(int j = 0; j < len; j+=i) {
				if(j+(2*i) <= len && s.substring(j, j+i).equals(s.substring(j+i, j+(2*i)))) {
					cnt++;
					//System.out.println(s.substring(j, j+i) +" "+ s.substring(j+i, j+(2*i)) +" "+ cnt);
				}
				else {
					if(cnt > 1)
						localAns = localAns - (i*(cnt-1)) + findNumLen(cnt);
					cnt = 1;
				}

			}
			if(answer > localAns) {
				answer = localAns;
				System.out.println(answer);
			}

		}
		return answer;
	}
	static int findNumLen(int n) {
		String str = n+"";
		return str.length();
	}
}