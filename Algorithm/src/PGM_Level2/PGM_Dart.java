package PGM_Level2;


/*
 * 2021.07.01
 * PGM ��Ʈ https://programmers.co.kr/learn/courses/30/lessons/17682
 * 3���� ��ȸ, �� 1 2 3����
 * ��Ÿ���� ����+�������� �ι�, �������� �������� ���̳ʽ��� ����.
 * ��Ÿ���� ù��°�� ������ ù��°���� �����(�������� �����ϱ�!)
 * ��Ÿ���� ��Ÿ��� ��ø�Ǹ� �׹�, ������� ��ø�Ǹ� -�ι�
 * �ڵ� ����ϰ� ���� �� ���Խĵ� �� �����غ�
 * 42��
 */
class PGM_Dart {
    public int solution(String dartResult) {
        
        String[] numberStr = dartResult.split("[SDT][*#]*");
        int d1 = Integer.parseInt(numberStr[0]);
        int d2 = Integer.parseInt(numberStr[1]);
        int d3 = Integer.parseInt(numberStr[2]);
        int[] nums = new int[4];
        nums[1] = d1;
        nums[2] = d2;
        nums[3] = d3;
        
        int idx = 1; //���ʽ� ������ ���� �����Ѵ�.
        for(int i = 0; i < dartResult.length(); i++) {
            char cur = dartResult.charAt(i);
            if(cur == 'S') 
                idx++;
            if(cur == 'D') {
                nums[idx] = nums[idx] * nums[idx];
                idx++;
            }
            if(cur == 'T') {
                nums[idx] = nums[idx] * nums[idx] * nums[idx];
                idx++;
            }
               
        }
        
        int answer = 0;
        String[] optionStr = dartResult.split("[0-9]+[SDT]");
        for(String s : optionStr)
            System.out.println("->"+s);
        for(int i = 1; i < optionStr.length; i++) {
            if(optionStr[i].equals("*")) {
                nums[i] *= 2;
                if(idx-1 >= 0)
                    nums[i-1] *= 2;
            }
            if(optionStr[i].equals("#")) {
                nums[i] = -nums[i];
            }
        }

        return nums[1]+nums[2]+nums[3];
    }
}