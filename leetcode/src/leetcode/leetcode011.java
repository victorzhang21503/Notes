package leetcode;

public class leetcode011 {
	 public int maxArea(int[] height) {
	        if(height == null) return -1;
	        int low = 0;
	        int high = height.length -1;
	        int res = 0;
	        while(high > low){
	            int h = Math.min(height[low] , height[high]);
	            res = Math.max(res, h * (high - low));
	            if (height[high] > height[low]){
	                low++;    
	            }
	            else{
	                high--;    
	            } 
	        }
	        return res;
	    }
}
