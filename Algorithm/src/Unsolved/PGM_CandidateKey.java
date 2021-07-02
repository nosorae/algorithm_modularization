
package Unsolved;

/*
 * ���̺��� �־����� �� �ĺ�Ű ���� ���ϴ� ���� 
 * col�� �ִ� 8�ۿ� �ȵǹǷ� ��� ������ �� �غ� �� �ִ�. 
 * �׷��� 1������ 8���� ������ �� �����غ��� �Լ��� �ʿ��ϴ�. ���ڴ� �������, �ε����� ������ �ɵ�
 * (8C1 + 8C2 + ... + 8C8)*20 �̷��� �� �� �ϴ�. 
 * �׸��� �� ���ո��� �ĺ�Ű�� �� �� �ִ��� �˻����ִ� �Լ��� �ʿ��ϴ�.
 * ���⼭ ������ �ּҼ��� ���������־���Ѵٴ� ���ε� ������� 12�� �ĺ�Ű�̰� 123�� �ĺ�Ű�� �� ���� 12�� �ĺ�Ű�̴�.
 * ���� check�迭�� ���� �̹� �ĺ�Ű�� ���Ե� ���� �ִ� �÷��� �ǵ帮�� �ʴ´�. �� ��Ʈ��ŷ�Ѵ�.
 */
import java.util.*;
class Solution {
    static int[] idxArr = new int[8];
    static int COLS; //������
    static int cnt; // ����
    static HashSet<String> check = new HashSet<>();
    
    public int solution(String[][] relation) {
        COLS = relation[0].length;
        cnt = 0;
        
        for(int i = 1; i <= COLS; i++) {
            findAllCombination(relation, i, 0, 0);
        }
        int answer = cnt;
        return answer;
    }

    static void findAllCombination(String[][] relation, int n, int idx, int start) {
        
        
        
        
        if(idx == n) {
            
            
            boolean flag = true;
            //���� �� �ִ� �� �������� �˻�
            //System.out.println(check.toString());
            for(int j = 0; j <= idx-1; j++) {
                for(int k = j+1; k <= idx; k++) {
                    //System.out.println(n+"�� �̱⿡�� "+intArrToString(j, k)+" ("+j+", "+k+")");
                    if(check.contains(intArrToString(j, k)))
                        flag = false;
                }
            }
            if(!flag) {System.out.println(intArrToString(0, idx)+"������ �ּҼ��� ������Ű�� ���� �ĺ�Ű�� �� �� �����ϴ�. ���ư��ϴ�"); return;}
           
            if(checkCandidate(relation, idx)) {  //�˻�
                cnt++;
                check.add(intArrToString(0, idx)); //�ĺ�Ű�� �� �÷��� �ٸ� �������� �ĺ�Ű�� �� ��x
                //System.out.println(check.toString());
                System.out.println(intArrToString(0, idx)+"�� �ĺ�Ű�� �� �� �ֽ��ϴ�.");
            }
            else {
                System.out.println(intArrToString(0, idx)+"�� ���ϼ��� ������Ű�� ���� �ĺ�Ű�� �� �� �����ϴ�. ���ư��ϴ�");
            }
                
            return;
        }
        
        
        
        for(int i = start; i < COLS; i++) {
            idxArr[idx] = i;
            //System.out.println(n+"�� �̱⿡�� "+intArrToString(0, idx+1)+" �õ��غ��ϴ�.");
            findAllCombination(relation, n, idx+1, i+1);
                
            // else
            //     System.out.println(n+"�� �̱⿡�� ["+intArrToString(0, idx+1)+"]�� �̹� set�� �ֽ��ϴ�.");
        }
    
    }
    static boolean checkCandidate(String[][] relation, int len) {
        //�ش� �÷����� ���տ��� �ߺ��Ǵ� ���� ������ true ������ false
        HashSet<String> set = new HashSet<>();
        for(String[] relat : relation) {
            String localKey = "";
            for(int i = 0; i < len; i++) {
                localKey = localKey + relat[idxArr[i]];
            }
            //System.out.println(localKey);
            if(set.contains(localKey))
                return false;
            else
                set.add(localKey);
        }
        return true;
    }
    
    static String intArrToString(int start, int end) {
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < end; i++)
            sb.append(idxArr[i]+"");
        return sb.toString();
    }
    
}