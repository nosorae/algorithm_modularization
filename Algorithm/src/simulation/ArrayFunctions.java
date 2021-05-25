package simulation;

//�˰��� ��������  Ǯ�鼭 �� �� �̻� ���� �Լ��� ���⿡ ����
public class ArrayFunctions {
	
	
	
	//2���� �迭�� ���
	public static void printArray2(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	//1���� �迭 �������� �� ĭ ����
	static void push_left(int[] arr) {
		int temp = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = temp; 
		
	}
	//1���� �迭 �������� �� ĭ �б�
	static void push_right(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i = arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
	}

}
