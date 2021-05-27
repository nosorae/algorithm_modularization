package simulation;

import java.util.*;



/*
 * ���� 15685�� �巡�� Ŀ��
 * �ð���� ȸ���ؼ� ������ ���̴� ���� �ݺ��ؼ� ������ �׸��� ���������� ������ �迭������ ǥ���� �� �ִ�!! 
 * ���븦 �ŵ��� ������ �� ��ҿ� �����ִ� ���� ��Ҹ� ã�ٺ��� ��Ģ���� �߰�!
 */

public class BOJ_15685 {

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int n = sc.nextInt();
		boolean[][] arr = new boolean[101][101]; //���� �������� ������������ ����ȴ�.
		for(int i = 0; i < n; i++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			
			curve(arr, x, y, d, g); // ���� ����ش�.
		}
		for(int j = 0; j < 100; j++) {
			for(int k = 0; k < 100; k++) {
				if(arr[j][k] && arr[j][k+1] && arr[j+1][k] && arr[j+1][k+1])
					ans++;
			}
		}
		
//		for(int i = 0; i < 30; i++) {
//			for(int j = 0; j < 30; j++) {
//				if(arr[i][j])
//					System.out.print("1 ");
//				else 
//					System.out.print("0 ");
//			}
//			System.out.println();
//		}
		
		System.out.println(ans);

    }
	
	static void curve(boolean[][] arr, int x, int y, int d, int g) {
		//0 �� // 1 �� // 2 �� // 3 �� 
		int[] dy = { 0, -1, 0, 1 }; //��
		int[] dx = { 1, 0, -1, 0 }; //�� 
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(d); //�̰� 0���� 
		for(int i = 0; i < g; i++) { // 0������� g������� 
			//���� ����Ʈ�� ������ ���� �ݽð�������� ȸ����Ų ������ ���� ����Ʈ �ڿ� �߰�
			Stack<Integer> stack =  new Stack<Integer>();
			
			for(int direction : list)
				stack.push(direction); //������ �ڵ����� reverse�� 
			
			int size = stack.size();
			for(int j = 0; j < size; j++) {
				list.add((stack.peek()+1)%4); //�ݽð�
				stack.pop();
			}
		}
		
		arr[y][x] = true;
		for(int i : list) {
//			System.out.print(x+"��  "+y+"��  --"+i+"--> ");
			y = y+dy[i];
			x = x+dx[i];
//			System.out.println(x+"��  "+y+"��");
			arr[y][x] = true;
		}
		
//		System.out.println("--------------------");
	}
	
}

/*
 * 0���� ó���س��� �ݺ������� �� ó���ϴϱ� g+1������� ����ϴ� ������ �߻� -> ������ ����Ʈ(�ּ�)�ؼ� �ذ� ���� �� �ذ�
 * ��ǥ�� ������ �������� ��ǥ�� ������ �� �ľ��ؾ��Ѵ�. �迭�� ��ǥ�� �ִ��� ���п����� x, y��ǥ�� �ִ��� 
 * �� �ΰ� �̸��� �������� �� �ľ��ؼ� ������ ��������
 * 
 * ArrayList<Integer> temp = new ArrayList<>(ans); �̷��� ������ ����Ʈ�� ���ο� ����Ʈ ��ü �ϳ� �� ���� �� �ִ�.
 *  ans.addAll(temp); �� �ѹ��� ���� �� �ִ�.
 * 
 */


//import java.util.*;
//public class Main {
//    static boolean[][] c = new boolean[101][101];
//    static int[] dx = {0,-1,0,1};
//    static int[] dy = {1,0,-1,0};
//    static ArrayList<Integer> curve(int x, int y, int dir, int gen) {
//        ArrayList<Integer> ans = new ArrayList<>();
//        ans.add(dir);
//        for (int g=1; g<=gen; g++) {
//            ArrayList<Integer> temp = new ArrayList<>(ans);
//            Collections.reverse(temp);
//            for (int i=0; i<temp.size(); i++) {
//                temp.set(i, (temp.get(i)+1)%4);
//            }
//            ans.addAll(temp);
//        }
//        return ans;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while (n-- > 0) {
//            int y = sc.nextInt();
//            int x = sc.nextInt();
//            int dir = sc.nextInt();
//            int gen = sc.nextInt();
//            ArrayList<Integer> dirs = curve(x,y,dir,gen);
//            c[x][y] = true;
//            for (int d : dirs) {
//                x += dx[d];
//                y += dy[d];
//                c[x][y] = true;
//            }
//        }
//        int ans = 0;
//        for (int i=0; i<=99; i++) {
//            for (int j=0; j<=99; j++) {
//                if (c[i][j] && c[i][j+1] && c[i+1][j] && c[i+1][j+1]) {
//                    ans += 1;
//                }
//            }
//        }
//        System.out.println(ans);
//    }
//}




