package PGM_Level1;


/*
 * 2021.06.20
 * PGM �ű� ���̵� ��õ
 * ���Խ��� ����ϸ� ������ ����... �̷��� �ߴ�. ���Խ� Ǯ�̵� �˾ƺ� ��
 */ 

import java.util.*;

class PGM_NewIdRecommend {
    public String solution(String new_id) {
        LinkedList<Character> resultId = new LinkedList<Character>();
        
        if(new_id.length() == 0)
            new_id = "a";
        
        int len = new_id.length();
        for(int i = 0; i < len; i++) { //new_id�� �ѱ��ھ� �д´�. for�� ���ο��� �����̳� ����(continue)�� �Ͼ��.
            char cur = new_id.charAt(i); 
            
            if(cur >= 'A' && cur <= 'Z') //�빮�ڸ� �ҹ��ڷ� �ٲ۴�.
                cur += 32;
            else if(cur == '.') { //'.' �� ���� ���ʰ� �̹� �տ� '.'�� �ְų� ó���̳� �������� �����ߴٸ� ���� �ʴ´�.
                if(resultId.isEmpty())
                    continue;
                if(resultId.getLast() == '.' ||  i == 0  || i == len - 1 )
                    continue;
            }
            else if(!(cur == '-' || cur == '_' || (cur >= '0' && cur <= '9') 
                    || (cur >= 'a' && cur <= 'z'))) { // �״�� �ִ� ������ ��찡 �ƴϸ� ���� �ʴ´�.
                continue;
            }
            
            resultId.addLast(cur);
            //System.out.println(resultId.toString());
            
        }
        //�� for������ �������� .�� ���� ���� ������ �Ϳ� ����
       
        StringBuilder sb = new StringBuilder();
        
        // ���� ��ó��
        if(resultId.size() == 0) {
            sb.append("aaa");
        }
        else if(resultId.size() <= 2) {
            
            if(!resultId.isEmpty() && resultId.getLast() == '.')
                resultId.remove(resultId.size() - 1);
            
            while(resultId.size() <= 2) {
                resultId.add(resultId.get(resultId.size() - 1));
            }
            while(!resultId.isEmpty()) {
                sb.append(resultId.remove(0));
            }
            
        }
        else {
            int i = 0;
            LinkedList<Character> temp = new LinkedList<Character>();
            while(!resultId.isEmpty()) {
                
                temp.add(resultId.remove(0));
                
                if(temp.size() >= 15)
                    break;
            
            }
            if(!temp.isEmpty() && temp.getLast() == '.') {
                temp.remove(temp.size() - 1);
                
                if(temp.size() == 2)
                    temp.add(temp.getLast());
            }
                
            
            while(!temp.isEmpty()) {
                sb.append(temp.remove(0));
            }
        }

        String answer = sb.toString();
        return answer;
    }
}