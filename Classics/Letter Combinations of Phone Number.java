/* Q. Letter Combinations of a Phone Number
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
*/



class Solution {
    public void solve(  List<String> ans, String[] mapping, String output, int idx, String digits){
        if(idx == digits.length() ){
            ans.add(output);
            return;
        }
        int number= digits.charAt(idx)-'0';
        String values= mapping[number];
        for(int i=0; i<values.length(); i++){
            output=output+values.charAt(i);
            solve(ans, mapping, output, idx+1, digits);
            output=output.substring(0, output.length()-1);
        }

    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String mapping[]={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String output="";
        solve(ans, mapping,output, 0, digits);
        return ans;
    }
}
