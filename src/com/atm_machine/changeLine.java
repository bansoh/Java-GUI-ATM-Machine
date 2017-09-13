package com.atm_machine;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class changeLine {
	BufferedReader buffer = null;
	String line = "";
	Scanner scan = new Scanner(System.in);
	String file;
	String newLine;
	File File = new File("temp.txt");
	int lnNum;
	int i;
	public changeLine(){
		i = 1;
	}
	
	public void changeText(String fileName, String nLine, int lineNum){
		file = fileName;
		lnNum = lineNum;
		newLine = nLine;
		try{
		buffer = new BufferedReader(new FileReader(file));
		line = buffer.readLine();
		
	
		if(!File.exists()){
			File.createNewFile();
		}
		
		PrintWriter pw = new PrintWriter(File);
	
		while (line!=null){
		
			if(i == lnNum){
				pw.println(newLine);
			}
			else if (i!= lnNum){
				pw.println(line);
			}
			line = buffer.readLine();
			i++;
		
			
			
		}
		pw.close();
		File oldFile = new File("temp.txt");
		File newFile = new File(file);
		if (oldFile.renameTo(newFile)){
			System.out.println(oldFile.getName()+" renamed to "+ newFile.getName());
		}
		else {
			System.out.println("failed to rename file");
		}
		
		
		  
		}catch(Exception e){
			System.out.println(e);
			}
		
	}

}
