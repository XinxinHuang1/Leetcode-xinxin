/*
Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
*/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        while(i < flowerbed.length){
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) 
               && (i == flowerbed.length - 1 || flowerbed[i+1] == 0)){
                flowerbed[i] = 1;
                i++;
                n--;
            }
            else
                i++;
            if(n <= 0) return true;
        }
        return false;
    }
}