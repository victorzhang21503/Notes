package leetcode;
import java.util.*;

public class leetcode281 {
	private Iterator<Integer> i, j, temp;
    public void ZigzagIterator(List<Integer> v1, List<Integer> v2) {
         i = v2.iterator();
         j = v1.iterator();
    }

    public int next() {
        if(j.hasNext()){
            temp = j;
            j = i;
            i = temp;
        }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }
    
}

class ZigzagIterator {
    LinkedList<Iterator<Integer>> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
         list = new LinkedList<Iterator<Integer>>();
         if(!v1.isEmpty()) list.add(v1.iterator());
         if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator<Integer> poll = list.remove();
        int result = (Integer)poll.next();
        if(poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
