package com.company.leetcodeproblems;

import java.util.Arrays;
import java.util.List;

public class OptimizeIncentiveValue {

    public static int getMaxValue(int budget, List<Incentive> incentives){

        int totalRunningCost = 0;
        int maxValue = Integer.MIN_VALUE;
        int runningValue = 0;

        int startingWindow = 0;

        for (Incentive currentIncentive : incentives) {
            runningValue += currentIncentive.getValue();
            totalRunningCost += currentIncentive.getCost();

            while (totalRunningCost > budget) {
                Incentive removeIncentive = incentives.get(startingWindow);
                totalRunningCost -= removeIncentive.getCost();
                runningValue -= removeIncentive.getValue();
                startingWindow++;
            }

            maxValue = Math.max(maxValue, runningValue);

        }

        System.out.println("Congratulations, you have received $" + maxValue + " in incentives");
        return maxValue;
    }

    public static class Incentive {
        String name;
        int value;
        int cost;

        public Incentive (String name, int value, int cost) {
            this.name = name;
            this.value = value;
            this.cost = cost;
        }
        public String getName() {
            return this.name;
        }

        public int getValue() {
            return this.value;
        }

        public int getCost() {
            return this.cost;
        }
    }

    public static void main(String[] args) {
        Incentive bagIncentive = new Incentive(
                "Checked Bag",
                100,
                60
        );

        Incentive mealIncentive = new Incentive(
                "Meal",
                45,
                30
        );

        Incentive upgradeIncentive = new Incentive(
                "upgrade",
                60,
                40
        );

        List<Incentive> incentives = Arrays.asList(bagIncentive, mealIncentive, upgradeIncentive);
        int budget = 75;
        System.out.println(OptimizeIncentiveValue.getMaxValue(budget, incentives));
    }
}
