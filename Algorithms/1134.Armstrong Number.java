class Solution {
    public boolean isArmstrong(int N) {
        int digits = (int) Math.log10(N) +1;
        int k = N;
        int sum = 0;
        while(k > 0){
            sum += Math.pow(k%10, digits);
            k /= 10;
        }
        return sum == N;
    }
}