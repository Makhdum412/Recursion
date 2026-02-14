/* Q. Subset II
Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
*/

class Solution {
    private void backtrack(List<List<Integer>> ans, List<Integer> ds, int idx, int[] nums){
        ans.add(new ArrayList<>(ds));
        for(int i=idx; i<nums.length; i++){
            if(i>idx && nums[i]== nums[i-1]) continue;
            ds.add(nums[i]);
            backtrack(ans, ds, i+1, nums);
            ds.remove(ds.size()-1);
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> ans = new ArrayList<>();
      backtrack(ans, new ArrayList<>(), 0, nums);
      return ans;  
    }
}
