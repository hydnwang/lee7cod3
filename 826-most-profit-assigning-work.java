// refer to:
// https://leetcode.com/problems/most-profit-assigning-work/discuss/127031/C++JavaPython-Sort-and-Two-pointer
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // bind difficulties and profit together
        int n = difficulty.length;
        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobs.add(new int[] { difficulty[i], profit[i] });
        }

        // sort jobs and workers in ascending order
        Collections.sort(jobs, (x, y) -> x[0] - y[0]);
        Arrays.sort(worker);

        int j = 0, best = 0, res = 0;
        for (int cap : worker) {
            while (j < n && cap >= jobs.get(j)[0]) {
                best = Math.max(best, jobs.get(j)[1]);
                j++;
            }
            res += best;
        }
        return res;
    }
}