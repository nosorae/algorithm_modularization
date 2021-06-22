package PGM_Level2;

/*
 * 2021.06.22
 * PGM �Ҽ�ã�� https://programmers.co.kr/learn/courses/30/lessons/42839
 * �Ҽ��� ���� : 1�� ������ ��� �ڿ����� ����� 1�� �ڱ��ڽ� ���� ����
 * ������ ���̰� �ִ� 7�̹Ƿ� 7! == 5040 ���� ���Ʈ������ ����� �������� Ȯ��
 * �ߺ��� ���ڰ� �ֱ⶧����("011"ó��) ������ �Ű�����ߴ�. �̷��� ����������� �ϴ±���
 * �ߺ��� ���Ұ� ���� �� �ߺ��� ��� ���� ���Ʈ�����ϴ� ���� ��Ծ HashSet��� �ٽ� �˾ƺ���..
 * static �������� ���̰� �ذᵵ �غ���..
 * <�߰�> Set���Ÿ� cnt���� ���ֵ� �ȴ�. �ֳ��ϸ� Set.size���� �Ǵϱ�
 * 
 */
import java.util.*;

class PGM_FindPrimeNum {
    static int[] nums; // ���� ���ڸ����� �迭ȭ
    static boolean[] isUsed;  // ���Ʈ�������� check �迭�� ���
    static boolean[] isNotPrime; // �Ҽ����� �Ǻ��ϴ� �迭 false�̸� �Ҽ�
    static int len; // ù �Է� String�� ����
    static int cnt; // ���信 ���� ���̴�.
    static HashSet<String> included = new HashSet<String>();
    public int solution(String numbers) {
        isNotPrime = getPrimeArr(10000000);
        len = numbers.length();
        nums = new int[len];
        isUsed = new boolean[len]; 
        cnt = 0;
        for(int i = 0; i < numbers.length(); i++) {
            nums[i] = numbers.charAt(i) - '0';
        }
        findPrimeNum("");
        
        int answer = cnt;
        return answer;
    }
    static boolean[] getPrimeArr(int n) {
        boolean[] arr = new boolean[n+1]; // 1000�� ���� �� 10MB?
        arr[1] = true;
        for(int i = 2;  i < n/2; i++) {
            if(!arr[i]) {
                for(int j = i*2;  j <= n; j += i) {
                    arr[j] = true; //false�̸� �Ҽ��� �ȴ�.
                }
            }
        }
        return arr;
    }
    
    static void findPrimeNum(String curNum) {
        
        //Ż������
        if(curNum.length() > len)
            return;
        
        /*
         * 1. �� ���ڿ��̸� ���� �ȵ�
         * 2. �ձ��ڰ� 0�̸� ���� �ȵ�
         * 3. 1, 2�� �����ϸ� �����̴� �Ҽ����� �Ǻ�
         * 4. �̹� �������� ī��Ʈ�� �������� �Ǻ�
         */
        if(curNum.length() != 0 && curNum.charAt(0) != '0'
           && !isNotPrime[Integer.parseInt(curNum)] && !included.contains(curNum)) { 
            cnt++;
            included.add(curNum);
            System.out.println(curNum);
        }
            
        for(int i = 0; i < len; i++) {
            if(!isUsed[i]) { // �ߺ�üũ 
                isUsed[i] = true;
                findPrimeNum(curNum+nums[i]);
                isUsed[i] = false;
            }
        }
        
    }
}


/*
 * �Ʒ��� ���� ����� �ֱ��� <��ó> ���α׷��ӽ� �ٸ� ����� Ǯ��
 * set�� ��� ����� ���� �� �־���� �����ϴ� �ߺ�üũ�� �ʿ���Եȴ�.
 */


//import java.util.HashSet;
//class Solution {
//    public int solution(String numbers) {
//        HashSet<Integer> set = new HashSet<>();
//        permutation("", numbers, set);
//        int count = 0;
//        while(set.iterator().hasNext()){
//            int a = set.iterator().next();
//            set.remove(a);
//            if(a==2) count++;
//            if(a%2!=0 && isPrime(a)){
//                count++;
//            }
//        }        
//        return count;
//    }
//
//    public boolean isPrime(int n){
//        if(n==0 || n==1) return false;
//        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
//            if(n%i==0) return false;
//        }
//        return true;
//    }
//
//        public void permutation(String prefix, String str, HashSet<Integer> set) {
//        int n = str.length();
//        //if (n == 0) System.out.println(prefix);
//        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
//        for (int i = 0; i < n; i++)
//          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
//
//    }
//
//}
