package javaTut;

import java.util.ArrayList;

public class AppTest 
{
	public static void main(String[] args) {
		int myNum = 5;
		String name = "Chris";
		char letter = 'r';
		double dec = 5.88;
		float flo = (float) 3.34;
		boolean bool = true;
		
		System.out.println(myNum + " is my number");
		
		// Arrays
		int[] newArr = new int[5];
		newArr[0] = 1;
		newArr[1] = 2;
		newArr[2] = 3;
		newArr[3] = 4;
		newArr[4] = 5;
		
		System.out.println(newArr[3]);
		
		int[] newNewArr = {1,2,3,4,5};
		String[] newStringArr = {"chris","sdsd","qwee","kgj","sdfsd"};
		System.out.println(newNewArr[3]);
		
		// For Loops
		for (int i = 0; i<newArr.length; i++) {
			System.out.println("Element in array is "+newArr[i] );
		}
		
		for (String s: newStringArr) {
			System.out.println("Element in string array is "+s);
		}
		
		// If / Else 
		
		int[] num = {1,2,3,4,5,6,7,8,9};
		for (int n: num) {
			if (n % 2 == 0) {
				System.out.println(n+" is an even number");
			}
			else if (n == 1) {
				System.out.println(n+" is a prime number");
			}
			else
			{
				System.out.println(n+" is an odd number");
			}
		} 
		
		
		// Array List
		
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.add("dkdkdkdk");
		System.out.println(arrList.get(0));
		
		
		
		// String
		// String Literal
		String s = "Chief Mbongo";
		String s1 = "Joel Amuasi";
		String s2 = "Joey Akunta";
		
		// New keyword
		String s3 = new String("Welcome");
		String s4 = new String("Welcome");
		
		String ss = "This is the sample string"; 
		String[] iSplittedString =  ss.split(" ");
		System.out.println(iSplittedString[0]);
		System.out.println(iSplittedString[1]);
		System.out.println(iSplittedString[2]);
		System.out.println(iSplittedString[3]);
		System.out.println(iSplittedString[4]);
		
		// print each element in the string
		for (int i = 0; i<ss.length(); i++) {
			System.out.println("Individual characters are "+ss.charAt(i));
		}
		
		// print each element in the string in reverse order
		for (int j =ss.length()-1; j>=0; j--) {
			System.out.println("Individual characters in reverse are "+ss.charAt(j));
		}
		
		
		
	}
   
}
