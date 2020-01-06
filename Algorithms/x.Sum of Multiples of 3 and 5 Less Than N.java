class sumNumber{

    public static int calcSum(int n){
        int sum = 0;
        for(int i = 3; i < n; i++){
            if(i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(calcSum(1000));
    }
}