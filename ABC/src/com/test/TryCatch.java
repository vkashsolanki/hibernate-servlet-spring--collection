package com.test;

public class TryCatch {
	
	
	
	public static void main(String[] args) {
		
		
		try {
			
			int i=10/2;
			
			System.out.println(i);
		
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
		finally {
			System.out.println("ye hamesh chelega hi chalega ");
		}
		
		System.out.println("Baki ka Code hai");
	}

}
