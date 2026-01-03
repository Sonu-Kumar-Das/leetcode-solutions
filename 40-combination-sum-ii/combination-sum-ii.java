class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int[] cand, int remaining, int start,
                           List<Integer> path, List<List<Integer>> res) {

        if (remaining == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < cand.length; i++) {
            
            if (i > start && cand[i] == cand[i - 1]) continue;

            int x = cand[i];
            if (x > remaining) break; 

            path.add(x);
            backtrack(cand, remaining - x, i + 1, path, res); 
            path.remove(path.size() - 1);
        }
    }
}