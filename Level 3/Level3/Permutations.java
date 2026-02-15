/* Q. Permutations
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

*/
class Solution {
    private void solve(List<List<Integer>> ans, int[] nums, int index){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num: nums) temp.add(num);
            ans.add(temp);
            return ;
        }
        for(int j= index; j<nums.length; j++){
            swap(nums, index, j);
            solve(ans, nums, index+1);
            swap(nums, index, j);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp= nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> ans= new ArrayList<>();
       solve(ans,nums , 0);
       return ans; 
    }
}
