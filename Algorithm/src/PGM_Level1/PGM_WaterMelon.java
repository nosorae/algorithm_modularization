package PGM_Level1;

/*
 * PGM ���ڼ��ڼ���.. https://programmers.co.kr/learn/courses/30/lessons/12922?language=java
 * return new String(new char [n/2+1]).replace("\0", "����").substring(0,n); �̷������;;
 */ 
import java.util.*;
class PGM_WaterMelon {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= n/2; i++)
            sb.append("����");
        
        String answer = sb.toString().substring(0, n);
        return answer;
    }
}