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

	//ĭ���� �ٲٱ�
	static void swap(int[][] arr, int x, int y, int nx, int ny) {
		int temp = arr[x][y];
		arr[x][y] = arr[nx][ny];
		arr[nx][ny] = temp;
	}

	//�� ���簢�� �κй迭�� �� ĭ�̶�� �����ϰ� �ٲٱ�
	static void swapSubArray(int[][] arr, int x, int y, int nx, int ny, int size) {
		for(int i = x; i < x+size; i++){
			for(int j = y; j < y+size; j++) {
				swap(arr, i, j, nx+(i-x), ny+(j-y));
			}
		}
	}

	//�� ���簢�� �κй迭�� �� ĭ�̶�� �����ϰ� �̵���Ű��
	static void copySubArray(int[][] arr, int[][] result, int x, int y, int nx, int ny, int size) {
		for(int i = nx; i < nx+size; i++) {
			for(int j = ny; j < ny+size; j++) {
				result[i][j] = arr[x+(i-nx)][y+(j-ny)];
			}
		}
	}


	//�ε����� 1���� �����ϴ� 1�����迭 �� ĭ ������ ȸ��
	static void rotate_padding(int[] arr) {
		int temp = arr[arr.length-1];
		for(int i = arr.length-1; i > 1; i--) {
			arr[i] = arr[i-1];
		}
		arr[1] = temp;
	}

}
