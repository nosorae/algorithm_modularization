package PGM_Level2;

/* 
 * 2021.06.27
 * PGM ����ä�ù� https://programmers.co.kr/learn/courses/30/lessons/42888?language=java
 * 1-100,000
 * Enter, Change, Leave ��ɾ�, uid, �̸�(�ߺ�����) �������� �̷���� record
 * uid�� ����� ��ȸ�Ѵ�. -> �� uid�� �ߺ�x�̹Ƿ� Set���� ����
 * uid�� key, nick�� value�� Map��, order�� uid�� ��� ����Ʈ�� ������ش�.
 * Map�� uid�� ���µ� order�� Enter�� Map uid�� nick �־��ְ� ����Ʈ�� �߰�,
 * Map�� �ִµ� Enter�� Map���� uid�� nick�� �ٲ��ְ� ����Ʈ�� �߰�,
 * Change�� Map���� uid�� name�� �ٲ��ְ�
 * Leave�� ����Ʈ�� �߰��Ѵ�.
 * �� ������ ������ ��ɾ�� uid�� ���� ����Ʈ�� ���� ���� ������ ������ش�.
 * 44��
 */
import java.util.*;
class PGM_OpenChatting {
    public String[] solution(String[] record) {
        HashMap<String, String> uidMap = new HashMap<String, String>();
        ArrayList<Order> orderList = new ArrayList<Order>();
        ArrayList<String> ansList = new ArrayList<String>();
        
        for(int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String order = st.nextToken();
            String uid = st.nextToken();
            String nick = "";
            if(!order.equals("Leave"))
                nick = st.nextToken();
            switch(order) {
                case "Enter":
                    uidMap.put(uid, nick);
                    orderList.add(new Order(order, uid));
                    break; 
                case "Change":
                    uidMap.put(uid, nick);
                    break;
                case "Leave":
                    orderList.add(new Order(order, uid));
            }
        }
        for(int i = 0; i < orderList.size(); i++) {
            String nick = uidMap.get(orderList.get(i).uid);
            String order = orderList.get(i).order;
            String localAns = nick+"���� ";
            if(order.equals("Enter"))
                localAns += "���Խ��ϴ�.";
            else
                localAns += "�������ϴ�.";
            ansList.add(localAns);
        }
        String[] answer = ansList.toArray(new String[ansList.size()]);
        return answer;
    }
}
class Order {
    String order;
    String uid;
    public Order(String o, String u) {
        order = o;
        uid = u;
    }
}