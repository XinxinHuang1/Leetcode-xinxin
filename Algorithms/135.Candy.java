/**
 There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 */

class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 0)
            return 0;
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                candy[i] = candy[i-1] + 1;
            }
        }
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candy[i] = Math.max(candy[i], candy[i+1] + 1);
            }
        }
        int sum = 0;
        for(int c : candy){
            sum += c;
        }
        return sum;
    }
}

/*
    1 2 3 4 2 1 1 
init1 1 1 1 1 1 1
 l 1 2 3 4 1 1 1 
 r 1 2 3 4 2 1 1 candy[i] = Math.max(candy[i], candy[i+1] + 1)
 each child may have a left and a right neighbor
left:
right: 
start from 2nd child, if higher grade, candy = leftCandy + 1
*/