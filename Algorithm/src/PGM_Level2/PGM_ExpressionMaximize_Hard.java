package PGM_Level2;

/*
 * 2021.06.27
 * PGM ���� �ִ�ȭ https://programmers.co.kr/learn/courses/30/lessons/67257
 * � ���ڰ� ���� �𸣰� ���غ��� �ִ� 3! * 100 �����ۿ� �ȵǹǷ� ���Ʈ������ �ذ�
 * ������ 3���� �켱������ Ŀ�����ϴ� ���⸦ �����ϴ� �� �� ������ �ٽ��ε� �ϴ�.
 * �켱���� Ŀ������ ����ǥ������� ��ȯ -> ���
 * ��� ��� ���غ��� : ����Լ� (placeAll)
 * ����ǥ������� ��ȯ : ���ڴ� �׳� �ְ�, �����ڴ� ���ÿ� �ִµ�, �켱���� ���� �����ڵ��� ���ÿ��� ����.(makePostfix)
 * ��� : ����ǥ����� �״�� ��� (calcPostfix)
 * ���� : split ������ �� �ǵ��� �´��� ����غ��� ���ٸ��� �ε��� �ǳ�!
 */
import java.util.*;
class PGM_ExpressionMaximize_Hard {
    static long max = 0;
    static char[] opSet = {'+', '-', '*'};
    static boolean[] check = new boolean[3];
    static int[] priority = new int[46];
    public long solution(String expression) {
        max = 0;
        placeAll("", expression);
        long answer = max;
        return answer;
    }
    static Queue<String> makePostfix(String exp) {
        String[] operands = exp.split("[-*+]");
        String[] operators = exp.split("[0-9]+"); //�̷��� �ϸ� �� �տ� ""(���ڿ�)�� ����.
        
        Stack<String> opStack = new Stack<String>();
        Queue<String> ans = new LinkedList<String>();
        for(int i = 0; i < operands.length-1; i++) {
            String operand = operands[i];
            char op = strToChar(operators[i+1]); //���� +1
            ans.add(operand);
            while(!opStack.isEmpty() && priority[strToChar(opStack.peek())] >= priority[op]) {
                ans.add(opStack.pop());
            }
            opStack.add(op+"");
        }
        ans.add(operands[operands.length-1]);
        while(!opStack.isEmpty()) {
            ans.add(opStack.pop());
        }
        
        return ans;
    }
    static char strToChar(String s) {
        char c = '*';
        switch(s) {
            case "-":
                return '-';
            case "+":
                return '+';
            case "*":
                return '*';
        }
        return c;
    }
    static long calcPostfix(Queue<String> exp) {
        Stack<Long> result = new Stack<Long>();
        while(!exp.isEmpty()) {
            String cur = exp.poll();
            
            if(cur.equals("+") || cur.equals("-") || cur.equals("*")) {
                long ord1 = result.pop();
                long ord2 = result.pop();
                switch(cur) {
                    case "+":
                        result.add(ord2 + ord1);
                        break;
                    case "-":
                        result.add(ord2 - ord1);
                        break;
                    case "*":
                        result.add(ord2 * ord1);
                }
            }
            else {
                result.add(Long.parseLong(cur));
            }
        }
        return result.pop();
    }
    static void placeAll(String pri, String exp) {
        if(pri.length() == 3) {
            char first = pri.charAt(0);
            char second = pri.charAt(1);
            char third = pri.charAt(2);
            priority[first] = 3;
            priority[second] = 2;
            priority[third] = 1;
            Queue<String> expQ = makePostfix(exp);
            long localAns = calcPostfix(expQ);
            if(localAns < 0)
                localAns = -localAns;
            if(max < localAns)
                max = localAns;
            
            return;
        }
        for(int i = 0; i < 3; i++) {
            if(!check[i]) {
                check[i] = true;
                placeAll(pri+opSet[i], exp);
                check[i] = false; 
            }
            
        }
    }
}