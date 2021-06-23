package PGM_Level1;


import java.util.*;
/*
 * ���Ŀ��� �� ������ ������ �ٸ� ������ ������� ���� ������ Ŭ���� �����غþ���� 
 * ���߿� �����ϴ� ��ü �����ٰ� �ٽ��ؼ� �ð�����
 */
class PGM_FailRatio {
    public int[] solution(int N, int[] stages) {
        Stage[] stage = new Stage[N];
        for(int i = 0; i < N; i++) {
            stage[i] = new Stage(i, 0, 0, 0);
        }
        
        double allClear = 0;
        for(int i = 0; i < stages.length; i++) {
            if(stages[i] == N + 1) 
                allClear++;
            else
                stage[stages[i]-1].unPass++;
        }
        stage[N-1].pass = stage[N-1].unPass + allClear; //�������� N�� ������ ��� ��
        for(int i = N-2; i >= 0; i--) {
            stage[i].pass = stage[i+1].pass + stage[i].unPass; 
            //System.out.println(stage[i].idx+1 + " : " + stage[i].unPass + " / " + stage[i].pass + " = " + stage[i].failRatio);
        }
        for(int i = 0; i < N; i++) {
            if(stage[i].pass == 0)
                stage[i].failRatio = 0;
            else
                stage[i].failRatio = (stage[i].unPass * 100) / stage[i].pass; // 100 �Ȱ��ϸ� �̰� 0�Ǵ� 1�̵ȴٱ�~
            
            System.out.println(stage[i].idx+1 + " : " + stage[i].unPass + " / " + stage[i].pass + " = " + stage[i].failRatio);
        }
        Arrays.sort(stage);
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = stage[i].idx+1; 
        }
        
        
        return answer;
    }
}
class Stage implements Comparable<Stage> {
    int idx;
    double pass;
    double unPass;
    double failRatio;
    public Stage(int idx, int pass, int unPass, int failRatio) {
        this.idx = idx;
        this.pass = pass;
        this.unPass = unPass;
        this.failRatio = failRatio;
    }
    
    public int compareTo(Stage o) {
        if(o.failRatio == this.failRatio) {
            if(this.idx - o.idx > 0)
                return 1;
            else
                return -1;
        }
             
        else if(this.failRatio - o.failRatio > 0)
            return -1;
        else
            return 1;
    }
    
}


// class Solution {
//     public int[] solution(int N, int[] stages) {
//         int[] answer = new int[N];
//         double[] tempArr = new double[N];
//         int arrLength = stages.length;
//         int idx = arrLength;
//         double tempD = 0;
//         int tempI = 0;
//         for (int i = 0; i < arrLength; i++) {
//             int stage = stages[i];
//             if (stage != N + 1)
//                 answer[stage - 1] += 1;
//         }
//         for (int i = 0; i < N; i++) {
//             int personNum = answer[i];
//             tempArr[i] = (double) personNum / idx;
//             idx -= personNum;
//             answer[i] = i + 1;
//         }

//         for (int i = 0; i < N; i++) {
//             for (int j = 1; j < N - i; j++) {
//                 if (tempArr[j - 1] < tempArr[j]) {
//                     tempD = tempArr[j - 1];
//                     tempArr[j - 1] = tempArr[j];
//                     tempArr[j] = tempD;

//                     tempI = answer[j - 1];
//                     answer[j - 1] = answer[j];
//                     answer[j] = tempI;
//                 }
//             }
//         }
//         return answer;
//     }
// }