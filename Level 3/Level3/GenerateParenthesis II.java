class Solution {
    public void solve(List<String> result, StringBuilder sb,int open, int close, int n){
        if(sb.length()==2*n){
            result.add(sb.toString());
            return;
        }
        //case 1: when character is "("
       if(open<n){
        sb.append("(");
        solve(result, sb, open+1, close, n);
        sb.deleteCharAt(sb.length()-1);
       }

        //case 2: when character is ")"
        if(close<open){
        sb.append(")");
        solve(result,sb, open, close+1, n);
        sb.deleteCharAt(sb.length()-1);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> str= new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        int open=0;
        int close=0;
        solve(str, sb, open, close, n);
        return str;
    }
}
