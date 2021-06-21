package PGM_Level2;


/*
 * 2021.06.21
 * PGM ��ȭ��ȣ ��� https://programmers.co.kr/learn/courses/30/lessons/42577
 * �Է� �迭�� ������ �ִ밪�� 100���̱� ������ �ð�ȿ���� N^2�� �Ǿ ���� �ȵȴٰ� �����ߴ�.
 * �׷��� N*M�� �����س´�. N�� �ִ� 100�� M�� �ִ� 20���� �ִ� 2000���̴�.
 * �ؽ��� Ž���ɷ�(O(1))�� ����ϴٴ� ���� �ٽ��ѹ� ������.
 */ 

import java.util.*;

class PGM_PhoneBook {
    public boolean solution(String[] phone_book) {
        HashSet<String> phoneBook = new HashSet<String>();
        boolean answer = true;
        
        for(int i = 0; i < phone_book.length; i++) {
            phoneBook.add(phone_book[i]);
        }
        
        
        for(int i = 0; i < phone_book.length; i++) {
            String cur = phone_book[i];
            // �ߺ��� ������ ���̰� �ȴٸ� substring(0, 19)���� �ߺ� ���θ� Ȯ���غ���.
            for(int j = 0; j < cur.length(); j++) {
                if(phoneBook.contains(cur.substring(0, j)))
                    answer = false;
            }
            if(!answer)
                break;
        }

        return answer;
    }
}
