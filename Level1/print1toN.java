// Print 1 to N
// Input: 5 Output: 12345

class Main {
    public static void print1toN(int n){
        if(n<1){
            return;
        }
           
        print1toN(n-1);
        System.out.print(n);
     
    }
    public static void main(String[] args) {
        print1toN(5);
    }
}
