package demo;

public class FindPrefix {

	public static void main(String[] args) {

//		Given an array of strings, write a program to find the longest common prefix among all the strings. If there is no common prefix, return an empty string. 
//		Example: 
//			Input: ["flower", "flow", "flight"] 
//			Output: "fl"

		String[] flowers = { "flower", "flow", "float" };
		int index = 0;
		

		for (int j = 0; j < flowers[0].length(); j++) {
			boolean flag = true;
			for (int i = 0; i < flowers.length-1; i++) {
				if(flowers[i].charAt(j) != flowers[i+1].charAt(j)) {
					flag = false;
				}
			}
			if(flag) {
				index++;
			} else {
				break;
			}
		}
		System.out.println("The longest prefix is: "+flowers[0].substring(0, index));
	}

}
