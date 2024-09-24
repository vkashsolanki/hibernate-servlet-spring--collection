package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TryWithResource {

	public static void main(String[] args) {
		
		
		
		//try (FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\91886\\Desktop\\AsuDesk\\trywithresourcecheckfile\\abc.txt")){
			
		try(FileOutputStream fileInputStream = new FileOutputStream(new File("C:\\Users\\91886\\Desktop\\AsuDesk\\trywithresourcecheckfile\\abc.txt"))){
			String s= "hi haow are you?";
			byte[] bytes = s.getBytes();
			
			
		
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}

}
