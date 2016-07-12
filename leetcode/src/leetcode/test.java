package leetcode;
import java.util.*;

public class test {
	public static void main(String args[]){
		/*
		List<Integer> nums = new LinkedList<Integer>();
		//nums.add(1);
		Iterator<Integer> i = nums.iterator();		
		System.out.println(i.next());
		//System.out.println(i.next());
		 * 
		 */
		
		String str = "zhang";
		process(str);
		System.out.println("true");
		
		if (str.substring(5) == "") System.out.println("true");
		else System.out.println("false");
		System.out.println(str.substring(4));
	}
	
	private static void process(String str){
		str += "meng";
	}
}
