package PGM_Level2;


/*
 * 2021.06.22
 * PGM Ÿ�ٳѹ� https://programmers.co.kr/learn/courses/30/lessons/43165
 * ���� ���Ʈ������ Ǯ����. 2^20 �� 100��? �ۿ� ���� �ʱ� �����̴�.  
 * �̰� ��� dfs/bfs�� Ǯ�� �˾ƺ��߰ڴ�. �� Ǯ�̵� dfs�� �����ϴ� �ǰ�??
 * ��·�� �ٸ����Ǯ�� ���� ���� cnt�� ���������� �״µ� ���� ã���� 1�� return�ϰ� �ƴϸ� 0�� �����ؼ�
 * return �Լ�(-�� �ֱ�) + �Լ�(+�� �ֱ�)�� ����������  
 */

class PGM_TargetNumber {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        searchAll(numbers, target, 0, numbers[0]);
        searchAll(numbers, target, 0, -numbers[0]);
        int answer = cnt;
        return answer;
    }
    static void searchAll(int[] numbers, int target, int curIdx, int cur) {
        if(curIdx == numbers.length - 1 && cur == target)
            cnt++;
        
        if(curIdx+1 < numbers.length) {
            searchAll(numbers, target, curIdx+1, cur+numbers[curIdx+1]);
            searchAll(numbers, target, curIdx+1, cur-numbers[curIdx+1]);
        }
            
    }
}

//class Solution {
//    public int solution(int[] numbers, int target) {
//        int answer = 0;
//        answer = dfs(numbers, 0, 0, target);
//        return answer;
//    }
//    int dfs(int[] numbers, int n, int sum, int target) {
//        if(n == numbers.length) {
//            if(sum == target) {
//                return 1;
//            }
//            return 0;
//        }
//        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
//    }
//}