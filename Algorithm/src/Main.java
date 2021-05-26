
import java.util.*;

//dfs�ε� Ǯ� ��!!!

/*
 * ���� 15685�� �巡�� Ŀ��
 * 90�� ȸ���� ���������� ������ �迭������ ǥ���� �� �ִ�!! 
 */

public class Main {

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int n = sc.nextInt();
		boolean[][] arr = new boolean[100][100]; //���� �������� ������������ ����ȴ�.
		for(int i = 0; i < n; i++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			
			curve(arr, x, y, d, g); // ���� ����ش�.
		}
		for(int j = 0; j < 98; j++) {
			for(int k = 0; k < 98; k++) {
				if(arr[j][k] && arr[j][k+1] && arr[j+1][k] && arr[j+1][k+1])
					ans++;
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(arr[i][j])
					System.out.print("1 ");
				else 
					System.out.print("0 ");
			}
			System.out.println();
		}
		
		System.out.println(ans);

    }
	
	static void curve(boolean[][] arr, int x, int y, int d, int g) {
		
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { 1, 0, -1, 0 };
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(d);
		for(int i = 0; i <= g; i++) {
			//���� ����Ʈ�� ������ ���� �ݽð�������� ȸ����Ų ������ ���� ����Ʈ �ڿ� �߰�
			Stack<Integer> stack =  new Stack<Integer>();
			for(int direction : list)
				stack.push(direction);
			int size = stack.size();
			for(int j = 0; j < size; j++)
				list.add((stack.pop()+1)%4);
		}
		
		arr[x][y] = true;
		for(int i : list) {
			x = x+dx[i];
			y = y+dy[i];
			arr[x][y] = true;
		}
	}
	
}




