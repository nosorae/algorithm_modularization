package PGM_Level1;

/*
 * 2021.06.23
 * PGM ���� ���ڴ� �Ⱦ� https://programmers.co.kr/learn/courses/30/lessons/12906
 * ���� �ȹٷ� �о��..!!!!!!!! ���� Ǯ���� ���� �����ؼ� ���� ���� �¾�� ���� ó�� Ǯ��ٴ� ���ε�� ���� �о��
 * ���� �ߺ��� �����ϸ� �Ǵ� �� �˾Ҵµ�, ������ �͸� �ϳ��� ����� ��������.
 * �ð��ʰ�?? LinkedList�� �ű�µ� 0, 1, 2, ... n���� ������ ��ȸ�ϴ� n^2�̳���... �̷� ��ȸ�� ArrayList�� 1�� ������
 * size()�Լ��� �����ϸ鼭 �پ�� �� ������ �ݺ������� ����� �����ؾ��Ѵٱ�!!
 * ArrayList�� �迭 �ϳ��� ���� �׸��� ����, �߰������� ������ ��ȸ(*), ������, ������(Ȯ�� ����)�� �ſ� ������. 
 * �ٵ� LinkedList�� ���(data, pointer(* 2)) �����ϴ� ������� ���������� ArrayList���ؼ� ���� �߰������� ������.
 */
import java.util.*;

public class PGM_HateSameNumber {
    public Integer[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] != arr[i+1])
                list.add(arr[i]);
        }
        list.add(arr[arr.length-1]);
        Integer[] answer = list.toArray(new Integer[list.size()]);
        return answer;
    }
}