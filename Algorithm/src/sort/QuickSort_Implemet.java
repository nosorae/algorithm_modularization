package sort;

public class QuickSort_Implemet {

	public static void main(String[] args) {
		int[] arr = {7, 5, 3, 9, 8, 1};
		System.out.println("Quick Sort");
		sort(arr, 0, arr.length-1);

		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		String str = "";
		
	}

	static void sort(int[] arr, int left,int right) {
		int pl = left;
		int pr = right;
		int pivot = arr[(pl+pr)/2];


		do {
			// >= <= �ƴ�!! �׷��� �ε��� ���� �ȳѾ�� �����.
			while(arr[pl]<pivot) pl++; //ū�𳪿ö����� ���������� 
			while(arr[pr]>pivot) pr--; //�����𳪿ö�����  �������� 
			//Ż���ߴٴ°� ũ�ų�, ���ų� �Ѱ�
			if(pl<=pr) { 			// pl�� pr�� ������ 
				int temp = arr[pl];	// ��ġ�� �ٲ��ش� . 
				arr[pl] = arr[pr];
				arr[pr] = temp;
				pl++;
				pr--;
			}
		}while(pl<=pr);	//��ü���� pl < pr�� �� ������ 

		if(left < pr) sort(arr, left, pr);
		if(right> pl) sort(arr, pl, right);
	}

}



//	static void quickSort(int[] arr, int left, int right) {
//
//		int pivot = partition(arr, left, right);
//
//		if(pivot > 0)
//			quickSort(arr, left, pivot-1);
//
//		if(pivot < arr.length-1)
//			quickSort(arr, pivot+1, right);
//
//	}
//
//	/*
//	 * pivot�� ���� �������� ������ ���� ���ڸ� �������� ū ���ڸ� ��ġ�ϰ� ����� 
//	 * ���ο� pivot�� right�� ��ȯ�Ѵ�?
//	 */
//	static int partition(int[] arr, int left, int right) {
//
//		int pivot = (right + left)/2;
//		do {
//			while(left < arr.length-1 && arr[left] <= arr[pivot]) left++;
//			while(right > 0 && arr[right] >= arr[pivot]) right--;
//
//			if(left <= right) {
//				swqp(arr, left, right);
//			}
//
//
//		} while(left <= right);
//
//		swqp(arr, pivot, right);
//
//		return right;
//
//
//	}
//	static void swqp(int[] arr, int a, int b) {
//		int temp = arr[a];
//		arr[a] = arr[b];
//		arr[b] = temp;
//	}
//}
