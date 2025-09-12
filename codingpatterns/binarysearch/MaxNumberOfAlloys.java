package binarysearch;

import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/maximum-number-of-alloys/description/">Maximum Number of Alloys</a>
 */
public class MaxNumberOfAlloys {

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int maxUnits = 0;
        for (int i = 0; i < k; i++) {
            int count = maxAlloysForMachine(composition.get(i), stock, cost, budget);
            if (count > maxUnits) {
                maxUnits = count;
            }
        }
        return maxUnits;
    }


    public int maxAlloysForMachine(List<Integer> composition, List<Integer> stock, List<Integer> cost, int budget) {
        int low = 0, high = findUpperBound(composition, stock, cost, budget);
        int count = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean canMake = canMakeAlloys(mid, composition, stock, cost, budget);
            if (canMake) {
                count = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return count;
    }

    private int findUpperBound(List<Integer> composition, List<Integer> stock, List<Integer> cost, int budget) {
        int minCost = Integer.MAX_VALUE;
        for (int c : cost) {
            if (minCost > c) {
                minCost = c;
            }
        }
        int unitsPossibleWithStock = Integer.MAX_VALUE;
        for (int i = 0; i < stock.size(); i++) {
            int units = stock.get(i) / composition.get(i);
            if (units < unitsPossibleWithStock) {
                unitsPossibleWithStock = units;
            }
        }
        return (budget / minCost) + unitsPossibleWithStock;
    }

    private boolean canMakeAlloys(long n, List<Integer> composition, List<Integer> stock, List<Integer> cost, int budget) {
        long requiredBudget = 0;
        for (int i = 0; i < composition.size(); i++) {
            long required = composition.get(i) * n;
            long needToBuy = 0;
            if (stock.get(i) < required) {
                needToBuy = required - stock.get(i);
            }
            requiredBudget += (needToBuy * cost.get(i));
            if (requiredBudget > budget) {
                return false;
            }
        }
        return budget >= requiredBudget;
    }
}
