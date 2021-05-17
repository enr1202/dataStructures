package com.company.leetcodeproblems;

import java.util.Arrays;
import java.util.List;

public class OptimizeIncentiveValue {

    public static int getMaxValue(int budget, List<Incentive> incentives) {

        int totalRunningCost = 0;
        int maxValue = Integer.MIN_VALUE;
        int runningValue = 0;

        for (int i = 0; i < incentives.size(); i++) {
            Incentive startIncentive = incentives.get(i);
            totalRunningCost = startIncentive.getCost();
            runningValue = startIncentive.getValue();
            for (int j = i + 1; j < incentives.size(); j++) {
                Incentive nextIncentive = incentives.get(j);
                if (totalRunningCost + nextIncentive.getCost() <= budget) {
                    totalRunningCost += nextIncentive.getCost();
                    runningValue += nextIncentive.getValue();
                    maxValue = Math.max(runningValue, maxValue);
                }
            }
        }
        System.out.println("Congratulations, you have received $" + maxValue + " in incentives");
        return maxValue;
    }

    public static class Incentive {
        String name;
        int value;
        int cost;

        public Incentive(String name, int value, int cost) {
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

        Incentive bagIncentive = new Incentive(
                "Checked Bag",
                100,
                60
        );


        Incentive drinkIncentive = new Incentive(
                "drink",
                20,
                5
        );

        List<Incentive> incentives = Arrays.asList(mealIncentive,bagIncentive, upgradeIncentive, drinkIncentive);
        int budget = 75;
        System.out.println(OptimizeIncentiveValue.getMaxValue(budget, incentives));
    }
}
