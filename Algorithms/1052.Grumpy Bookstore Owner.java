//1052.Grumpy Bookstore Owner

//Solution 1: Sliding Window
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfied = 0, maxMakeSatisfied = 0;
        
        for(int i = 0, win = 0; i < grumpy.length; i++){
            if(grumpy[i] == 0){
                satisfied += customers[i];
            }
            else{
                win += customers[i];//all satisfied customers;
            }
            if(i >= X){//use X to make satisfied
                win = win - grumpy[i-X] * customers[i-X];
            }
            
            maxMakeSatisfied = Math.max(win, maxMakeSatisfied);
        }
        return satisfied + maxMakeSatisfied;
    }
}
//Time: O(n)   Space: O(1) -- n = grumpy.length

//Solution 2
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        //already satisfied
        int base = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0)
                base += customers[i];
        }
        // not satisfied
        int[] unhappy = new int[customers.length];
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 1){
                unhappy[i] = customers[i];
            }
        }
        // use X
        int gain = 0;
        for(int i = 0; i < X; i++){
            gain += unhappy[i];
        }
        // get Max
        int maxSatis = gain;
        for(int i = X; i < unhappy.length; i++){
            gain += unhappy[i];
            gain -= unhappy[i-X];
            if(maxSatis < gain)
                maxSatis = gain;
        }
        return base + maxSatis;
    }
}