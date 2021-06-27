package PGM_Level2;

/*
 * 2021.06.27
 * PGM ���� Ŭ�����͸� https://programmers.co.kr/learn/courses/30/lessons/17677
 * �� ���ڿ� �ѱ��ھ� �̵��ϸ� �α��ھ� �ڸ��� ���� ��(key : �α���, value : ����)�� �����
 * (�̶� ��� �ҹ���ȭ�ϰ�, Ư�����ڴ� ����)
 * �����հ� ������ ���� �����. �� �ܰ谡 �� ������ �ٽ�
 * ���絵 ���ϰ� 65536 ���ϰ� �����θ� ������ ����.
 * �ߺ����տ����� map.size()�� ������ ���� ������.
 * �׷��� �ߺ����տ��� ������ �� ���� != ������ ���� ������.
 * ���� ���տ����� ������ �� ���� == ������ ���� ���� �� �򰥷ȴ�. �̰� ������ �����ؼ� �ð� ���� ���ȴ�.
 * double�� int ����ȯ�� ��������� �� �� �˾ƾ��Ѵ�! �̰� �������� �����ؼ� �ð� ���ȴ�.
 * �������� �̷� �Ǽ����� ���� �Ǽ��ߴ� �ϴ��� ���� �κ� ������� ���� ������ ����κ��� �ٽ� ����غ��߰ڴ�.
 * 1�ð� 12��
 *
 */
import java.util.*;
class PGM_NewsClustering_Hard {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        HashMap<String, Integer> strMap1 = new HashMap<>();
        HashMap<String, Integer> strMap2 = new HashMap<>();
        makeStrMap(strMap1, str1);
        makeStrMap(strMap2, str2);
        
        HashMap<String, Integer> inter = getInter(strMap1, strMap2);
        HashMap<String, Integer> union = getUnion(strMap1, strMap2);
        
        int interCnt = getMapCount(inter);
        int unionCnt = getMapCount(union);
        
        if(union.size() == 0) return 65536;
        double similarity = interCnt / (double)unionCnt;
        //System.out.println(interCnt +" / "+ unionCnt +" = " +similarity);
        int answer = ((int)(similarity*65536*10))/10;
        return answer;
    }
    
    static void makeStrMap(HashMap<String, Integer> map, String str) {
        for(int i = 0; i < str.length()-1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);
            if(isAlphabet(c1) && isAlphabet(c2)) {
                String localStr = str.substring(i, i+2);
                if(map.containsKey(localStr)) {
                    map.put(localStr, map.get(localStr)+1);
                }
                else {
                    map.put(localStr, 1);
                } 
            }
        }
    }
    static boolean isAlphabet(char c) {
        if(c >= 'a' && c <= 'z')
            return true;
        else
            return false;
    }
    
    static HashMap<String, Integer> getInter(Map<String, Integer> m1, Map<String, Integer> m2) {
        HashMap<String, Integer> inter = new HashMap<String, Integer>();
        for(String key : m1.keySet()) {
            if(m2.containsKey(key)) {
                inter.put(key, getMin(m1.get(key), m2.get(key)));
            }
        }
        return inter;
    }
    static int getMin(int a, int b) {
        if(a < b) return a;
        else return b;
    }
    
    static HashMap<String, Integer> getUnion(Map<String, Integer> m1, Map<String, Integer> m2) {
        HashMap<String, Integer> union = new HashMap<String, Integer>();
        for(String key : m1.keySet()) {
            if(m2.containsKey(key)) {
                union.put(key, getMax(m1.get(key), m2.get(key)));
                m2.remove(key);
            }
            else
                union.put(key, m1.get(key));
        }
        for(String key : m2.keySet()) {
            union.put(key, m2.get(key));
        }
        
        return union;
    }
    static int getMax(int a, int b) {
        if(a > b) return a;
        else return b;
    }
    
    static int getMapCount(HashMap<String, Integer> map) {
        int sum = 0;
        for(int v : map.values())
            sum += v;
        return sum;
    }
    
    
}