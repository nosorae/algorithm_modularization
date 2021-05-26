package simulation;


import java.util.*;

/*
 * ���� 14890�� ����
 * �������
 */

public class BOJ_14890_Unsolved {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		final int l = sc.nextInt();
		int[][] arr = new int[n][n];
		boolean[][] steep = new boolean[n][n];
		int ans = 0;

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		//����
		for(int i = 0; i < n; i++) {
			boolean[][] save = new boolean[n][n]; // �� �� ���� �ӽ÷� ���θ� üũ ���� �ȴٸ� steep�迭�� �̵�
			for(int j = 0; j < n; j++) {

				if(j == n-1) {// ������ �Դٸ� �װ��� �� ���� ����� ���� üũ ����
					for(int x = 0; x < n; x++) {
						if(save[i][x])
							steep[i][x] = true;
					}
					ans++;
//					System.out.println(i+1+"��");
					break;
				}


				int prev = arr[i][j];
				int next = arr[i][j+1];

				if(prev == next) {
					continue;
				}

				else if(prev > next && prev-next == 1) { // ���� ���� ���� ���̶�� L��ŭ ���ӵǾ��ִ��� üũ

					if(j > n-1-l)
						break;

					if(l== 1 && !save[i][j+1] && !steep[i][j+1]) {
						save[i][j+1] = true;
						continue;
					}
					else { // �̹� ���ΰ� �ִٸ� Ż�����Ѿ��Ѵ�.
						if(l==1)
							break;
					}



					boolean isSteep = true;
					for(int k = j+1; k <= j+l-1; k++) {
						if(arr[i][k] != arr[i][k+1] || steep[i][k] || steep[i][k+1]
								|| save[i][k] || save[i][k]) {
							isSteep = false;
							break;
						}
						save[i][k] = true;
					}
					save[i][j+l] = true;
					if(!isSteep) 
						break;


				}
				else if (prev < next && next-prev == 1) { // ���� ���� �� ���� ���̶�� ���� ���� L��ŭ ���ӵǾ��ִ��� üũ

					if(j < l-1) 
						break;

					if(l == 1 && !save[i][j] && !steep[i][j]) {
						save[i][j] = true;
						continue;
					} 
					else {
						if(l==1)
							break;
					}


					boolean isSteep = true;
					for(int k = j; k > j-l+1; k--) {
						if(arr[i][k] != arr[i][k-1] || steep[i][k] || steep[i][k-1]
								|| save[i][k] || save[i][k-1]) {
							isSteep = false;
							break;
						}
						save[i][k] = true;
					}
					save[i][j-l+1] = true;
					if(!isSteep)
						break;

				}
				else 
					break;


			}
		}





		steep = new boolean[n][n];
		//����
		for(int i = 0; i < n; i++) {
			boolean[][] save = new boolean[n][n];
			for(int j = 0; j < n; j++) {


				if(j == n-1) { // ������ �Դٸ� ����� ���� ����
					for(int x = 0; x < n; x++) {
						if(save[x][i])
							steep[x][i] = true;
					}
					ans++;
//					System.out.println(i+1+"��");
					break;
				}



				int prev = arr[j][i];
				int next = arr[j+1][i];
				if(prev == next) {
					continue;
				}
				else if(prev > next && prev-next == 1) { // ���� ���� ���� ���̶�� L��ŭ ���ӵǾ��ִ��� üũ

					if(j > n-1-l)
						break;

					if(l == 1 && !save[j+1][i] && !steep[j+1][i]) {
						save[j+1][i] = true;
						continue;
					} 
					else {
						if(l == 1)
							break;
					}

					boolean isSteep = true;
					for(int k = j+1; k <= j+l-1; k++) {
						if(arr[k][i] != arr[k+1][i] || steep[k][i] || steep[k+1][i]
								|| save[k][i] || save[k+1][i]) {
							isSteep = false;
							break;
						}
						save[k][i] = true;
					}
					save[j+l][i] = true;
					if(!isSteep) 
						break;

				}
				else if (prev < next && next-prev == 1) { // ���� ���� �� ���� ���̶�� ���� ���� L��ŭ ���ӵǾ��ִ��� üũ

					if(j < l-1) 						
						break;

					if(l == 1 && !save[j][i] && !steep[j][i]) {
						save[j][i] = true;
						continue;
					}
					else {
						if(l == 1)
							break;
					}

					boolean isSteep = true;
					for(int k = j; k > j-l+1; k--) {
						if(arr[k][i] != arr[k-1][i] || steep[k][i] || steep[k-1][i]
								|| save[k][i] || save[k-1][i]) {
							isSteep = false;
							break;
						}
						save[k][i] = true;
					}
					save[j-l+1][i] = true;
					if(!isSteep)
						break;

				}


			}
		}
		
		

//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j <n ;j++) {
//				System.out.print(steep[i][j] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(ans);

	}

}

/*
 * �̹� ���� ��簡 ��ġ�� �ȵȴٴ� ������ �����ϰ� Ǯ���ٰ� ������ �����ߴ�.
 * ���θ� ���� �� Ȯ���� �� �Ŀ� true false�� �ٲ�����ϴµ�, Ȯ�� ���� �ٲ��༭ �ٲ��ش����� ���ΰ� Ȯ������ ������ �ٸ� ���θ� �� ���� ������ �߱��ߴ�.
 * ������ else�� ���ų� ũ�� 1���� �۰� 1���̰� �ƴ϶�� break���ִ� �� �����ؼ� �����ߴ�. 
 * ���������� ���ٸ� �����ؼ� �ϳ��ϳ� ������ üũ����Ʈ�� ����!!!
 * 
 */









