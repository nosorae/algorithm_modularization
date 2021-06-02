package simulation;


import java.util.*;
/*
 * ���� 20055�� �����̾� ��Ʈ ���� �κ�
 * ������ �����Ѵ�. ���������� ������ �� �ؼ��ϰ� ������ �� �ݿ��ؼ� �����ߴ����� �߿� 
 * �����̾Ʈ�� ������ ���� �ִٰ� �ν��ϴ� �Ͱ�, 
 * �����̾Ʈ�� ������ �κ��� ���� �����δٴ� ��, 
 * �׸��� �κ��� ��ġ�� N�� �ʰ��� ���� ���ٴ� ���� �������� �����
 */

public class BOJ_20055 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] durab = new int[2*n+1]; // ������
		boolean[] isOn = new boolean[2*n+1]; // �κ�����
		int zero = 0;  // ������ 0 ����
		int ans = 0; // �� �ܰ��ΰ�

		for(int i = 1; i <= 2*n ; i++) {
			durab[i] = sc.nextInt();
		}

		while(true) {
			ans++;

			
			//�����̾� ��Ʈ�� �̵�
			isOn[n] = false;
			rotate_padding(durab);
			rotate_padding(isOn);
			isOn[n] = false;
			
//			for(int i = 1; i <= 2*n; i++) {
//				System.out.print(durab[i]+" ");
//			}
//			System.out.println();
//			for(int i = 1; i <= 2*n; i++) {
//				if(isOn[i])
//					System.out.print("1 ");
//				else
//					System.out.print("0 ");
//			}
//			System.out.println();

			
			//�κ��� �̵�
			for(int i = 2*n; i > 1; i--) {
				if(i-1 != n && isOn[i-1] && !isOn[i] && durab[i] >= 1) {
					isOn[i] = isOn[i-1];
					isOn[i-1] = false; // �̵� ���� ��ġ���� ���� �κ��� ���� ���̴�!!!!
					durab[i]--;
					if(durab[i] == 0)
						zero++;
				}

			}

			//�κ� �ø���
			if(durab[1] >= 1 && !isOn[1]) {
				durab[1]--;
				isOn[1] = true;
				if(durab[1] == 0)
					zero++;
			}


//			for(int i = 1; i <= 2*n; i++) {
//				System.out.print(durab[i]+" ");
//			}
//			System.out.println();
//			for(int i = 1; i <= 2*n; i++) {
//				if(isOn[i])
//					System.out.print("1 ");
//				else
//					System.out.print("0 ");
//			}
//			System.out.println();
//			System.out.println();


			if(zero >= k)
				break;



		}

		System.out.println(ans);





	}
	//�ε����� 1���� �����ϴ� 1�����迭 �� ĭ ������ ȸ��
	static void rotate_padding(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i = arr.length-1; i > 1; i--) {
			arr[i] = arr[i-1];
		}
		arr[1] = temp;
	}
	static void rotate_padding(boolean[] arr) {
		boolean temp = arr[arr.length-1];
		for(int i = arr.length-1; i > 1; i--) {
			arr[i] = arr[i-1];
		}
		arr[1] = temp;
	}


}

/*
 * ����Ʈ�� ������ؼ� �ܿ� Ǯ����. 
 * �̵������� �����ϰ� ��� ���Ҹ� �� ĭ�� �̵���Ű�� �� �ƴ϶�� �̵� ���� �ִ� ĭ���� �κ��� ���ٰ� ǥ���ؾ��Ѵ�.
 */


//
//import java.util.*;
//class Main {
//    static void rotate(int[] a) {
//        int temp = a[a.length-1];
//        for (int i=a.length-1; i>0; i--) {
//            a[i] = a[i-1];
//        }
//        a[0] = temp;
//    }
//	public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] a = new int[2*n];
//        for (int i=0; i<2*n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int[] box = new int[2*n];
//        int zero = 0;
//        for (int t=1;; t++) {
//            rotate(a);
//            rotate(box);
//            if (box[n-1] == 1) {
//                box[n-1] = 0;
//            }
//            for (int i=n-2; i>=0; i--) {
//                if (box[i] == 1) {
//                    if (box[i+1] == 0 && a[i+1] > 0) {
//                        box[i+1] = 1;
//                        box[i] = 0;
//                        a[i+1] -= 1;
//                        if (a[i+1] == 0) {
//                            zero += 1;
//                        }
//                    }
//                }
//            }
//            if (box[n-1] == 1) {
//                box[n-1] = 0;
//            }
//            if (a[0] > 0) {
//                box[0] = 1;
//                a[0] -= 1;
//                if (a[0] == 0) {
//                    zero += 1;
//                }
//            }
//            if (zero >= k) {
//                System.out.println(t);
//                break;
//            }
//        }
//    }
//}


