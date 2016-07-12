package leetcode;
import java.util.*;

public class leetcode251 implements Iterator<Integer> {
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;
    
    public void Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();    
    }

    @Override
    public Integer next() {
        hasNext();
        return j.next();
    }

    @Override
    public boolean hasNext() {
        while((j == null || !j.hasNext()) && i.hasNext()){
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
    }
}

//***************************************************************
class Vector2D implements Iterator<Integer> {
    Queue<Iterator<Integer>> queue;
    Iterator<Integer> current = null;
    
    public Vector2D(List<List<Integer>> vec2d) {
        queue = new LinkedList<Iterator<Integer>>();
        for(int i = 0; i < vec2d.size(); i++){
            queue.add(vec2d.get(i).iterator());
        }
        current = queue.poll();
    }

    @Override
    public Integer next() {
        if(!current.hasNext()) return -1;
        return current.next();
    }

    @Override
    public boolean hasNext() {
        while(current == null || !current.hasNext()){
            if(!queue.isEmpty()){
                current = queue.poll();
            }
            else return false;
        }
        return true;
    }
}

