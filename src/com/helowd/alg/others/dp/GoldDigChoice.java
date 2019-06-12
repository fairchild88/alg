package com.helowd.alg.others.dp;

/**
 * 描述：
 * <p>
 * Created by fei on 2019/6/3.
 */
public class GoldDigChoice {
    public static void main(String[] args) {
        int golden[] = {500, 400, 350, 200, 250};
        int workforce[] = {5, 5, 1, 1, 1};
        int totalForce = 10;
        int decision_table[] = new int[totalForce];
        int previous_decision_table[] = new int[totalForce];
        for (int godenindex = 0; godenindex < golden.length; godenindex++) {
            for (int workindex = 0; workindex <= totalForce; workindex++) {
                if (workindex < workforce[godenindex]) {
                    decision_table[workindex] = 0;
                } else {
                    decision_table[workindex] =  Math.max(previous_decision_table[workindex - workforce[godenindex]] + golden[godenindex]
                            , previous_decision_table[workindex]);
                }
            }

            System.arraycopy(decision_table, 0, previous_decision_table, 0, totalForce);

            printDesicionTable(decision_table);
        }
    }

    private static void printDesicionTable(int[] decisionTable) {
        for (int i = 1; i <= decisionTable.length; i++) {
            System.out.print(decisionTable[i] + "\t");
        }
        System.out.println();
    }
}
