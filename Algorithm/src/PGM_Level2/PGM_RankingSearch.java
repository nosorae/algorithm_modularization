package PGM_Level2;

/*
 * ��� ����, �� ����Ʈ ����, �ִϾ� �ôϾ� ����, ġŲ ���� ����
 * ������ 5�� ������ 10��
 * ���������� �Ź� ����Ȯ�ο� ���ٸ�??  500000������ ���ڰ� �ʹ� ŭ
 * ���� ��� ����� ���� ���ڸ� �̸� ���س����� �ȴ�. 
 * 4 * 3 * 3 * 3 = 108���� �ٵ� �� ������ ������..
 * �׷� Ŭ������ ����� Map<String, Set<Candidate>>�� �� ���ú��� ���� �����ϴ� ���� ���?? 
 * �׷� �ϳ��� ������Ҹ��� �������ϸ� ���� ���´�. retainAll�� �ð����⵵��??
 * �Ƹ��� O(N)�� Ȯ���� ����. 
 * �̰� ����µ� 20�� �ۿ� �ȵ��. �׸��� ������ ���� 4������ ���� ���� �� �ִ�.
 * �ð��ʰ��� ���µ� NlogN���� �̸� ���� �����ϰ� ������ �ϰ�
 * logN���� �������� ã�� ��ü�ε��� - �����ε��� + 1 �ϸ� �� ���� ���� �� �ִ�.
 * --- ���ϴ� ���Ǹ� ���� ������ �ڵ带 �ٲ� �����̴�. ---
 * ���� �������� ���ϴ� ����� ���ָ� �ȴ�.
 * �������� ���ϴ� ����� ���� ���������� ������ �´� �����ڵ��� �˰� 
 * ���߿��� �ش� ���� �̻��� �����ڵ��� ��������� �˸�ȴ�.
 * �� ������ ��������� �˸� �ȴٴ� ��.
 * �� ���� ����Ʈ�� �ְ� ���ĵǾ��ִٸ� logN���� ������� ã�� �� �ִ�. 
 * �������� ������ info�� 5���ۿ� �ȵǰ� query�� 10���̳� ���� ������ ��ġ�� ë����ߴ�.
 * 108���� �̸� ���س����Ѵٴ� �ͱ����� ������ ��Ҵµ� ��� �������� �����ߴ�.
 * ���ǿ� ���� ������� ArrayList<Integer>�� 4�����迭 ����� HashMap<�������, �ε���>�� �ε����� ã�Ƽ�
 * �ش� ArrayList���� ������ �־��ָ�ȴ�!!!
 * �ᱹ �ٽ� �������� �������� ���ϴ� ������ ������ �ٽ������� �ʿ��� �� �������� �����غ��� 
 * �װ͸� ���ϸ� �ȴٴ� ���ε�� ����Ǯ���� �Ǹ����� ��ƾ��Ѵ�. �� �̿��� ������ ���ʿ��ϴ�.
 * if()�� �ڿ� ;������... ���� ��޵ȴٱ�..
 * �� �����غ��� query������ ���� ������ ����.. index query�� ���� ���鼭 �״�� �־��൵ �ǰڴ�.
 */
import java.util.*;
class PGM_RankingSearch {
    public int[] solution(String[] info, String[] query) {
        //108���� ���ո��� ��������Ʈ�� ����� ���� �ʱ�ȭ
        HashMap<String, Integer> idxMap = new HashMap<>(); // String�� ���� Index�� ã������ Map�� ���
        ArrayList<Integer>[][][][] scores = new ArrayList[4][3][3][3];
        idxMap.put("-", 0); //����
        
        idxMap.put("java", 1); // ���
        idxMap.put("cpp", 2);
        idxMap.put("python", 3);
        
        idxMap.put("backend", 1); // ����
        idxMap.put("frontend", 2);
        
        idxMap.put("junior", 1); // ��� 
        idxMap.put("senior", 2);
        
        idxMap.put("chicken", 1); // �ҿ�Ǫ��
        idxMap.put("pizza", 2);
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        scores[i][j][k][l] = new ArrayList<Integer>();
                    }
                }
            }
        }
        
        // �־��� info �Է¿� ���� 108���� ��������Ʈ �����
        for(String i : info) {
            String[] one = i.split(" ");
            int lang = idxMap.get(one[0]);
            int duty = idxMap.get(one[1]);
            int career = idxMap.get(one[2]);
            int food = idxMap.get(one[3]);
            int score = Integer.parseInt(one[4]);
           
            scores[lang][duty][career][food].add(score);
            scores[0][0][0][0].add(score);
            
            scores[0][duty][career][food].add(score);
            scores[lang][0][career][food].add(score);
            scores[lang][duty][0][food].add(score);
            scores[lang][duty][career][0].add(score);
            
            scores[0][0][career][food].add(score);
            scores[0][duty][0][food].add(score);
            scores[0][duty][career][0].add(score);
            scores[lang][0][0][food].add(score);
            scores[lang][0][career][0].add(score);
            scores[lang][duty][0][0].add(score);
            
            scores[0][0][0][food].add(score);
            scores[0][0][career][0].add(score);
            scores[0][duty][0][0].add(score);
            scores[lang][0][0][0].add(score);
        }
        
        // �̺�Ž���� ���� ���� 
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        Collections.sort(scores[i][j][k][l], Collections.reverseOrder());
                    }
                }
            }
        }
        
        int[] answer = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            String[] one = query[i].split(" ");
            // 0 2 4 6(�ε��� ����) + 7(����)
            int lang = idxMap.get(one[0]);
            int duty = idxMap.get(one[2]);
            int career = idxMap.get(one[4]);
            int food = idxMap.get(one[6]);
            //System.out.println(one[0] +" "+ one[2]+" "+one[4]+" "+one[6]+" "+one[7]);
            int score = Integer.parseInt(one[7]);
            ArrayList<Integer> list = scores[lang][duty][career][food];
            int len = list.size();
            if(len > 0 && list.get(0) >= score)
                answer[i] = binarySearch(list, score, 0, len-1);
            else //���̰� 0�̰ų� ���������̴� ù��° ���ڰ� ����ū�� �װ� ������������ �۴ٸ� ���� 0�̴�.
                answer[i] = 0;
        }
        
      
        return answer;
    }
    /*
     * �̺�Ž�� �Լ�
     * �Ϲ����� �̺�Ž������ �ٸ� ����, �� ã�� �� �ƴ϶� ���� �������� ū �ּ������� ã�ƾ��Ѵ�.
     * ������ ���� ���� ���ϰ� �Ǹ� liear search�� ã���ش�.
     * @param : ArrayList<Integer> ������ �ش��ϴ� �������� ��� ����Ʈ (���������ӿ� ����)
     * @param : score ��������
     * @return : �״�� ���信 �� �ε��� ��
     */
    static int binarySearch(ArrayList<Integer> list, int score, int left, int right) {
        if(right - left < 5) {
            for(int i = left; i <= right; i++) {
                if(list.get(i) < score)
                    return i;
            }
            return right+1;
        }
        int mid  = (left + right) / 2;
        if(list.get(mid) < score) {
            return binarySearch(list, score, left, mid-1);
        }
        else 
            return binarySearch(list, score, mid+1, right);
    }
}