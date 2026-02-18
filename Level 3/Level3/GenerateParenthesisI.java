class Solution {
    public boolean isValid(String curr){
        char[] brackets=curr.toCharArray();
        int count=0;
        for(char ch: brackets){
            if(ch=='(') count++;
            else count--;
            if(count<0) return false;
        }
        return count==0;
    }
    public void solve(List<String> result, String curr, int n){
        if(curr.length()==2*n){
            if(isValid(curr)){
            result.add(new String(curr));
            }
            return;
        }
        //case 1: when character is "("
        curr= curr + "(";
        solve(result, curr, n);
       curr= curr.substring(0, curr.length()-1);

        //case 2: when character is ")"
        curr= curr + ")";
        solve(result, curr, n);
        curr= curr.substring(0, curr.length()-1);

    }
    public List<String> generateParenthesis(int n) {
        List<String> str= new ArrayList<>();
        String curr="";
        solve(str, curr, n);
        return str;
    }
}
