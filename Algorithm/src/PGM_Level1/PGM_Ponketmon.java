package PGM_Level1;


/*
 * 2021.06.23 
 * PGM ���ϸ� https://programmers.co.kr/learn/courses/30/lessons/1845
 * set�� �� �־ set�� ������� N/2���� ũ�� N/2�� ���̰� N/2���� ������ set�� ����� ��
 * set�� �ߺ�x��� ���� �̿�
 * 12��
 */
import java.util.*;
class PGM_Ponketmon {
    public int solution(int[] nums) {
        HashSet<Integer> ponkets = new HashSet<Integer>();
        for(int n : nums) {
            ponkets.add(n);
        }
        int answer = ponkets.size();
        if(ponkets.size() > nums.length/2) 
            answer = nums.length/2;
        return answer;
    }
}