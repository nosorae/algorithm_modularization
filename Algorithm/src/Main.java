import java.io.*;
import java.util.*;


/*
 * ���� 1707 �̺� �׷���
 * 
 */
class Main {
  
    static BufferedReader br;
	static int loop; // ��ü ����Ƚ��
	static int vNum; // ���� ����
	static int eNum; // ���� ����
	static LinkedList<Integer>[] graph; // �׷��� 
	static boolean[] check; // ���� �湮 ���� 
	
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        loop = Integer.parseInt(br.readLine());
        
        for(int loopCnt = 0; loopCnt < loop; loopCnt++) {
            StringTokenizer st  = new StringTokenizer(br.readLine());
           
            //���� ��, ���� �� �Է�
            int vNum = Integer.parseInt(st.nextToken());
            int eNum = Integer.parseInt(st.nextToken());
            
            //�׷��� �ʱ�ȭ
            graph = new LinkedList[vNum+1];
            for(int i = 1; i <= vNum; i++) {
                graph[i] = new LinkedList<Integer>();
            }
            
            // ���� �湮 ���� üũ�ϴ� �迭 �ʱ�ȭ
            check = new boolean[vNum+1];
            
            int divCnt = 0; //�� �������� ī��Ʈ 
            
            //�湮 ���غ� ��� ������ �������� dfs�õ� 
            //dfs�õ� Ƚ���� �� ���� ����
            // ���� 2������ �� �ι��� dfs�� �õ��ؾ��Ѵ�.
            for(int i = 1 ; i <= vNum; i++) {
                if(!check[i]) {
                    divCnt++; //dfs �õ��� ������ ����ī��Ʈ�� 1 �����ش�.
                    if(divCnt >= 3) // �����̸� �� �˻��� �� ���� break
                        break;
                    
                    dfs(i);
                }
            }
            
           if(divCnt == 2) {
               System.out.println("YES");
           }
           else {
               System.out.println("NO");
           }
            
        }
       
    }
    static void dfs(int cur) {
        check[cur] = true;
        
        for(int next : graph[cur]) {
            if(!check[next]) {
                dfs(next);
            }
        }
    }
}