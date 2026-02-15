/*
Q. Combination Sum
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]] */

class Solution {
    public void backtrack(List<List<Integer>> ans, List<Integer> combinations, int index, int target, int[] candidates){
        if(index==candidates.length){
            if(target==0)
            ans.add(new ArrayList<>(combinations));
            return;
        }
        //case 1-> pick the same integer
           //subtract it from the candidate to see if that element<= target
           if(candidates[index]<=target){
            //add that element in combinations
            combinations.add(candidates[index]);
           backtrack(ans, combinations, index, target-candidates[index], candidates);
           //while we backtrack, we remove that element from combinations
           //since we added at back, we remove from the back
           combinations.remove(combinations.size()-1);
           }
        //case 2-> proceed to the next integer
          backtrack(ans, combinations, index+1, target, candidates);
           }
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> combinations= new ArrayList<>();
        backtrack(ans, combinations, 0, target, candidates);
        return ans;
    }
}
