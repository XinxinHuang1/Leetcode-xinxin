
/**
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window

Example:
MovingAverage m = new MovingAverage(3);
m.next(1) = 1;
m.next(3) = (1 + 3)/2
m.next(10) = (1 + 3 + 10)/2
m.next(5) = (3 + 10 + 5)/2

 */

class MovingAverage{

    private Queue<Integer> queue;
    private int maxSize;
    private double sum;
    
    public MovingAverage(int size){
      queue = new LinkedList<>();
      maxSize = size;
      sum = 0.0;
    }
    
    public double next(int val){
      if(queue.size() == size){
        sum -= queue.poll();
      }
      queue.add(val);
      sum += val;
      return sum / queue.size();
    }
  
  }