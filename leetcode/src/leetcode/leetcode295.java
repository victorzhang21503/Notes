package leetcode;
import java.util.*;
public class leetcode295 {
	private Queue<Long> small = new PriorityQueue(),
        large = new PriorityQueue();
// Adds a number into the data structure.
	public void addNum(int num) {
		large.add((long) num);
		small.add(-large.poll());
		if(large.size() < small.size()){
		large.add(-small.poll());
	}
}

// Returns the median of current data stream
	public double findMedian() {
		return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
	}
}
