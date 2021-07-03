package PGM_Level2;

// 2021.07.02
// PGM ���ϸ� ���� https://programmers.co.kr/learn/courses/30/lessons/17686
//���� ��ҹ���, ����, ����(" "), ��ħǥ("."), ���� ��ȣ("-") �θ� �̷����
//���ϸ��� �����ڷ� �����ϸ�, ���ڸ� �ϳ� �̻� �����ϰ� �ִ�.
//���ϸ��� �켱 HEAD �κ��� �������� ���� ������ �����Ѵ�.
//HEAD�� ���ٸ� ���� ������ ����
//���ڵ� ���ٸ� ó���� �־��� ���� ����
//Ŭ�������� head number id ������ compareTo ����
//Tail�� ��ǻ� �ʿ����..?
//ù������ ������ ���� �ּ� �ϳ��̻� => �״����� ���� ������ �ϳ��̻� �ִ� �ټ���
import java.util.*;
class PGM_FileNameSort {
 public String[] solution(String[] files) {
     ArrayList<File> infos = new ArrayList<File>();
     
     for(int i = 0; i < files.length; i++) {
         String cur = files[i];
         String head = "";
         int number = 0;
         
         int idx = 0;
         StringBuilder sb = new StringBuilder();
         while(!isNumber(cur.charAt(idx))) {
             sb.append(cur.charAt(idx));
             idx++;
         }
         head = sb.toString();
         
         
         sb = new StringBuilder();
         for(int j = 0; j < 5; j++) {
             if(!isNumber(cur.charAt(idx)))
                 break;
             else {
                 sb.append(cur.charAt(idx));
                 idx++;
             }
             
             if(idx >= cur.length()) //tail���� ���ڷ� 5�� �̸����� ä��� ���� ���� ������ 
                 break;
         }
         number = Integer.parseInt(sb.toString());
         // System.out.println("head : "+ head);
         // System.out.println("nubmer : "+sb.toString());
         
         infos.add(new File(head, number, i));
     }
     Collections.sort(infos);

     String[] answer = new String[infos.size()];
     for(int i = 0; i < infos.size(); i++) {
         answer[i] = files[infos.get(i).id];
     }
     return answer;
 }
 static boolean isNumber(char c) {
     if(c < '0' || c >'9')
         return false;
     else 
         return true;
 }
}


class File implements Comparable<File> {
 String head;
 int num;
 int id;
 public File(String h, int n, int i) {
     head = h.toLowerCase();
     num = n;
     id = i;
 }
 @Override
 public int compareTo(File o) {
     if(this.head.compareTo(o.head) != 0) {
         return this.head.compareTo(o.head);
     }
     else {
         if(this.num - o.num != 0) {
             return this.num - o.num;
         }
         else {
             return this.id - o.id;
         }
     }
 }
 @Override
 public String toString() {
     return "["+head+", "+num+", "+id+"]";
 }
}