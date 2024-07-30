package com.graymatter;

public class JunitMethods {


	public int add(int a, int b) {
		return a+b;
	}
	public int subtract(int a, int b) {
		return a-b;
	}
	public int mul(int a, int b) {
		return a*b;
	}
	//try double and float
	public int divide(int a, int b) {
		return a/b;
	}
	
	public int findKey(int[] arr, int key) {
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==key) {
				return i;
			}
		}
		return -1;

	}
	
	
	public static int[] arrayEquals(int[] arr) {
		return arr;
	}

	public static String checkString() {
		String s = null;
		return s;
	}
	
	public Student createStudent() {
		Student s =  new  Student("abc", 1,12);
		return s;
	}
	

	
	
	
	public static void main(String[] args) {

		
	}
	
}
