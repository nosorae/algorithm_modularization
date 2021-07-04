package simulation;

//�˰��� ��������  Ǯ�鼭 �� �� �̻� ���� �Լ��� ���⿡ ����
public class ArrayFunctions {
	// ���������� ���� ������ ���Ѵ�.
	static boolean prev_permutation(int[] perm) {
		int len = perm.length;
		int idx = len - 1;
		// ���������� ������ �ٷ� �����. ~�� �����ϴ� ù�����̶�� ������ ~�� �ٷ� ���� �ε����� ã���ִ� �۾�
		while(idx > 0 && perm[idx-1] <= perm[idx])
			idx--;
		if(idx == 0)
			return false;
		
		// lastIdx���� �ٷ� ���� ���Ҹ� lastIdx���ҿ� �ٲ��ش�.
		int lastIdx = idx - 1;
		idx = len - 1;
		while(perm[lastIdx] <= perm[idx])
			idx--;
		
		swap(perm, lastIdx, idx);
		reverse(perm, lastIdx+1, len-1);
		
		return true;
	}
	
	// ���������� ���� ������ ���Ѵ�.
	static boolean next_permutation(int[] prev) {
		//�ڿ������� ���������� ������ �ϳ��� �ٿ�����.
		int idx = prev.length - 1;
		while(idx > 0 && prev[idx - 1] >= prev[idx]) 
			idx--;
		
		//��� ���� ���������̶�� ������ �����̴�.
		if(idx == 0)
			return false;
		// lastIdx������ ���ʿ��� �������� �� ���ķδ� ���������̴�. �� 0~lastIdx ���ķδ� ������ ����
		int lastIdx = idx - 1;
		// lastIdx���ķδ� ���������̱� ������ ������ ���� �ϳ��� �����ٰ� lastIdx���Һ��� ū ���� ã���� 
		// lastIdx�� �� ���� ���Ҹ� ã�� �� �ִ�.
		idx = prev.length - 1;
		while(prev[lastIdx] >= prev[idx]) idx--;
		
		// lastIdx���ҿ� lastIdx�� �� ���� ���Ҹ� �ٲ��ش�.
		swap(prev, lastIdx, idx);
		// �� ����� ���ο� lastIdx���ҷ� �����ϴ� ������ �����̴�.
		// �̸� ���ο� lastIdx���ҷ� �����ϴ� ù ������ �ٲ�����Ѵ�.
		reverse(prev, lastIdx + 1, prev.length - 1);
		
		return true;
	}
	static void swap(int[] prev, int a, int b) {
		int temp = prev[a];
		prev[a] = prev[b];
		prev[b] = temp;
	}
	// ������ �迭���� left~right ���ҵ��� �����´�.
	static void reverse(int[] prev, int left, int right) {
		while(left < right) {
			swap(prev, left, right);
			left++;
			right--;
		}
	}

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
	
	//�־��� �ε����� �־��� �迭�ȿ� �ִ��� ���˻��ϴ� �Լ�
	static boolean isIn(int[][] arr, int nx, int ny) {
		if(nx >=0 && nx < arr.length && ny >=0 && ny < arr[0].length) 
			return true;
		else
			return false;
	}

}
