package PGM_Level2;


import java.util.*; 
/*
 * 2021.06.22
 * PGM ���� ū �� https://programmers.co.kr/learn/courses/30/lessons/42746#
 * ���� Ǯ�� ���� ��� ���� �� �ؼ��غ��� ���� ��Ȯ�� �ľ��ϰ� �ڵ� ����...!
 * ���ڸ� �̻���ڴ� ���ڸ��� ���� �� �� �ִ� �� �˰� ���� Ǯ���ٰ� ������
 * ����Ŭ���� �߿� Integer �迭�� �ʱ⺯���� null�̱���..!
 * 0����ó�� ����!!!
 */
class PGM_MaxNum {
    public String solution(int[] numbers) {
        
        int len = numbers.length;
        Integer[] result = new Integer[len];
        
        for(int i = 0; i < len; i++)
            result[i] = numbers[i];
        
        Arrays.sort(result, new MyComparator());
            
        if(result[0] == 0)
            return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(int num : result) {
            sb.append(num);
        }
       
        String answer = sb.toString();
        return answer;
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        StringBuilder str1 = new StringBuilder(o1+"");
        StringBuilder str2 = new StringBuilder(o2+"");
        str1.append(o2+"");
        str2.append(o1+"");
        
        //return str2.toString().compareTo(str1.toString());
        return Integer.parseInt(str2.toString()) - Integer.parseInt(str1.toString());
        
        
    }
    
}