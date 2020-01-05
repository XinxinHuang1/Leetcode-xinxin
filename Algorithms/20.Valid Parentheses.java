//20.Valid Parentheses - Easy
//Solution 1: Stack
class Solution {
    public boolean isValid(String s) {
        
        if(s.length() % 2 == 1 )
            return false;
        
        Stack<Character> stack = new Stack<>();//FILO
        for(char c : s.toCharArray()){
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            //string should start with ({[
            else if(stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();//empty string is also valid
    }
}

//Solution 2: HashMap, Stack
class Solution {
    
    private HashMap<Character, Character> map;
    
    public Solution(){
        this.map = new HashMap<>();
        this.map.put(')', '(');
        this.map.put(']', '[');
        this.map.put('}', '{');
    }

    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(this.map.containsKey(c)){
                char c1 = stack.empty() ? '#' : stack.pop();
                if(c1 != this.map.get(c))
                    return false;
            }
            else{
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}
//Time O(n), Space O(n)