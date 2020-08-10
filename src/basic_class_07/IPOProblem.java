package basic_class_07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Paul Z on 2020/2/22
 *
 * 输入： 参数1，正数数组costs 参数2，正数数组profits 参数3，
 * 正数k 参数4，正数m
 * costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花
 * 费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多
 * 做k个项目 m表示你初始的资金
 * 说明：你每做完一个项目，马上获得的收益，可以支持你去做下
 * 一个 项目。
 * 输出： 你最后获得的最大钱数。
 */
public class IPOProblem {

    static class Project{
        int c;
        int p;

        Project(int c, int p){
            this.c = c;
            this.p = p;
        }
    }

    private static class MinCostComparator implements Comparator<Project>{

        @Override
        public int compare(Project o1, Project o2) {
            return o1.c - o2.c;
        }
    }

    private static class MaxProfitComparator implements Comparator<Project>{

        @Override
        public int compare(Project o1, Project o2) {
            return o2.p - o1.p;
        }
    }

    private static int findMaxProfit(int k, int m, int[] costs, int[] profit){
        Project[] projects = new Project[costs.length];
        for (int i = 0; i < costs.length; i++)
            projects[i] = new Project(costs[i], profit[i]);

        PriorityQueue<Project> minCostsHeap = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Project> maxProfitHeap = new PriorityQueue<>(new MaxProfitComparator());
        minCostsHeap.addAll(Arrays.asList(projects));

        for (int i = 0; i < k; i++){
            while (!minCostsHeap.isEmpty() && minCostsHeap.peek().c <= m)
                maxProfitHeap.add(minCostsHeap.poll());
            if (maxProfitHeap.isEmpty())
                return m;
            m += maxProfitHeap.poll().p;
        }
        return m;
    }

    public static void main(String[] args) {

    }
}
