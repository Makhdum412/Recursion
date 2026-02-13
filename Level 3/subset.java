//Input: [1,2,3]
//Output:
/*
[1, 2, 3]
[1, 2]
[1, 3]
[1]
[2, 3]
[2]
[3]
[] */
import java.util.*;
class Main {
    public static void subset(int[] arr, List<List<Integer>> ans, List<Integer> output, int index){
        if(index>= arr.length){
            ans.add(new ArrayList<>(output));
            return;
        }
        output.add(arr[index]);
        subset(arr, ans, output, index+1);
        output.remove(output.size()-1);
        subset(arr, ans, output, index+1);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output= new ArrayList<>();
        subset(arr, ans, output, 0);
        for(List<Integer> ele: ans){
            System.out.println(ele);
        }
    }
}
