/**
 Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */

//Time O(1) Space O(N)
class RandomizedSet {
    
    HashMap<Integer, Integer> map; // value, index
    List<Integer> list; //index, value
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        int n = list.size();
        map.put(val, n);
        list.add(n, val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        //find the index of the value in arraylist
        int index = map.remove(val); 
        int n = list.size();
        int lastElem = list.get(n - 1);
        list.set(index, lastElem);
        map.put(lastElem, index);
        //delete
        list.remove(n - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));//exclusive
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */