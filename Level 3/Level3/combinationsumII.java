/* Q. Combination Sum II
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]  */

class Solution {
    public void backtrack(List<List<Integer>> ans,List<Integer> ds,int[] arr, int target, int index ){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i= index; i<arr.length; i++){
            // i>index: It prevents starting two identical branches at the same level
            // arr[i]==arr[i-1] removes duplicate at the same level
            if(i>index && arr[i]== arr[i-1]) continue;
            if(arr[i]> target) break;
            ds.add(arr[i]);
            backtrack(ans, ds, arr, target-arr[i], i+1);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> ds= new ArrayList<>();
        backtrack(ans, ds, candidates, target,0);
        return ans;
    }
}
