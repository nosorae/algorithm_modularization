import java.util.*;
import java.io.*;
/*
 * ���� 13913 ���ٲ���4 
 * 1. ���� �������� �̵��ϴ� next������ �ִ밪 ���ó���� ���൵ �ǰ�
 *    ���� �������� �̵��ϴ� next������ �ּҰ� ���ó���� ���൵ �ȴ�.
 */
public class Main {
   
    public static void main(String[] args) throws IOException {
    	
    	int[] arr = {3, 5, 7, 9, 1, 1, 3, 3, 3, 3, 4, 1, 4, 4};
    	int[] ans = solution(arr);
    	for(int n : ans) {
    		System.out.print(n+" ");
    	}
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	
    
    }
    
    static int[] solution(int[] arr) {
        int[] count = new int[101];
        boolean[] check = new boolean[101];
        int size = 0;
        for(int n : arr) {
            count[n]++;
            if(count[n] == 2) {
            	check[n] = true;
            	size++;
            }
        }
        

        int[] ans = new int[size];
        
        if(size == 0) {
        	ans = new int[1];
        	ans[0] = -1;
        }
        else {
        	int ans_idx = 0;
            for(int i = 1; i < 101; i++) {
                if(check[i]) {
                    ans[ans_idx] = count[i];
                    ans_idx++;
                }
            }
        }
        
        
        return ans;
        
    }
}