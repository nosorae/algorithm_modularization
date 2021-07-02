package PGM_Level2;

/*
 * 2021.07.02
 * PGM ��ݱװ� https://programmers.co.kr/learn/courses/30/lessons/17683#
 * ���Խ��� �̿��ϸ� ����� ����. �����ϳ��� ���ϳ���� �ν��ϴ� ������ ���ؼ� �ð��� �����ɷȴ�.
 * ���ڵΰ��� �� �ϳ��� �� �� �ִ�.
 * ���⼭ �ð��̵�(�� ���������� �д�����), ���ڿ��̵�(���⼭�� ����2���ڿ��� 1��, �ٸ������ Ǯ�̺��� ������) �ٲٸ� ������ ����ȭ�ȴٴ� ���� �˰� �Ǿ���. 
 * ���� �ð��� �д����� �ٲ�µ�, ���ڿ��� �׳� ������ �ߴ�.
 * ���ڿ� ����2¥���� 1�� �ٲٴ� ���� m = m.replaceAll("C#", "V"); �̷������� �ϸ� ������.
 * ���� �׳� �÷��� �ð���ŭ for������ �ð��� �������� �̿��ؼ� �÷��̵� �������� String���� ��ȯ�ϴ� �Լ��� �������
 * totalPlay.matches(".*"+m+"[^#].*") || totalPlay.matches(".*"+m) �̷��� Ǯ����.
 * �׸��� �䳻�� �κп� �� �����ض�. ������ġ������ -> ���̱�ͺ���, ���̰�����-> �����°ͺ���
 * 
 */

import java.util.*;
class PGM_JustNowMusic {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        HashMap<String, Integer> ans = new HashMap<>(); // ����� ����ð�
        ArrayList<String> order = new ArrayList<>();
        for(String info : musicinfos) {
            String[] infoArr = info.split("[,:]");
            int start = Integer.parseInt(infoArr[0]) * 60 + Integer.parseInt(infoArr[1]);
            int end = Integer.parseInt(infoArr[2]) * 60 + Integer.parseInt(infoArr[3]);
            int playTime = end - start; // (���Ǳ���)�� �� �����ѽð�, (���ð� - ���۽ð�)���� ����Ƚð�
            String title = infoArr[4];
            String music = infoArr[5];
            String totalPlay = getTotalPlay(music, playTime);
            
            
            if(totalPlay.matches(".*"+m+"[^#].*") || totalPlay.matches(".*"+m)) {
                int shp = 0;
                for(int i = 0; i < totalPlay.length(); i++) {
                    if(totalPlay.charAt(i) == '#')
                        shp++;
                }
                ans.put(title, totalPlay.length()-shp);
                order.add(title);
                
            }
                
        }
        int max = 0;
        for(Map.Entry<String, Integer> e : ans.entrySet()) {
            //��ġ�� �� ��������� ����ð��� ���� ���
            if(max < e.getValue()) {
                max = e.getValue();
                answer = e.getKey();
            }
        }
        
        //���� �� �� ��������� ���� �� ��
        for(String t : order) {
            if(max == ans.get(t)) {
                answer = t;
                break;
            }
        }
        
        if(ans.size() == 0)
            answer = "(None)";
     
        return answer;
    }
    // �ð��� �������� �̿��ؼ� �÷��̵� �������� String���� ��ȯ�ϴ� �Լ�
    static String getTotalPlay(String music, int playTime) {
        int shp = 0;
        for(int i = 0; i < music.length(); i++) {
            if(music.charAt(i) == '#')
                shp++;
        }
        
        int len = music.length() - shp;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < playTime/len; i++) {
            sb.append(music);
        }
        int idx = 0;
        for(int i = 0; i <  playTime%len; i++) {
            if(idx < music.length())
                sb.append(music.charAt(idx++));
               
            if(idx < music.length() && music.charAt(idx) == '#')
                  sb.append(music.charAt(idx++));
        }
        
        return sb.toString();
        
    }
    
}