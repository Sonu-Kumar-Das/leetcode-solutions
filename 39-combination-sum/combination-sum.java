class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    private void dfs(int[] cand, int remaining, int start,
                     List<Integer> path, List<List<Integer>> res) {

        if (remaining == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < cand.length; i++) {
            int x = cand[i];
            if (x > remaining) break; 

            path.add(x);
            dfs(cand, remaining - x, i, path, res); 
            path.remove(path.size() - 1);
        }
    }
}