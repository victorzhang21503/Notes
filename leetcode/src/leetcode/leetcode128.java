package leetcode;
import java.util.*;

public class leetcode128 {
	 public int longestConsecutive(int[] nums) {
	        if (nums == null || nums.length == 0) return 0;
	        int res = 0;
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int num : nums){
	            if (!map.containsKey(num)){
	                int left = (map.containsKey(num - 1) ? map.get(num -1) : 0);
	                int right = (map.containsKey(num + 1) ? map.get(num + 1) : 0);
	                int sum = left + right + 1;
	                map.put(num, sum);
	                res = Math.max(res, sum);
	                
	                map.put(num - left, sum);
	                map.put(num + right, sum);
	            }
	            
	            else{
	                continue;
	            }
	        }
	        return res;
	    }	
}
