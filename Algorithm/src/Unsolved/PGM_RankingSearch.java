package Unsolved;

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
 * --- ���ϴ� ���Ǹ� ���� ������ �ٲ� �����̴�. ---
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
 */
import java.util.*;
class PGM_RankingSearch {
    public int[] solution(String[] info, String[] query) {
        HashMap<String, TreeSet<Candidate>> map = new HashMap<>();
        HashMap<String, TreeSet<Candidate>> cache = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < info.length; i++) {
            String[] oneInfo = info[i].split("\\s");
            Candidate cur = new Candidate(i,
                                         oneInfo[0],
                                         oneInfo[1],
                                         oneInfo[2],
                                         oneInfo[3],
                                         Integer.parseInt(oneInfo[4]));
            for(int j = 0; j < oneInfo.length - 1; j++) {
                String key = oneInfo[j];
                if(!map.containsKey(key)) {
                    map.put(key, new TreeSet<Candidate>());
                    map.get(key).add(cur);
                }
                else
                    map.get(key).add(cur);
            }  
        }
        TreeSet<Candidate> queAllSet = new TreeSet<Candidate>();
        for(TreeSet<Candidate> s : map.values()) 
            queAllSet.addAll(s);
        
            
        
        for(int i = 0; i < query.length; i++) {
          
            String[] oneQ = query[i].split("\\s");
            String cacheKey = oneQ[0]+oneQ[2]+oneQ[4]+oneQ[6];
            
            if(cache.containsKey(cacheKey)) { // ������ ������ �װ��� ������ ĳ���صд�.
                int cutLine = Integer.parseInt(oneQ[oneQ.length - 1]);
                int cnt = 0;
                for(Candidate c : cache.get(cacheKey)) {
                    if(c.score < cutLine)
                        break;
                    cnt++;
                }
                ans.add(cnt); 
                continue; // �� �Ʒ��� �ڿ������� ĳ�ÿ� ���� ���� ������ �װ��� �����̴�.
            }
            TreeSet<Candidate> queSet = new TreeSet<Candidate>(queAllSet);
            for(int j = 0; j < oneQ.length-1; j++) {
                if(oneQ[j].equals("and")) continue;
                if(oneQ[j].equals("-"))  continue;
                
                if(map.containsKey(oneQ[j]))
                    queSet.retainAll(map.get(oneQ[j]));
                else {
                    queSet.clear(); 
                    break;
                }
            }
            
            int cutLine = Integer.parseInt(oneQ[oneQ.length - 1]);
            int cnt = 0;
            for(Candidate c : queSet) {
                if(c.score < cutLine) 
                    break;
                cnt++;
                    
            }
            ans.add(cnt); 
            cache.put(cacheKey, queSet);
        }
        
        
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
            //System.out.println(answer[i]);
        }
        
        return answer;
    }
}
class Candidate implements Comparable<Candidate> {
    int id;
    String language;
    String position;
    String career;
    String soulFood;
    int score;
    public Candidate(int i, String l, String p, String c, String s, int sc) {
        id = i;
        language = l;
        position = p;
        career = c;
        soulFood = s;
        score = sc;
    }
    public String toString() {
        return (id+1)+" "+language+" "+position+" "+career+" "+soulFood+" "+score;
    }
    public int compareTo(Candidate o) {
        return o.score - this.score;
    }
     
}